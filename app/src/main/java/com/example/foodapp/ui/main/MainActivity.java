package com.example.foodapp.ui.main;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityMainBinding;
import com.example.foodapp.pojo.Categories;
import com.example.foodapp.pojo.Meals;
import com.example.foodapp.ui.category.CategoryActivity;
import com.example.foodapp.ui.details.DetailsActivity;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    public static final String EXTRA_CATEGOTY = "categoryIntent";
    public static final String EXTRA_POSTION = "categoryPosition";
    public static final String EXTRA_MEAL_NAME = "mealName";
    ActivityMainBinding binding;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        presenter = new MainPresenter(this);
        presenter.getMeals();
        presenter.getCategory();


    }


    @Override
    public void showLoading() {
        binding.shimmerCategory.setVisibility(View.VISIBLE);
        binding.shimmerMail.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.shimmerCategory.setVisibility(View.GONE);
        binding.shimmerMail.setVisibility(View.GONE);
    }

    @Override
    public void onErrorLoading(String message) {
        new AlertDialog.Builder(this).setTitle("Error").setMessage(message).show();
    }

    @Override
    public void getCategories(List<Categories.Category> categoryList) {
        RecyclerViewMainAdapter recyclerViewMainAdapter = new RecyclerViewMainAdapter(categoryList,this);
        binding.recyclerCategoryView.setAdapter(recyclerViewMainAdapter);
        binding.recyclerCategoryView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3,
                GridLayoutManager.VERTICAL, false));
        binding.recyclerCategoryView.setNestedScrollingEnabled(true);

        recyclerViewMainAdapter.setOnItemClickListener(new RecyclerViewMainAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent=new Intent(getBaseContext(), CategoryActivity.class);
                intent.putExtra(EXTRA_CATEGOTY, (Serializable) categoryList);
                intent.putExtra(EXTRA_POSTION,position);
                startActivity(intent);

            }
        });


    }

    @Override
    public void getMeals(List<Meals.Meal> mealList) {
        ViewPageHeaderAdapter viewPageHeaderAdapter = new ViewPageHeaderAdapter(mealList, this);
        binding.viewPagerHeader.setAdapter(viewPageHeaderAdapter);
        binding.viewPagerHeader.setPadding(20, 0, 150, 0);
        viewPageHeaderAdapter.notifyDataSetChanged();
        viewPageHeaderAdapter.setOnItemClickListener(new ViewPageHeaderAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                TextView mealName=findViewById(R.id.mealName);

                Intent intent=new Intent(getBaseContext(), DetailsActivity.class);
                intent.putExtra(EXTRA_MEAL_NAME,mealName.getText().toString());
                startActivity(intent);


            }
        });
    }
}