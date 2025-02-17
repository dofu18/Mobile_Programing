package com.example.lab5b;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder> {
    private ArrayList<Module> listModule;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onEditClick(int position);
        void onDeleteClick(int position);
    }

    public ModuleAdapter(ArrayList<Module> listModule, OnItemClickListener onItemClickListener) {
        this.listModule = listModule;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ModuleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.item_layout, parent, false);

        return new ViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleAdapter.ViewHolder holder, int position) {
        Module module = listModule.get(position);

        holder.tvTen.setText(module.getTen());
        holder.tvMota.setText(module.getMota());
        Glide.with(holder.itemView.getContext()).load(module.getHinhAnh()).into(holder.imHinh);
        Glide.with(holder.itemView.getContext()).load(module.getIcon()).into(holder.imIcon);
    }

    @Override
    public int getItemCount() {
        return listModule.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTen;
        TextView tvMota;
        ImageView imHinh;
        ImageView imIcon;
        Button buttonEdit;
        Button buttonDelete;

        public ViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            tvTen = itemView.findViewById(R.id.txtTen);
            tvMota = itemView.findViewById(R.id.txtMota);
            imHinh = itemView.findViewById(R.id.imgHinhAnh);
            imIcon = itemView.findViewById(R.id.imgIcon);
            buttonEdit = itemView.findViewById(R.id.buttonEdit);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);

            buttonEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onEditClick(getAdapterPosition());
                }
            });

            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onDeleteClick(getAdapterPosition());
                }
            });
        }
    }
}
