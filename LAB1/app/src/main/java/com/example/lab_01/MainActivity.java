package com.example.lab_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtRandom;
    Button click;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);
        //Anh xa
        txtRandom = (TextView) findViewById(R.id.txtNoiDung);
        click = (Button)findViewById(R.id.btnClick);

        //code
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                txtRandom.setText("Lập trình android");
                Random random = new Random();
                int number = random.nextInt(10);

                txtRandom.setText(number+"");

            }
        });
//        txtDienNoiDung.setText("Lập trình android");
    }
}