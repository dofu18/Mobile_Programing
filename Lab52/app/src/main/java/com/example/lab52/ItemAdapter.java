package com.example.lab52;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<ItemModel> itemList;
    private Context context;

    public ItemAdapter(Context context, List<ItemModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel item = itemList.get(position);
        holder.itemImage.setImageResource(item.getImage());
        holder.itemTitle.setText(item.getTitle());
        holder.itemDescription.setText(item.getDescription());
        holder.itemPlatform.setText(item.getPlatform());

        // **Xử lý cập nhật Item**
        holder.itemView.setOnClickListener(v -> {
            showUpdateDialog(position);
        });

        // **Xử lý xóa Item**
        holder.itemView.setOnLongClickListener(v -> {
            showDeleteDialog(position);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // **Thêm mới một Item**
    public void addItem(ItemModel item) {
        itemList.add(item);
        notifyItemInserted(itemList.size() - 1);
    }

    // **Cập nhật Item**
    public void updateItem(int position, String newTitle, String newDescription) {
        itemList.get(position).setTitle(newTitle);
        itemList.get(position).setDescription(newDescription);
        notifyItemChanged(position);
    }

    // **Xóa Item**
    public void removeItem(int position) {
        itemList.remove(position);
        notifyItemRemoved(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle, itemDescription, itemPlatform;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemDescription = itemView.findViewById(R.id.itemDescription);
            itemPlatform = itemView.findViewById(R.id.itemPlatform);
        }
    }

    // **Hiển thị Dialog cập nhật**
    private void showUpdateDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Cập nhật Item");
        builder.setMessage("Bạn có muốn cập nhật item này?");
        builder.setPositiveButton("Có", (dialog, which) -> {
            itemList.get(position).setTitle("Updated Title");
            itemList.get(position).setDescription("Updated Description");
            notifyItemChanged(position);
            Toast.makeText(context, "Item đã được cập nhật!", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("Hủy", null);
        builder.show();
    }

    // **Hiển thị Dialog xác nhận xóa**
    private void showDeleteDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Xóa Item");
        builder.setMessage("Bạn có chắc chắn muốn xóa item này?");
        builder.setPositiveButton("Có", (dialog, which) -> {
            removeItem(position);
            Toast.makeText(context, "Item đã bị xóa!", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("Hủy", null);
        builder.show();
    }
}


