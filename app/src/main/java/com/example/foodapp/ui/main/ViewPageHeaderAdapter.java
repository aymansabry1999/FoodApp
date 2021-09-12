package com.example.foodapp.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.foodapp.R;
import com.example.foodapp.pojo.Meals;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPageHeaderAdapter extends PagerAdapter {

    private List<Meals.Meal> meals;
    private Context context;
    private static ClickListener clickListener;

    public ViewPageHeaderAdapter(List<Meals.Meal> meals, Context context) {
        this.meals = meals;
        this.context = context;
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }


    @Override
    public int getCount() {
        return meals.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view_pager_header, container, false);

        ImageView mealThumb = view.findViewById(R.id.mealThumb);
        TextView mealName = view.findViewById(R.id.mealName);


        String strMealThumb = meals.get(position).getStrMealThumb();
        Picasso.get().load(strMealThumb).into(mealThumb);


        String strMealName = meals.get(position).getStrMeal();
        mealName.setText(strMealName);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(v, position);
            }
        });

        container.addView(view, 0);
        return view;

    }


    @Override
    public void destroyItem(@NonNull @org.jetbrains.annotations.NotNull ViewGroup container, int position, @NonNull @org.jetbrains.annotations.NotNull Object object) {
        container.removeView((View) object);
    }


    protected interface ClickListener {
        void onClick(View  view,int position);
    }

}
