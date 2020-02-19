package com.example.uneedvhelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;


public class VendorRegistrationForm2Activity extends AppCompatActivity implements View.OnClickListener {

    //back button
    Button btn_back, btn_register;
    CheckBox iAgree;
    EditText ssn,rate;

    // Write a message to the database
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myRef = database.getReference("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_registration_form2);
        ssn = findViewById(R.id.edt_ssn);
        rate = findViewById(R.id.edt_hourly_rate);


        //20% commission condition
        iAgree = findViewById(R.id.check_i_agree);
        //back button event listener
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        //register event listener
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_back:
                //intent to go back to form 1
                Intent intent = new Intent(VendorRegistrationForm2Activity.this, VendorRegistrationForm1Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_register:
                //Validation for Agree checkbox condition
                boolean ssnBool = false;
                String sValue =getStringValue(ssn);

                if(sValue.equals("")){
                    ssn.setError("Fill this field");
                }
                else{
                    ssnBool=checkSSN(sValue);
                    if(ssnBool==false){
                        ssn.setError("SSN needs to be 9 characters");
                    }
                }
                boolean rateBool = false;
                String rateValue =getStringValue(rate);
                int rateI;
                if(!rateValue.equals("")) {
                    try {
                        rateI=Integer.parseInt(rateValue);
                    } catch (Exception any) {
                        rate.setError("Not an integer");
                    }
                }


                if (iAgree.isChecked()&&ssnBool) {


                    //fetching data from Registration Form1
                    Intent data = getIntent();
                    String fName = data.getStringExtra("fname");
                    String lName = data.getStringExtra("lname");
                    String emailID = data.getStringExtra("email");
                    String passWord = data.getStringExtra("password");
                    String DOB = data.getStringExtra("dob");
                    String mobile = data.getStringExtra("phone");

                    String strKey = myRef.push().getKey();
                    VendorRegistrationDataModel dataModel = new VendorRegistrationDataModel();
                    dataModel.setFirstName(fName);
                    dataModel.setLastName(lName);
                    dataModel.setEmail(emailID);
                    dataModel.setPassword(passWord);
                    dataModel.setMobile(mobile);
                    dataModel.setDob(DOB);

                    myRef.child(strKey).setValue(dataModel);

                    Intent i = new Intent(VendorRegistrationForm2Activity.this, VendorHomeActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(VendorRegistrationForm2Activity.this, "Please check I agree to the terms if you want to Register", Toast.LENGTH_SHORT).show();
                }
                
        }


    }
    private boolean checkSSN(String ssn){
        boolean isValid = false;
        isValid= Pattern.matches("^\\d{9}$",ssn)? true : false;
        return isValid;
    }

    private boolean checkRate(String rate){
        boolean isValid = false;
        isValid= Pattern.matches("^\\d{1,5}$",rate)? true : false;
        return isValid;
    }
    private boolean checkItems(String rate) {
        boolean isValid = false;

        return isValid;
    }
    private String getStringValue(EditText itemValue ){
        String myValue=itemValue.getText().toString();
        return myValue;
    }


}
