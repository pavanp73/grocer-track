package com.pavan.track.apis.implementations;

import com.pavan.track.controllers.interfaces.CategoryController;
import com.pavan.track.models.dto.CategoryDto;
import com.pavan.track.apis.interfaces.CategoryResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryResourceImpl implements CategoryResource {

    private final CategoryController categoryController;

    @Autowired
    public CategoryResourceImpl(CategoryController categoryController) {
        this.categoryController = categoryController;
    }

    @Override
    public List<CategoryDto> addCategory(@RequestBody List<CategoryDto> categoryDtoList) {
        return categoryController.addCategory(categoryDtoList);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryController.getAllCategories();
    }
}
