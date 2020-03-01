package com.example.uneedvhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomerRegistrationActivity extends AppCompatActivity {
    EditText mFirstName, mLastName, mEmail, mPassword, mConfirmPassword, mPhone, mAddress, mZip, mState, mCity;
    Button mRegisterBtn;
    TextView mLoginBtn;
    RadioGroup radiogrp;

    private TextView mDob;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);

        mFirstName = findViewById(R.id.firstName);
        mLastName = findViewById(R.id.lastName);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mConfirmPassword = findViewById(R.id.confirm_pw);
        mPhone = findViewById(R.id.phone);
        mRegisterBtn = findViewById(R.id.btnSignUp);
        mLoginBtn =  findViewById(R.id.btnLogin);
        mDob = findViewById(R.id.dob);
        mZip = findViewById(R.id.edt_zipcode);
        mState = findViewById(R.id.edt_state);
        mCity  = findViewById(R.id.edt_city);
        mAddress = findViewById(R.id.edt_address);
        radiogrp = findViewById(R.id.radio_grp);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        db = new DatabaseHandler(this);

        //date of birth edittext and date picker
        mDob.setInputType(InputType.TYPE_NULL);
        mDob.requestFocus();
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                mDob.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        mDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CustomerLoginActivity.class));
                finish();
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String firstName = mFirstName.getText().toString().trim();
                final String lastName = mLastName.getText().toString().trim();
                final String email = mEmail.getText().toString().toLowerCase().trim();
                final String password = mPassword.getText().toString();
                final String confirmPassword = mConfirmPassword.getText().toString();
                final String phone = mPhone.getText().toString().trim();
                final String address = mAddress.getText().toString().trim();
                final String state = mState.getText().toString().trim();
                final String zip = mZip.getText().toString().trim();

                boolean validation = true;

                if(TextUtils.isEmpty(firstName)){
                    mFirstName.setError("First Name is Required");
                    validation = false;
                }

                if(TextUtils.isEmpty(lastName)){
                    mLastName.setError("Last Name is Required");
                    validation = false;
                }

                if(!isValidPhone(phone)){
                    mPhone.setError("Please enter a valid phone number");
                    validation = false;
                }

                if(!isValidEmail(email)){
                    mEmail.setError("Please enter a valid email");
                    validation = false;
                }

                if(!isValidPassword(password)){
                    mPassword.setError("Password has to be at least 6 character. \nPassword should contain at least one uppercase letter, one lowercase letter, one number, and one special character. ");
                    validation = false;
                }

                if(TextUtils.isEmpty(confirmPassword)){
                    mConfirmPassword.setError("Please Confirm Your Password");
                    validation = false;
                }


                if(!password.equals(confirmPassword)){
                    mConfirmPassword.setError("Your Confirm Password does not match");
                    validation = false;
                }

                if(!validation){
                    return;
                }

                String gender = "";
                int radioId = radiogrp.getCheckedRadioButtonId();
                if(radioId > 0){
                    RadioButton radioBtn = findViewById(radioId);
                    gender = radioBtn.getText().toString();
                }
                String dobValue = mDob.getText().toString();

                Customer customer = new Customer();
                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customer.setEmail(email);
                customer.setPhone(phone);
                customer.setPassword(password);
                customer.setAddress(address);
                customer.setState(state);
                customer.setZip(zip);
                customer.setGender(gender);
                customer.setDob(dobValue);

                try{
                    if(db.getCustomerByEmail(email) != null){
                        Toast.makeText(CustomerRegistrationActivity.this, "You are already signed up !\nPlease try to login. ", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    db.insertCustomer(customer);
                    Toast.makeText(CustomerRegistrationActivity.this, "You are Signed Up. ", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), CustomerLoginActivity.class));
                }catch (Exception e) {
                    Toast.makeText(CustomerRegistrationActivity.this, "Error! " + e.getMessage(), Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }

    // Method to check if an email is valid
    protected boolean isValidEmail(String email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    // Method to check if a phone number is valid
    protected boolean isValidPhone(String phone) {
        return (!TextUtils.isEmpty(phone) && Patterns.PHONE.matcher(phone).matches() && phone.length() >= 10);
    }

    // Method to check if a phone number is valid
    protected boolean isValidPassword(String password) {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean isAtLeast6   = password.length() >= 6;
        boolean hasSpecial   = !password.matches("[A-Za-z0-9 ]*");

        return hasLowercase && hasUppercase  && isAtLeast6 && hasSpecial;
    }
}
