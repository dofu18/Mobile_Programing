package com.example.lab_02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText editTextMin, editTextMax;
    private Button buttonGenerate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextMin = findViewById(R.id.editTextNumberDecimal);
        editTextMax = findViewById(R.id.editTextNumberDecimal2);
        buttonGenerate = findViewById(R.id.buttonGenerate);
        textViewResult = findViewById(R.id.textView5);

        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenerateRandomNumber();
            }
        });
    }

    private void GenerateRandomNumber() {
        int min = Integer.parseInt(editTextMin.getText().toString());
        int max = Integer.parseInt(editTextMax.getText().toString());

        if (max < min) {
            // Đảo giá trị nếu max < min
            int temp = max;
            max = min;
            min = temp;
        }

        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;

        textViewResult.setText(String.valueOf(randomNumber));
    }
}