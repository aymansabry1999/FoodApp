package com.example.foodapp.ui.details;

import com.example.foodapp.pojo.Meals;

import java.util.List;

public interface DetailsView {

    void showLoading();
    void hideLoading() ;
    void getMeals(Meals.Meal meal);
    void onErrorLoading(String message);
}
