package com.example.foodapp.ui.main;

import com.example.foodapp.data.FoodClient;
import com.example.foodapp.pojo.Categories;
import com.example.foodapp.pojo.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    void getMeals() {
        mainView.showLoading();

        Call<Meals> mealCall = FoodClient.getInstance().getMeals();
        mealCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                mainView.hideLoading();
                if (response.body() != null && response.isSuccessful())
                    mainView.getMeals(response.body().getMeals());
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                mainView.onErrorLoading(t.getMessage());
            }
        });
    }


    void getCategory() {
        mainView.showLoading();

        Call<Categories> categoriesCall = FoodClient.getInstance().getCategory();
        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                mainView.hideLoading();
                if (response.body() != null && response.isSuccessful())
                    mainView.getCategories(response.body().getCategories());

            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                mainView.onErrorLoading(t.getMessage());
            }
        });


    }


}
