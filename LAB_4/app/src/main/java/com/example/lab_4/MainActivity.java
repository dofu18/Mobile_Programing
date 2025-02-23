package com.example.lab_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int FOOD_REQUEST_CODE = 1;
    private static final int DRINK_REQUEST_CODE = 2;

    private Button btnSelectFood, btnSelectDrink;
    private TextView txtSelectedFood, txtSelectedDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelectFood = findViewById(R.id.btnSelectFood);
        btnSelectDrink = findViewById(R.id.btnSelectDrink);
        txtSelectedFood = findViewById(R.id.txtSelectedFood);
        txtSelectedDrink = findViewById(R.id.txtSelectedDrink);

        btnSelectFood.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FoodActivity.class);
            startActivityForResult(intent, FOOD_REQUEST_CODE);
        });

        btnSelectDrink.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DrinkActivity.class);
            startActivityForResult(intent, DRINK_REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            ArrayList<String> selectedNames = data.getStringArrayListExtra("names");
            ArrayList<String> selectedPrices = data.getStringArrayListExtra("prices");

            if (selectedNames != null && selectedPrices != null) {
                StringBuilder orderSummary = new StringBuilder();

                for (int i = 0; i < selectedNames.size(); i++) {
                    orderSummary.append("- ").append(selectedNames.get(i))
                            .append(" (").append(selectedPrices.get(i)).append(" VND)\n");
                }

                // Cập nhật TextView tương ứng
                if (requestCode == FOOD_REQUEST_CODE) {
                    txtSelectedFood.setText("Món ăn đã chọn:\n" + orderSummary.toString());
                } else if (requestCode == DRINK_REQUEST_CODE) {
                    txtSelectedDrink.setText("Đồ uống đã chọn:\n" + orderSummary.toString());
                }
            }
        }
    }
}