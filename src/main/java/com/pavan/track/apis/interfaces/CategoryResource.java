package com.pavan.track.apis.interfaces;

import com.pavan.track.models.dto.CategoryDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("categories")
public interface CategoryResource {

    @PostMapping
    @ApiOperation(value = "Create a category")
    List<CategoryDto> addCategory(@RequestBody List<CategoryDto> categoryDtoList);

    @GetMapping
    @ApiOperation(value = "Fetch all categories")
    List<CategoryDto> getAllCategories();

}
