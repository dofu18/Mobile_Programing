package com.example.lab4_1_intentfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnFood, btnDrinks ,btnOut;
    private TextView textViewMenu;
    private static final int DRINKS_REQUEST_CODE = 1;
    private static final int FOOD_REQUEST_CODE = 2;
    private String selectedDrink = "";
    private String selectedFood = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       btnFood = (Button) findViewById(R.id.buttonFood);
       btnDrinks = (Button) findViewById(R.id.buttonDrinks);
       btnOut = (Button) findViewById(R.id.buttonOut);
       textViewMenu = findViewById(R.id.textViewMenu);

       btnFood.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, FoodActivity.class);
               startActivityForResult(intent, FOOD_REQUEST_CODE);
           }
       });

        btnDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DrinksActivity.class);
                startActivityForResult(intent, DRINKS_REQUEST_CODE);
            }
        });

       btnOut.setOnClickListener(v -> finishAffinity());
       updateTextView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == DRINKS_REQUEST_CODE) {
                selectedDrink = data.getStringExtra("Selected_Drinks");
            } else if (requestCode == FOOD_REQUEST_CODE) {
                selectedFood = data.getStringExtra("Selected_Food");
            }
            updateTextView();
        }
    }
    private void updateTextView() {
        String displayText = "Không có đồ ăn và đồ uống nào được chọn";
        if (selectedDrink != null || selectedFood != null) {
            displayText = "";
            if (selectedFood != null && !selectedFood.isEmpty()) {
                displayText += selectedFood ;
            }
            if (selectedDrink != null && !selectedDrink.isEmpty()) {
                displayText += " - "+ selectedDrink;
            }
        }
        textViewMenu.setText(displayText);
    }

}