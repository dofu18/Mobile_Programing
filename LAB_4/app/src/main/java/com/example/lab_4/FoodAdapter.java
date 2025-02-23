package com.example.lab_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Food> foodList;
    private List<Food> selectedFoods = new ArrayList<>();

    public FoodAdapter(Context context, int layout, List<Food> foodList) {
        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);
            holder = new ViewHolder();
            holder.imgFood = convertView.findViewById(R.id.imgFood);
            holder.txtName = convertView.findViewById(R.id.txtFoodName);
            holder.txtDescription = convertView.findViewById(R.id.txtFoodDescription);
            holder.txtPrice = convertView.findViewById(R.id.txtFoodPrice);
            holder.checkBox = convertView.findViewById(R.id.checkBoxFood);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Food food = foodList.get(position);
        holder.imgFood.setImageResource(food.getImageResource());
        holder.txtName.setText(food.getName());
        holder.txtDescription.setText(food.getDescription());
        holder.txtPrice.setText(food.getPrice() + " VNĐ");

        holder.checkBox.setChecked(selectedFoods.contains(food));

        // ✅ Handle checkbox selection
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                if (!selectedFoods.contains(food)) {
                    selectedFoods.add(food);
                }
            } else {
                selectedFoods.remove(food);
            }
        });

        return convertView;
    }

    public List<Food> getSelectedFoods() {
        return selectedFoods;
    }

    private static class ViewHolder {
        ImageView imgFood;
        TextView txtName, txtDescription, txtPrice;
        CheckBox checkBox;
    }
}
