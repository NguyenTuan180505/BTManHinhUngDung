package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CODActivity extends AppCompatActivity {
    EditText etAddress, etPhone;
    Button btnConfirmCOD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cod);

        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        btnConfirmCOD = findViewById(R.id.btnConfirmCOD);

        btnConfirmCOD.setOnClickListener(v -> {
            String address = etAddress.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            if (address.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Đặt hàng thành công!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SuccessActivity.class));
                finish();
            }
        });
    }
}
