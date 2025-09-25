package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etLoginUser, etLoginPass;
    Button btnLogin;
    TextView tvGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLoginUser = findViewById(R.id.etLoginUser);
        etLoginPass = findViewById(R.id.etLoginPass);
        btnLogin = findViewById(R.id.btnLogin);
        tvGoToRegister = findViewById(R.id.tvGoToRegister);

        // Xử lý nút Đăng nhập
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etLoginUser.getText().toString();
                String pass = etLoginPass.getText().toString();

                if(user.isEmpty() || pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    // Giả lập đăng nhập thành công
                    if(user.equals("admin") && pass.equals("123")){
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        // Sau này bạn có thể chuyển sang màn hình HomeActivity
                         startActivity(new Intent(MainActivity.this, PaymentMethodActivity.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Chuyển sang trang Đăng ký
        tvGoToRegister.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            finish();
        });
    }
}
