package com.pavan.track.controllers.interfaces;

import com.pavan.track.annotations.NotNullOrBlank;
import com.pavan.track.entities.Category;
import com.pavan.track.models.dto.CategoryDto;
import org.springframework.hateoas.CollectionModel;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public interface CategoryController {

    CollectionModel<CategoryDto> addCategory(
            @NotEmpty(message = "Category list cannot be empty")
            List<@Valid CategoryDto> categoryDtoList);

    CollectionModel<CategoryDto> getAllCategories();

    Category findByCategoryId(
            @NotNullOrBlank(message = "Category Id cannot be blank")
                    String categoryId);
}
