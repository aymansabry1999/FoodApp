package com.example.foodapp.ui.category;

import com.example.foodapp.pojo.Meals;

import java.util.List;

public interface CategoryView {
     void showLoading();
     void hideLoading() ;
     void getMeals(List<Meals.Meal> meals);
     void onErrorLoading(String message);

}
