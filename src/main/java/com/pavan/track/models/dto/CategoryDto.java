package com.pavan.track.models.dto;

import com.pavan.track.models.BaseModel;

public class CategoryDto extends BaseModel {

    private static final long serialVersionUID = -5932298894318288564L;

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }
}
