package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentMethodActivity extends AppCompatActivity {
    Button btnBank, btnMomo, btnCard, btnCOD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        btnBank = findViewById(R.id.btnBank);
        btnMomo = findViewById(R.id.btnMomo);
        btnCard = findViewById(R.id.btnCard);
        btnCOD = findViewById(R.id.btnCOD);

        btnCOD.setOnClickListener(v ->
                startActivity(new Intent(PaymentMethodActivity.this, CODGuideActivity.class)));
    }
}
