package com.pavan.track.resources.interfaces;

import com.pavan.track.entities.Category;
import com.pavan.track.models.dto.CategoryDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryResource {

    @PostMapping
    @ApiOperation(value = "Create a category")
    List<Category> addCategory(@RequestBody List<CategoryDto> categoryDtos);

    @GetMapping
    @ApiOperation(value = "Fetch all categories")
    List<String> getAllCategories();

}
