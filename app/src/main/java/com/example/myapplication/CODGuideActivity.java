package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CODGuideActivity extends AppCompatActivity {
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod_guide);

        btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(v ->
                startActivity(new Intent(CODGuideActivity.this, OrderSuccessActivity.class)));
    }
}
