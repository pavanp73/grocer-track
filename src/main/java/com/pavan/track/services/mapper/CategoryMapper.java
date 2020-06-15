package com.pavan.track.services.mapper;

import com.pavan.track.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryMapper {

    public List<String> mapToStrings(List<Category> categories){
        return categories.stream()
                .map(Category::getCategoryName)
                .collect(Collectors.toList());
    }

    public Category mapToEntity(String categoryName){
        Category category = new Category();
        category.setCategoryName(categoryName);
        return category;
    }
}
