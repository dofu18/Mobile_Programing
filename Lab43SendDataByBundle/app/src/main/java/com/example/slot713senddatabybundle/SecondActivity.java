package com.example.slot713senddatabybundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    TextView txtKetqua;
    Button btnBack;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //ánh xạ
        txtKetqua = findViewById(R.id.textViewData);
        btnBack = (Button) findViewById(R.id.buttonBack);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Data");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intented =new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intented);
            }
        });
        //kiểm tra điều kiện
        if (bundle != null) {
            //khai báo
            String name = bundle.getString("name");
            String age = bundle.getString("age");
            String number = bundle.getString("number");
            String address = bundle.getString("address");
            int num = bundle.getInt("numInt", 1235);
            String[] arr = bundle.getStringArray("arr");
            Student hs = (Student) bundle.getSerializable("obj");

            assert arr != null;

            //truyền dữ liệu

            txtKetqua.setText(name    + '\b' +  (hs != null ? hs.getHovaten() : "null") + '\n'
                            + age     + '\b' +  (hs != null ? hs.getAge() : "null") + '\n'
                            + number  + '\b' +  num + '\n'
                            + address + '\b' +  arr[1] + '\n');
//            txtKetqua.setText(arr[1]);

        } else {
            Log.d("SecondActivity", "No data received");
        }
    }
}
