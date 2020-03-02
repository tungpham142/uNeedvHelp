package com.example.uneedvhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomerLoginActivity extends AppCompatActivity {
    private EditText mName;
    private EditText mPassword;
    private Button mLogin;
    private TextView mUserRegistered;
    private int counter=5;
    private TextView mInfo;
    private DatabaseHandler db;
    public final String TAG="Here is your data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        mName = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mLogin = findViewById(R.id.btnLogin);
        mUserRegistered = findViewById(R.id.UserRegister);
        mInfo = findViewById(R.id.tvInfo);
        db = new DatabaseHandler(this);

        mInfo.setText("No. of attempts remaining: 5");

        mUserRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenCustomerRegistrationActivity();
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = mName.getText().toString().toLowerCase().trim();
                String password = mPassword.getText().toString().trim();

                boolean validation = true;

                if(TextUtils.isEmpty(email)) {
                    mName.setError("Valid Email is Required");
                    validation = false;
                }

                if(TextUtils.isEmpty(password)) {
                    mPassword.setError("Valid Password is Required");
                    validation = false;
                }

                if(!validation) return;

                Customer customerDb = db.getCustomerByEmail(email);

                if(customerDb != null && customerDb.getPassword().equals(password)){
                    Toast.makeText(CustomerLoginActivity.this, "Login Successful!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),CustomerSignInActivity.class);
                    Log.w(TAG,"This is the value of customer: "+customerDb.customerId);
                    i.putExtra("customerId",customerDb.customerId);
                    startActivity(i);

                }
                else{
                    Toast.makeText(CustomerLoginActivity.this, "Your email or password is not correct. ", Toast.LENGTH_LONG).show();
                    counter--;
                    mInfo.setText("No. of attempts remaining: " + counter);

                    if (counter == 0) {
                        mLogin.setEnabled(false);
                    }
                }
            }
        });

}

    public void OpenCustomerRegistrationActivity(){
        Intent intent = new Intent(CustomerLoginActivity.this, CustomerRegistrationActivity.class);
        startActivity(intent);
    }

}
