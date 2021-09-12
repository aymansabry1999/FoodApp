package com.example.foodapp.data;

import com.example.foodapp.pojo.Categories;
import com.example.foodapp.pojo.Meals;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodClient {
    private final static String BASE_URL = "https://www.themealdb.com/api/json/v2/9973533/";
    private static FoodClient INSTANCE;
    private FoodInterface foodInterface;

    public FoodClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        foodInterface = retrofit.create(FoodInterface.class);

    }

    public static FoodClient getInstance() {
        if (INSTANCE == null)
            return INSTANCE = new FoodClient();
        else
            return INSTANCE;
    }

    public Call<Meals> getMeals() {
        return foodInterface.getMeals();
    }

    public Call<Categories> getCategory() {
        return foodInterface.getCategory();
    }

    public Call<Meals> getMealByCategory(String category) {
        return foodInterface.getMealByCategory(category);
    }

    public Call<Meals> getMealByName(String mealName) {
        return foodInterface.getMealByName(mealName);
    }


}