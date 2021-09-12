package com.example.foodapp.ui.category;

import com.example.foodapp.data.FoodClient;
import com.example.foodapp.pojo.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPresenter {
    CategoryView categoryView;

    public CategoryPresenter(CategoryView categoryView) {
        this.categoryView = categoryView;
    }

    public void getMealByCategory(String category) {
        categoryView.showLoading();
        Call<Meals> mealsCall = FoodClient.getInstance().getMealByCategory(category);
        mealsCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                categoryView.hideLoading();
                if (response.isSuccessful() && response != null)
                    categoryView.getMeals(response.body().getMeals());
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                categoryView.onErrorLoading(t.getMessage());
            }
        });
    }


}
