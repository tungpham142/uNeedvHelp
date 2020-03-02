package com.example.uneedvhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class CustomerSignInActivity extends AppCompatActivity implements View.OnClickListener  {

    Button mLogout;
    Button mSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signin);

        mLogout =  findViewById(R.id.logout);
        mSignin = findViewById(R.id.btn_customer_request);
        mLogout.setOnClickListener(this);
        mSignin.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_logout:
            {
                Intent i = new Intent(CustomerSignInActivity.this,CustomerRegistrationActivity.class);
                startActivity(i);
                break;
            }
            case R.id.btn_customer_request:
            {
                Intent data = getIntent();
                int customerId = data.getIntExtra("customerId",-1);

                Intent i = new Intent(CustomerSignInActivity.this,CustomerRequestActivity.class);
                i.putExtra("customerId",customerId);
                startActivity(i);
                break;
            }
        }
    }
}
