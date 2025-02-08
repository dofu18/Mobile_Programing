// TraiCayAdapter.java
package com.example.lab32customlistview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.List;

public class TraiCayAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Fruit> fruits;

    public TraiCayAdapter(Context context, int layout, List<Fruit> fruits) {
        this.context = context;
        this.layout = layout;
        this.fruits = fruits;
    }

    @Override
    public int getCount() {
        return fruits.size();
    }

    @Override
    public Object getItem(int position) {
        return fruits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            holder.txtTen = convertView.findViewById(R.id.textviewTen);
            holder.txtMoTa = convertView.findViewById(R.id.textviewMota);
            holder.imageView = convertView.findViewById(R.id.imageviewHinh);
            holder.btnEdit = convertView.findViewById(R.id.btnEdit);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Fruit fruit = fruits.get(position);

        holder.txtTen.setText(fruit.getTen());
        holder.txtMoTa.setText(fruit.getMota());
        Glide.with(context).load(fruit.getImage()).into(holder.imageView);

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddItemActivity.class);
                intent.putExtra("name", fruit.getTen());
                intent.putExtra("description", fruit.getMota());
                intent.putExtra("imageUrl", fruit.getImage());
                intent.putExtra("position", position);
                ((MainActivity) context).startActivityForResult(intent, MainActivity.EDIT_ITEM_REQUEST);
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        TextView txtTen, txtMoTa;
        ImageView imageView;
        Button btnEdit;
    }
}
