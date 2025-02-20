package com.example.slot713senddatabybundle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    Button btnSendata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendata = findViewById(R.id.buttonSendData);

        String arrName [] = {"Sai gon", "Da nang", "Can tho", "Ha noi"};
        Student hs = new Student("tran van a", "15");
//        Student hs = new Student(null,null);
        btnSendata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                //gửi dữ liệu
                bundle.putString("name", "Name: ");
                bundle.putString("age", "Age: ");
                bundle.putString("number", "Num: ");
                bundle.putString("address", "Address: ");
                bundle.putInt("numInt",8499999);
                bundle.putStringArray("arr", arrName );
                bundle.putSerializable("obj", hs);
                intent.putExtra("Data",bundle);
                startActivity(intent);
            }
        });
    }
}
