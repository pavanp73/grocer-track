package com.pavan.track.resources.implementations;

import com.pavan.track.controllers.interfaces.CategoryController;
import com.pavan.track.entities.Category;
import com.pavan.track.models.dto.CategoryDto;
import com.pavan.track.resources.interfaces.CategoryResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryResourceImpl implements CategoryResource {

    private final CategoryController categoryController;

    @Autowired
    public CategoryResourceImpl(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    @Override
    public List<Category> addCategory(@RequestBody List<CategoryDto> categoryDtos) {
        return categoryController.addCategory(categoryDtos);
    }

    @Override
    public List<String> getAllCategories() {
        return categoryController.getAllCategories();
    }
}
