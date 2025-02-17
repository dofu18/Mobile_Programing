package com.example.lab31basiclistview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMH;
    Button btnAdd;
    Button btnUpdate;
    EditText editMH;
    ArrayList<String> arrayCourse;
    int position = -1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMH = (ListView) findViewById(R.id.listviewMH);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        editMH = (EditText) findViewById(R.id.editTextMH);
        btnUpdate = (Button) findViewById(R.id.buttonUpdate);
        arrayCourse = new ArrayList<>();

        arrayCourse.add("Android");
        arrayCourse.add("PHP");
        arrayCourse.add("iOS");
        arrayCourse.add("Unity");
        arrayCourse.add("ASP.net");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayCourse);
        lvMH.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monhoc = editMH.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });

        lvMH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                editMH.setText(arrayCourse.get(i));
                position = i;
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCourse.set(position, editMH.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        lvMH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                arrayCourse.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        };

    }