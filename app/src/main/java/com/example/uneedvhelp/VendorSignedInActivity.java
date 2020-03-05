package com.example.uneedvhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class VendorSignedInActivity extends AppCompatActivity {
    Button logout,vendorCategoriesButton;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vendor_signed_in);


        Intent i = new Intent(VendorSignedInActivity.this,VendorCategoryButtons.class);

        logout= findViewById(R.id.btn_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VendorSignedInActivity.this,HomePageActivity.class);
                startActivity(i);
            }
        });
    vendorCategoriesButton=findViewById(R.id.vendorCategoriesButton);
        vendorCategoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VendorSignedInActivity.this,VendorCategoryButtons.class);
                startActivity(i);
            }
        });



    }

}
