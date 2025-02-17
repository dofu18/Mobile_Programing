package com.example.lab5b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddModuleActivity extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextFullName;
    private EditText editTextImageUrl;
    private EditText editTextIconUrl;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_module_layout);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextFullName = findViewById(R.id.editTextMota);
        editTextImageUrl = findViewById(R.id.editTextImageURL);
        editTextIconUrl = findViewById(R.id.editTextIconURL);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("EDIT_MODE")) {
            editTextUsername.setText(intent.getStringExtra("ten"));
            editTextFullName.setText(intent.getStringExtra("mota"));
            editTextImageUrl.setText(intent.getStringExtra("imageUrl"));
            editTextIconUrl.setText(intent.getStringExtra("iconUrl"));
        }

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String fullName = editTextFullName.getText().toString();
                String imageUrl = editTextImageUrl.getText().toString();
                String iconUrl = editTextIconUrl.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("ten", username);
                resultIntent.putExtra("mota", fullName);
                resultIntent.putExtra("imageUrl", imageUrl);
                resultIntent.putExtra("iconUrl", iconUrl);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
