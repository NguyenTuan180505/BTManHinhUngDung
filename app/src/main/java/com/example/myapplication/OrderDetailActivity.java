package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OrderDetailActivity extends AppCompatActivity {
    Button btnGoProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        btnGoProfile = findViewById(R.id.btnGoProfile);
        btnGoProfile.setOnClickListener(v ->
                startActivity(new Intent(OrderDetailActivity.this, ProfileActivity.class)));
    }
}
