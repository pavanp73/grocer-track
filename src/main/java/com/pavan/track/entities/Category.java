package com.pavan.track.entities;

import com.pavan.track.entities.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
public class Category extends BaseEntity {

    private static final long serialVersionUID = -6448392717879368506L;

    @Column(name = "category_name", nullable = false, unique = true, length = 50)
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }
}
