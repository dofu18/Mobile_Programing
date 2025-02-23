package com.example.lab_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {
    private ListView listView;
    private Button btnOrderFood;
    private ArrayList<Food> foodList;
    private ArrayList<Food> selectedFoods;
    private Food selectedFood = null;
    private FoodAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        listView = findViewById(R.id.listViewFood);
        btnOrderFood = findViewById(R.id.btnOrderFood);
        selectedFoods = new ArrayList<>();

        foodList = new ArrayList<>();
        foodList.add(new Food("Phở Hà Nội", "Món ăn truyền thống của Hà Nội", "50000", R.drawable.pho));
        foodList.add(new Food("Bún Bò Huế", "Món ăn đặc sản Huế", "60000", R.drawable.bunbo));
        foodList.add(new Food("Mì Quảng", "Đặc sản Quảng Nam", "45000", R.drawable.miquang));
        foodList.add(new Food("Hủ Tíu Sài Gòn", "Món ăn nổi tiếng miền Nam", "40000", R.drawable.hutieu));

        FoodAdapter adapter = new FoodAdapter(this, R.layout.list_item_food, foodList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Food selectedFood = foodList.get(position);

            if (selectedFoods.contains(selectedFood)) {
                selectedFoods.remove(selectedFood);
                Toast.makeText(this, "Bỏ chọn: " + selectedFood.getName(), Toast.LENGTH_SHORT).show();
            } else {
                selectedFoods.add(selectedFood);
                Toast.makeText(this, "Đã chọn: " + selectedFood.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        btnOrderFood.setOnClickListener(v -> {
            ArrayList<Food> selectedFoods = (ArrayList<Food>) adapter.getSelectedFoods();

            if (!selectedFoods.isEmpty()) {
                Intent intent = new Intent();
                ArrayList<String> selectedNames = new ArrayList<>();
                ArrayList<String> selectedPrices = new ArrayList<>();

                for (Food food : selectedFoods) {
                    selectedNames.add(food.getName());
                    selectedPrices.add(food.getPrice());
                }

                intent.putStringArrayListExtra("names", selectedNames);
                intent.putStringArrayListExtra("prices", selectedPrices);

                setResult(RESULT_OK, intent);
                finish();
            } else {
                Toast.makeText(FoodActivity.this, "Vui lòng chọn ít nhất một món ăn!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
