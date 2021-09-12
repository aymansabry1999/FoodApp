package com.example.foodapp.ui.category;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.foodapp.pojo.Categories;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ViewPagerCategoryAdapter extends FragmentPagerAdapter {

    public static final String EXTRA_DATA_NAME = "ExtraDataName";
    public static final String EXTRA_DATA_IMAGE = "ExtraDataImage";
    public static final String EXTRA_DATA_DEC = "ExtraDataDec";
    private  List<Categories.Category> categories;

    public ViewPagerCategoryAdapter(@NonNull @NotNull FragmentManager fm, List<Categories.Category> categories) {
        super(fm);
        this.categories = categories;
    }

    @Override
    public Fragment getItem(int position) {
        CategoryFragment categoryFragment = new CategoryFragment();
        Bundle arg = new Bundle();
        arg.putString(EXTRA_DATA_NAME,categories.get(position).getStrCategory());
        arg.putString(EXTRA_DATA_DEC,categories.get(position).getStrCategoryDescription());
        arg.putString(EXTRA_DATA_IMAGE,categories.get(position).getStrCategoryThumb());
        categoryFragment.setArguments(arg);
        return categoryFragment;
    }

    @Override
    public int getCount() {
        return categories.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return categories.get(position).getStrCategory();
    }
}
