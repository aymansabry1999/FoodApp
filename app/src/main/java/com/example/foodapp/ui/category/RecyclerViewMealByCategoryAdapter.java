package com.example.foodapp.ui.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;
import com.example.foodapp.pojo.Categories;
import com.example.foodapp.pojo.Meals;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewMealByCategoryAdapter extends RecyclerView.Adapter<RecyclerViewMealByCategoryAdapter.CategoryHolder> {
    private List<Meals.Meal> meals;
    private Context context;
    private ClickListener clickListener;

    public RecyclerViewMealByCategoryAdapter(List<Meals.Meal> categories, Context context) {
        this.meals = categories;
        this.context = context;
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }


    @Override
    public CategoryHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_meal, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewMealByCategoryAdapter.CategoryHolder holder, int position) {

        String mealName = meals.get(position).getStrMeal();
        holder.mealName.setText(mealName);


        String mealThumb = meals.get(position).getStrMealThumb();
        Picasso.get().load(mealThumb).into(holder.mealThumb);

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              clickListener.onClick(holder.itemView, position);
          }
      });


    }

    @Override
    public int getItemCount() {
        return meals.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {
        ImageView mealThumb;
        TextView mealName;

        public CategoryHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mealName = itemView.findViewById(R.id.mealNameRecycler);
            mealThumb = itemView.findViewById(R.id.mealThumbRecycler);
        }
    }

    public interface ClickListener {
        void onClick(View view, int position);


    }
}
