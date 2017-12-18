package com.volianskyi.taras.a121017_ecommerceforandroid.pojo;

/**
 * Created by tarasvolianskyi on 18.12.17.
 */

public class CategoriesPojo {
    private int CategoryId ;
    private String Category;

    public CategoriesPojo(){}

    public CategoriesPojo(int categoryId, String category) {
        CategoryId = categoryId;
        Category = category;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
