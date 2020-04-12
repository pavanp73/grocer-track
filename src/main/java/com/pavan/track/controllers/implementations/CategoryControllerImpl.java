package com.pavan.track.controllers.implementations;

import com.pavan.track.annotations.NotNullOrBlank;
import com.pavan.track.controllers.interfaces.CategoryController;
import com.pavan.track.entities.Category;
import com.pavan.track.exceptions.CategoryNotFoundException;
import com.pavan.track.models.dto.CategoryDto;
import com.pavan.track.repositories.CategoryRepository;
import com.pavan.track.services.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryControllerImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDto> addCategory(
            @NotEmpty(message = "Category list cannot be empty")
            List<@Valid CategoryDto> categoryDtoList) {

        List<Category> categories = categoryDtoList.stream()
                .map(e -> {
                    Category category = new Category();
                    category.setCategoryName(e.getCategoryName());
                    return category;
                })
                .collect(Collectors.toList());
        return categoryRepository.saveAll(categories).stream()
                .map(category -> {
                    CategoryDto categoryDto = new CategoryDto();
                    categoryDto.setId(category.getId().toString());
                    categoryDto.setCategoryName(category.getCategoryName());
                    return categoryDto;
                }).collect(Collectors.toList());
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> {
                    CategoryDto categoryDto = new CategoryDto();
                    categoryDto.setId(category.getId().toString());
                    categoryDto.setCategoryName(category.getCategoryName());
                    return categoryDto;
                }).collect(Collectors.toList());
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
