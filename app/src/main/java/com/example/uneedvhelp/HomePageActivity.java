package com.example.uneedvhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {

    private Button customer;
    private Button vendor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        customer = (Button) findViewById(R.id.CustomerButton);
        vendor = (Button) findViewById(R.id.VendorButton);

        customer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openCustomerActivity();
            }
        });

        vendor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openVendorActivity();
            }
        });
    }

    public void openCustomerActivity() {
        Intent intent = new Intent(this, CustomerHomeActivity.class);
        startActivity(intent);
    }

    public void openVendorActivity() {
        Intent intent = new Intent(this, VendorHomeActivity.class);
        startActivity(intent);
    }

}
