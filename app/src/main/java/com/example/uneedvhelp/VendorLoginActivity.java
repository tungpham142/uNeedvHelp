package com.example.uneedvhelp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class VendorLoginActivity extends AppCompatActivity {
    TextView register_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_login);
        register_text = (TextView)findViewById(R.id.start_register);
        register_text.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(VendorLoginActivity.this, VendorRegistrationForm1Activity.class);
                startActivity(intent);
            }
        });
    }


}
