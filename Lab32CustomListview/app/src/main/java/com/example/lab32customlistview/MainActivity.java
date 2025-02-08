// MainActivity.java
package com.example.lab32customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int EDIT_ITEM_REQUEST = 2;
    private static final int ADD_ITEM_REQUEST = 1;

    ListView lvtraicay;
    ArrayList<Fruit> fruits;
    TraiCayAdapter adapter;
    Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapter = new TraiCayAdapter(this, R.layout.traicaylayout, fruits);
        lvtraicay.setAdapter(adapter);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                startActivityForResult(intent, ADD_ITEM_REQUEST);
            }
        });

        lvtraicay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit selectedFruit = fruits.get(position);
                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                intent.putExtra("name", selectedFruit.getTen());
                intent.putExtra("description", selectedFruit.getMota());
                intent.putExtra("imageUrl", selectedFruit.getImage());
                intent.putExtra("position", position);
                startActivityForResult(intent, EDIT_ITEM_REQUEST);
            }
        });
    }

    private void AnhXa() {
        lvtraicay = findViewById(R.id.listView);
        btnAddItem = findViewById(R.id.btnAddItem);
        fruits = new ArrayList<>();
        fruits.add(new Fruit("Apple", "Táo", "https://png.pngtree.com/png-clipart/20230414/original/pngtree-red-apple-fruit-realistic-transparent-png-image_9057112.png"));
        fruits.add(new Fruit("Banana", "Chuối", "https://e7.pngegg.com/pngimages/964/497/png-clipart-banana-banana.png"));
        fruits.add(new Fruit("BlueBerry", "Việt quất", "https://media.cooky.vn/images/blog-2016/qua-viet-quat-la-gi-nhung-cong-dung-cua-viet-quat-ma-co-the-ban-chua-biet-1(1).jpg"));
        fruits.add(new Fruit("Corn", "Bắp", "https://khuyennonghatinh.com/images/news/ngo1.jpg"));
        fruits.add(new Fruit("Grapes", "Nho", "https://lh5.googleusercontent.com/proxy/doOb3Yjs33Rbxk_tO7JlsqamwrIbPgCuapUGifhS0X-9DCIMiXi8TqR-fWXVBFmpwm-GgigS5cqKMqxQcGmKD45sv355HtcfBIxs7vF6X_rbRJUHRoJLI5nmvfJB"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == ADD_ITEM_REQUEST) {
                if (data != null) {
                    String name = data.getStringExtra("name");
                    String description = data.getStringExtra("description");
                    String imageUrl = data.getStringExtra("imageUrl");

                    Fruit newFruit = new Fruit(name, description, imageUrl);
                    fruits.add(newFruit);
                    adapter.notifyDataSetChanged();
                }
            } else if (requestCode == EDIT_ITEM_REQUEST) {
                if (data != null) {
                    int position = data.getIntExtra("position", -1);
                    if (position != -1) {
                        String name = data.getStringExtra("name");
                        String description = data.getStringExtra("description");
                        String imageUrl = data.getStringExtra("imageUrl");

                        Fruit editedFruit = fruits.get(position);
                        editedFruit.setTen(name);
                        editedFruit.setMota(description);
                        editedFruit.setImage(imageUrl);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
