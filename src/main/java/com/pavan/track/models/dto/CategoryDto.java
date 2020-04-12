package com.pavan.track.models.dto;

import com.pavan.track.annotations.NotNullOrBlank;
import com.pavan.track.models.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CategoryDto extends BaseModel {

    private static final long serialVersionUID = -5932298894318288564L;

    @ApiModelProperty(value = "Category name")
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
