package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OrderSuccessActivity extends AppCompatActivity {
    Button btnViewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        btnViewDetail = findViewById(R.id.btnViewDetail);
        btnViewDetail.setOnClickListener(v ->
                startActivity(new Intent(OrderSuccessActivity.this, OrderDetailActivity.class)));
    }
}
