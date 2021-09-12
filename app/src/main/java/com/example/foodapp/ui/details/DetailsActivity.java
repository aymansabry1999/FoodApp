package com.example.foodapp.ui.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityDetailsBinding;
import com.example.foodapp.pojo.Meals;
import com.squareup.picasso.Picasso;

import static com.example.foodapp.ui.main.MainActivity.EXTRA_MEAL_NAME;

public class DetailsActivity extends AppCompatActivity implements DetailsView {
    private ActivityDetailsBinding binding;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        setupActionBar();
        intent = getIntent();
        String mealName = intent.getStringExtra(EXTRA_MEAL_NAME);


        DetailsPresenter detailsPresenter = new DetailsPresenter(this);
        detailsPresenter.getMealByName(mealName);

    }


    private void setupActionBar() {
        setSupportActionBar(binding.toolbar);
        binding.collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.white));
        binding.collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.whiteBlue));
        binding.collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.white));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void showLoading() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.progressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void getMeals(Meals.Meal meal) {

        binding.collapsingToolbar.setTitle(meal.getStrMeal());

        String mealThumb = meal.getStrMealThumb();
        Picasso.get().load(mealThumb).into(binding.mealThumb);

        String nameCategory = meal.getStrCategory();
        binding.category.setText(nameCategory);

        String mealArea = meal.getStrArea();
        binding.country.setText(mealArea);

        String mealInstruction = meal.getStrInstructions();
        binding.instructions.setText(mealInstruction);


        if (!meal.getStrIngredient1().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient1());
        }
        if (!meal.getStrIngredient2().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient2());
        }
        if (!meal.getStrIngredient3().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient3());
        }
        if (!meal.getStrIngredient4().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient4());
        }
        if (!meal.getStrIngredient5().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient5());
        }
        if (!meal.getStrIngredient6().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient6());
        }
        if (!meal.getStrIngredient7().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient7());
        }
        if (!meal.getStrIngredient8().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient8());
        }
        if (!meal.getStrIngredient9().isEmpty()) {//null
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient9());
        }
        if (!meal.getStrIngredient10().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient10());
        }
        if (!meal.getStrIngredient11().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient11());
        }
        if (!meal.getStrIngredient12().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient12());
        }
        if (!meal.getStrIngredient13().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient13());
        }
        if (!meal.getStrIngredient14().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient14());
        }
        if (!meal.getStrIngredient15().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient15());
        }
        if (meal.getStrIngredient16() != null && !meal.getStrIngredient16().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient16());
        }
        if (meal.getStrIngredient17() != null && !meal.getStrIngredient17().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient17());
        }
        if (meal.getStrIngredient18() != null && !meal.getStrIngredient18().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient18());
        }
        if (meal.getStrIngredient19() != null && !meal.getStrIngredient19().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient19());
        }
        if (meal.getStrIngredient20() != null && !meal.getStrIngredient20().isEmpty()) {
            binding.ingredient.append("\n \u2022 " + meal.getStrIngredient20());
        }
        // if is null gives error
        if (!meal.getStrMeasure1().isEmpty() && !Character.isWhitespace(meal.getStrMeasure1().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure1());
        }
        if (!meal.getStrMeasure2().isEmpty() && !Character.isWhitespace(meal.getStrMeasure2().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure2());
        }
        if (!meal.getStrMeasure3().isEmpty() && !Character.isWhitespace(meal.getStrMeasure3().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure3());
        }
        if (!meal.getStrMeasure4().isEmpty() && !Character.isWhitespace(meal.getStrMeasure4().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure4());
        }
        if (!meal.getStrMeasure5().isEmpty() && !Character.isWhitespace(meal.getStrMeasure5().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure5());
        }
        if (!meal.getStrMeasure6().isEmpty() && !Character.isWhitespace(meal.getStrMeasure6().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure6());
        }
        if (!meal.getStrMeasure7().isEmpty() && !Character.isWhitespace(meal.getStrMeasure7().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure7());
        }
        if (!meal.getStrMeasure8().isEmpty() && !Character.isWhitespace(meal.getStrMeasure8().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure8());
        }
        if (!meal.getStrMeasure9().isEmpty() && !Character.isWhitespace(meal.getStrMeasure9().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure9());
        }
        if (!meal.getStrMeasure10().isEmpty() && !Character.isWhitespace(meal.getStrMeasure10().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure10());
        }
        if (!meal.getStrMeasure11().isEmpty() && !Character.isWhitespace(meal.getStrMeasure11().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure11());
        }
        if (!meal.getStrMeasure12().isEmpty() && !Character.isWhitespace(meal.getStrMeasure12().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure12());
        }
        if (!meal.getStrMeasure13().isEmpty() && !Character.isWhitespace(meal.getStrMeasure13().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure13());
        }
        if (!meal.getStrMeasure14().isEmpty() && !Character.isWhitespace(meal.getStrMeasure14().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure14());
        }
        if (!meal.getStrMeasure15().isEmpty() && !Character.isWhitespace(meal.getStrMeasure15().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure15());
        }
        if (meal.getStrMeasure16() != null && !meal.getStrMeasure16().isEmpty() && !Character.isWhitespace(meal.getStrMeasure16().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure16());
        }
        if (meal.getStrMeasure17() != null && !meal.getStrMeasure17().isEmpty() && !Character.isWhitespace(meal.getStrMeasure17().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure17());
        }
        if (meal.getStrMeasure18() != null && !meal.getStrMeasure18().isEmpty() && !Character.isWhitespace(meal.getStrMeasure18().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure18());
        }
        if (meal.getStrMeasure19() != null && !meal.getStrMeasure19().isEmpty() && !Character.isWhitespace(meal.getStrMeasure19().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure19());
        }
        if (meal.getStrMeasure20() != null && !meal.getStrMeasure20().isEmpty() && !Character.isWhitespace(meal.getStrMeasure20().charAt(0))) {
            binding.measure.append("\n : " + meal.getStrMeasure20());
        }


        binding.youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentYoutube = new Intent(Intent.ACTION_VIEW);
                intentYoutube.setData(Uri.parse(meal.getStrYoutube()));
                startActivity(intentYoutube);
            }
        });

        binding.source.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSource = new Intent(Intent.ACTION_VIEW);
                intentSource.setData(Uri.parse(meal.getStrSource()));
                startActivity(intentSource);
            }
        });


    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
    }
}