// AddItemActivity.java
package com.example.lab32customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {

    EditText edtName, edtDescription, edtImageUrl;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_activity);

        edtName = findViewById(R.id.edtName);
        edtDescription = findViewById(R.id.edtDescription);
        edtImageUrl = findViewById(R.id.edtImageUrl);
        btnSubmit = findViewById(R.id.btnSubmit);

        Intent intent = getIntent();
        if (intent.hasExtra("name")) {
            String name = intent.getStringExtra("name");
            String description = intent.getStringExtra("description");
            String imageUrl = intent.getStringExtra("imageUrl");

            edtName.setText(name);
            edtDescription.setText(description);
            edtImageUrl.setText(imageUrl);
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String description = edtDescription.getText().toString();
                String imageUrl = edtImageUrl.getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(description) || TextUtils.isEmpty(imageUrl)) {
                    Toast.makeText(AddItemActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("name", name);
                    resultIntent.putExtra("description", description);
                    resultIntent.putExtra("imageUrl", imageUrl);
                    int position = getIntent().getIntExtra("position", -1);
                    if (position != -1) {
                        resultIntent.putExtra("position", position);
                    }
                    setResult(RESULT_OK, resultIntent);
                    finish();
                }
            }
        });
    }
}
