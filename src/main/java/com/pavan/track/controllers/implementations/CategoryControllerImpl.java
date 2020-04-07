package com.pavan.track.controllers.implementations;

import com.pavan.track.controllers.interfaces.CategoryController;
import com.pavan.track.entities.Category;
import com.pavan.track.models.dto.CategoryDto;
import com.pavan.track.repositories.CategoryRepository;
import com.pavan.track.services.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CategoryControllerImpl implements CategoryController {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryControllerImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Category> addCategory(List<CategoryDto> categoryDtos) {

        List<Category> categories = categoryDtos.stream()
                .map(e -> {
                    Category category = new Category();
                    category.setCategoryName(e.getCategoryName());
                    return category;
                })
                .collect(Collectors.toList());
        return categoryRepository.saveAll(categories);
    }

    @Override
    public List<String> getAllCategories() {
        return categoryMapper.mapToStrings(
                categoryRepository.findAll()
        );
    }
}
