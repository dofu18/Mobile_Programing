package com.example.lab213form;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class activity_sign_in extends AppCompatActivity implements View.OnClickListener{

    //views
    // Vi ems

    private EditText etUsername;
    private EditText etPassword;
    private TextView tvNotAccountYet;
    private Button btnSignIn;
    //notify
    private final  String REQUIRE = "require";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
// Reference from Layout
        etUsername = findViewById(R.id.etUSername);
        etPassword = findViewById(R.id.etPassword);
        tvNotAccountYet = findViewById(R.id.tvNotAccountYet);
        btnSignIn = findViewById(R.id.btnSignIn);
// Register event
        tvNotAccountYet.setOnClickListener((View.OnClickListener) this);
        btnSignIn.setOnClickListener((View.OnClickListener) this);

    }
    private boolean checkInput() {
// Username
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError(REQUIRE);
            return false;
        }
// Password
        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError(REQUIRE);
            return false;
        }
// VaLid
        return true;
    }
    private void signIn() {
// InvaLid
        if (!checkInput()) {
            return;
        }
// Start MainActivity
        Intent intent = new Intent( this, activity_sign_up.class);
        startActivity(intent);
        finish(); // CLose current activity
    }

    private void signUpForm() {
        Intent intent = new Intent( this, activity_sign_up.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSignIn) {
            signIn();
        } else if (v.getId() == R.id.tvNotAccountYet) {
            signUpForm();
        }
    }
}
