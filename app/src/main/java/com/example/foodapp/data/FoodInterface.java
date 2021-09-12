package com.example.foodapp.data;

import com.example.foodapp.pojo.Categories;
import com.example.foodapp.pojo.Meals;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodInterface {

    @GET("latest.php")
    Call<Meals> getMeals();

    @GET("categories.php")
    Call<Categories> getCategory();

    @GET("filter.php")
    Call<Meals> getMealByCategory(@Query("c") String Category);

    @GET("search.php")
    Call<Meals> getMealByName(@Query("s") String  mealName);

}
