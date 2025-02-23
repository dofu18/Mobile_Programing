package com.example.lab52;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<ItemModel> itemList;
    private int itemCount = 2; // Số lượng mặc định ban đầu


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        Button btnAdd = findViewById(R.id.btnAdd);

        itemList = new ArrayList<>();
        itemList.add(new ItemModel(R.drawable.ic_launcher_foreground, "ListView trong Android", "ListView là thành phần để hiển thị danh sách.", "Android"));
        itemList.add(new ItemModel(R.drawable.ic_launcher_foreground, "Xử lý sự kiện trong iOS", "Cách xử lý sự kiện cho UI trong iOS.", "iOS"));

        adapter = new ItemAdapter(this, itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemCount++;
                adapter.addItem(new ItemModel(R.drawable.ic_launcher_foreground, "Item mới " + itemCount, "Mô tả cho item " + itemCount, "Platform"));
            }
        });
    }
}
