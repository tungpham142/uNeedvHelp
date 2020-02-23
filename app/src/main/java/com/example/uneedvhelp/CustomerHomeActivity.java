package com.example.uneedvhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerHomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);
        login = findViewById(R.id.btn_login);
        register = findViewById(R.id.btn_register);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
            {
                Intent i = new Intent(CustomerHomeActivity.this,CustomerRegistrationActivity.class);
                startActivity(i);
                break;
            }
            case R.id.btn_login:
            {
                Intent i = new Intent(CustomerHomeActivity.this,CustomerLoginActivity.class);
                startActivity(i);
                break;
            }
        }
    }
}
