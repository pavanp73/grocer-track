package com.pavan.track.controllers.interfaces;

import com.pavan.track.entities.Category;
import com.pavan.track.models.dto.CategoryDto;

import java.util.List;

public interface CategoryController {

    List<Category> addCategory(List<CategoryDto> categoryDtos);

    List<String> getAllCategories();
}
