package com.example.foodapp.ui.main;

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
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecyclerViewMainAdapter extends RecyclerView.Adapter<RecyclerViewMainAdapter.CategoryHolder> {
    private List<Categories.Category> categoryList;
    private Context context;
    private ClickListener clickListener;

    public RecyclerViewMainAdapter(List<Categories.Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }


    @Override
    public CategoryHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_category, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewMainAdapter.CategoryHolder holder, int position) {


        String strCategoryThumb = categoryList.get(position).getStrCategoryThumb();
        Picasso.get().load(strCategoryThumb).placeholder(R.drawable.ic_circle).into(holder.categoryThumb);


        String strCategory = categoryList.get(position).getStrCategory();
        holder.categoryName.setText(strCategory);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(holder.itemView, position);
            }
        });



    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    protected class CategoryHolder extends RecyclerView.ViewHolder {
        private ImageView categoryThumb;
        private TextView categoryName;

        public CategoryHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryThumb = itemView.findViewById(R.id.categoryThumb);

        }
    }

    protected interface ClickListener {
        void onClick(View view, int position);
    }
}
