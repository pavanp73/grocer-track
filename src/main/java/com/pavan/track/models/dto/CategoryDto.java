package com.pavan.track.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pavan.track.annotations.NotNullOrBlank;
import com.pavan.track.models.BaseModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDto extends BaseModel<CategoryDto> {

    private static final long serialVersionUID = -5932298894318288564L;

    @NotNullOrBlank(message = "Category name cannot be blank")
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryResponseDto{" +
                super.toString() +
                "categoryName='" + categoryName + '\'' +
                "} ";
    }
}
