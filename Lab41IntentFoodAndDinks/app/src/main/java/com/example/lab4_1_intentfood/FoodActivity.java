package com.example.lab4_1_intentfood;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FoodActivity extends AppCompatActivity {
    private Button btnBack;
    private Button btnOder;
    private RadioGroup radioGroup;
    private int selectedRadioButtonId = -1;  // Lưu trữ id của radio button được chọn

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_food);

        btnBack = (Button) findViewById(R.id.buttonBack);
        btnOder = findViewById(R.id.buttonOder);
        radioGroup = findViewById(R.id.radioGroup);


        // Lấy id của radio button được chọn trước đó từ Intent
        Intent intent = getIntent();
        if (intent != null) {
            selectedRadioButtonId = intent.getIntExtra("selected_radio_button_id", -1);
            if (selectedRadioButtonId != -1) {
                RadioButton previouslySelectedRadioButton = findViewById(selectedRadioButtonId);
                if (previouslySelectedRadioButton != null) {
                    previouslySelectedRadioButton.setChecked(true);
                }
            }
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectedRadioButtonId = checkedId;  // Lưu lại id của radio button được chọn
                // Log giá trị của radio button được chọn
                RadioButton selectedRadioButton = group.findViewById(checkedId);
                String selectedText = selectedRadioButton.getText().toString();
                Log.d("RadioGroup", "onCheckedChanged: " + selectedText);
            }
        });

        View.OnClickListener navigateToMainActivity = v -> {
            Intent resultIntent = new Intent();
            if (selectedRadioButtonId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                String selectedText = selectedRadioButton.getText().toString();
                resultIntent.putExtra("Selected_Food", selectedText);
            }
            resultIntent.putExtra("selected_radio_button_id", selectedRadioButtonId);
            setResult(RESULT_OK, resultIntent);
            finish();
        };

        btnBack.setOnClickListener(v -> finish());
        btnOder.setOnClickListener(navigateToMainActivity);
    }
}