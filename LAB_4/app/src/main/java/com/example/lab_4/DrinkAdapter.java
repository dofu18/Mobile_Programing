package com.example.lab_4;

import android.widget.BaseAdapter;
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

public class DrinkAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Drink> drinkList;
    private List<Drink> selectedDrinks = new ArrayList<>();


    public DrinkAdapter(Context context, int layout, List<Drink> drinkList) {
        this.context = context;
        this.layout = layout;
        this.drinkList = drinkList;
    }

    @Override
    public int getCount() {
        return drinkList.size();
    }

    @Override
    public Object getItem(int position) {
        return drinkList.get(position);
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
            holder.imgDrink = convertView.findViewById(R.id.imgDrink);
            holder.txtName = convertView.findViewById(R.id.txtDrinkName);
            holder.txtDescription = convertView.findViewById(R.id.txtDrinkDescription);
            holder.txtPrice = convertView.findViewById(R.id.txtDrinkPrice);
            holder.checkBox = convertView.findViewById(R.id.checkBoxDrink);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Drink drink = drinkList.get(position);
        holder.imgDrink.setImageResource(drink.getImageResource());
        holder.txtName.setText(drink.getName());
        holder.txtDescription.setText(drink.getDescription());
        holder.txtPrice.setText(drink.getPrice() + " VNĐ");

        holder.checkBox.setChecked(selectedDrinks.contains(drink));

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                if (!selectedDrinks.contains(drink)) {
                    selectedDrinks.add(drink);
                }
            } else {
                selectedDrinks.remove(drink);
            }
        });

        return convertView;
    }

    public List<Drink> getSelectedDrinks() {
        return selectedDrinks;
    }

    private static class ViewHolder {
        ImageView imgDrink;
        TextView txtName, txtDescription, txtPrice;
        CheckBox checkBox;
    }
}

