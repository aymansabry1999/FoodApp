package com.example.foodapp.ui.main;

import com.example.foodapp.pojo.Categories;
import com.example.foodapp.pojo.Meals;

import java.util.List;

public interface MainView {

    void showLoading();
    void hideLoading();
    void onErrorLoading(String message);
    void getCategories(List<Categories.Category> categoryList);
    void getMeals(List<Meals.Meal> mealList);




}
