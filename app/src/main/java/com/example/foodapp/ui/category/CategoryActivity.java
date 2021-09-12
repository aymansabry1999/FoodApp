package com.example.foodapp.ui.category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityCategoryBinding;
import com.example.foodapp.pojo.Categories;
import com.example.foodapp.ui.main.MainActivity;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private ActivityCategoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category);


        initActionBar();
        initIntent();


    }

    private void initIntent() {
        Intent intent = getIntent();
        List<Categories.Category> categories = (List<Categories.Category>) intent.getSerializableExtra(MainActivity.EXTRA_CATEGOTY);
        int position = intent.getIntExtra(MainActivity.EXTRA_POSTION, 0);

        ViewPagerCategoryAdapter adapter = new ViewPagerCategoryAdapter(getSupportFragmentManager(), categories);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        binding.viewPager.setAdapter(adapter);
        binding.viewPager.setCurrentItem(position, true);
        adapter.notifyDataSetChanged();
    }

    private void initActionBar() {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("Category");
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}