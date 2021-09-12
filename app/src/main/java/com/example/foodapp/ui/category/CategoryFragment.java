
package com.example.foodapp.ui.category;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodapp.R;
import com.example.foodapp.pojo.Meals;
import com.example.foodapp.ui.details.DetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.foodapp.ui.main.MainActivity.EXTRA_MEAL_NAME;


public class CategoryFragment extends Fragment implements CategoryView {


    RecyclerView recyclerView;
    ProgressBar progressBar;
    ImageView imageCategory;
    ImageView imageCategoryBg;
    TextView textCategory;
    AlertDialog.Builder descDialog;
    CardView cardView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);
        imageCategory = view.findViewById(R.id.imageCategory);
        imageCategoryBg = view.findViewById(R.id.imageCategoryBg);
        textCategory = view.findViewById(R.id.textCategory);
        cardView = view.findViewById(R.id.cardCategory);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Bundle bundle = getArguments();

        String categoryName = bundle.getString(ViewPagerCategoryAdapter.EXTRA_DATA_NAME);
        String categoryDec = bundle.getString(ViewPagerCategoryAdapter.EXTRA_DATA_DEC);

        if (getArguments() != null) {


            textCategory.setText(categoryName + " (" + categoryDec + ")");


            Picasso.get().load(bundle.getString(ViewPagerCategoryAdapter.EXTRA_DATA_IMAGE)).into(imageCategory);

            Picasso.get().load(bundle.getString(ViewPagerCategoryAdapter.EXTRA_DATA_IMAGE)).into(imageCategoryBg);


        }

        descDialog = new AlertDialog.Builder(getActivity()).setTitle(categoryName).setMessage(categoryDec);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descDialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
            }
        });

        CategoryPresenter presenter = new CategoryPresenter(this);
        presenter.getMealByCategory(categoryName);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void getMeals(List<Meals.Meal> meals) {

        RecyclerViewMealByCategoryAdapter adapter = new RecyclerViewMealByCategoryAdapter(meals, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setClipToPadding(false);
        adapter.notifyDataSetChanged();

        adapter.setOnItemClickListener(new RecyclerViewMealByCategoryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                TextView mealName=view.findViewById(R.id.mealNameRecycler);
                Intent intent=new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra(EXTRA_MEAL_NAME,mealName.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG);
    }
}



