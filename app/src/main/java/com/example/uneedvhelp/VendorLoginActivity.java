package com.example.uneedvhelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class VendorLoginActivity extends AppCompatActivity {

    Button login;
    EditText email,password;
    VendorRegistrationDataModel dataModel;
    TextView register_text;
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_login);

        //Firebase
        // Write a message to the database
        db = new DatabaseHandler(this);
        login = findViewById(R.id.btn_login);
        email = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);
        register_text = (TextView)findViewById(R.id.start_register);
        register_text.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(VendorLoginActivity.this, VendorRegistrationForm1Activity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email_id = email.getText().toString();
                if(email_id.equals("")){
                    email.setError("Please type email");
                }
                final String pwd = password.getText().toString();
                if(pwd.equals("")){
                    password.setError("Please type password");

                }

            }
        });

    }

}
