package com.pavan.track.controllers.implementations;

import com.pavan.track.annotations.NotNullOrBlank;
import com.pavan.track.apis.interfaces.CategoryResource;
import com.pavan.track.apis.interfaces.ItemResource;
import com.pavan.track.controllers.interfaces.CategoryController;
import com.pavan.track.entities.Category;
import com.pavan.track.exceptions.CategoryNotFoundException;
import com.pavan.track.models.dto.CategoryDto;
import com.pavan.track.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@Validated
public class CategoryControllerImpl implements CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryControllerImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CollectionModel<CategoryDto> addCategory(
            @NotEmpty(message = "Category list cannot be empty")
            List<@Valid CategoryDto> categoryDtoList) {

        List<Category> categories = categoryDtoList.stream()
                .map(e -> {
                    Category category = new Category();
                    category.setCategoryName(e.getCategoryName());
                    return category;
                })
                .collect(Collectors.toList());
        categoryDtoList = categoryRepository.saveAll(categories).stream()
                .map(category -> {
                    CategoryDto categoryDto = new CategoryDto();
                    categoryDto.setId(category.getId().toString());
                    categoryDto.setCategoryName(category.getCategoryName());
                    Link addItemLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemResource.class)
                            .addItem(categoryDto.getId(), null)).withRel("items");
                    categoryDto.add(addItemLink);
                    return categoryDto;
                }).collect(Collectors.toList());
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryResource.class)
                .getAllCategories()).withSelfRel();
        return new CollectionModel<>(categoryDtoList, link);
    }

    @Override
    public CollectionModel<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryDtoList = categoryRepository.findAll().stream()
                .map(category -> {
                    CategoryDto categoryDto = new CategoryDto();
                    categoryDto.setId(category.getId().toString());
                    categoryDto.setCategoryName(category.getCategoryName());
                    Link addItemLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ItemResource.class)
                            .addItem(categoryDto.getId(), null)).withRel("items");
                    categoryDto.add(addItemLink);
                    return categoryDto;
                }).collect(Collectors.toList());

        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryResource.class)
            .getAllCategories()).withSelfRel();
        return new CollectionModel<>(categoryDtoList, link);
    }

    @Override
    public Category findByCategoryId(
            @NotNullOrBlank(message = "Category Id cannot be blank") String categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString(categoryId));
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        }
        else {
            throw new CategoryNotFoundException("Category Id not found");
        }
    }
}
