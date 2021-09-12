package com.example.foodapp.ui.details;

import com.example.foodapp.data.FoodClient;
import com.example.foodapp.pojo.Meals;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsPresenter {
    DetailsView detailsView;

    public DetailsPresenter(DetailsView detailsView) {
        this.detailsView = detailsView;
    }

    public void getMealByName(String mealName) {
        detailsView.showLoading();

        Call<Meals> mealsCall = FoodClient.getInstance().getMealByName(mealName);
        mealsCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(Call<Meals> call, Response<Meals> response) {
                detailsView.hideLoading();
                if (response.isSuccessful() && response.body() != null)
                    detailsView.getMeals(response.body().getMeals().get(0));
            }

            @Override
            public void onFailure(Call<Meals> call, Throwable t) {
                detailsView.onErrorLoading(t.getMessage());
            }
        });

    }
}
