package com.pavan.track.apis.interfaces;

import com.pavan.track.models.dto.CategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("categories")
public interface CategoryResource {

    @PostMapping
    @Operation(summary = "Creates new category")
    CollectionModel<CategoryDto> addCategory(@RequestBody List<CategoryDto> categoryDtoList);

    @GetMapping
    @Operation(summary = "Lists all categories")
    CollectionModel<CategoryDto> getAllCategories();

}
