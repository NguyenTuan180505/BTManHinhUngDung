package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {
    Button btnBackHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        btnBackHome = findViewById(R.id.btnBackHome);

        btnBackHome.setOnClickListener(v -> {
            startActivity(new Intent(this, OrderSuccessActivity.class));
            finish();
        });
    }
}
