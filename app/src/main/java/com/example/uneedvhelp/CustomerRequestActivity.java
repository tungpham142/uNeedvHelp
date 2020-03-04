package com.example.uneedvhelp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Date;


public class CustomerRequestActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialogEnd,datePickerDialogStart;
    private SimpleDateFormat dateFormatter;
    //getData from these fields for end and start date
    private TextView endDate,startDate;
    //get Data from these fields for end and start date
    private EditText requestTitle, requestExplanation;
    //submission button
    private Button submit_button;
    public final String TAG="Here is your data";
    private DatabaseHandler db;
    Button mApplianceBtn, mElectricalBtn, mPlumbingBtn, mHomeCleaningBtn, mTutoringBtn, mPackagingBtn, mComputerRepairBtn, mHomeRepairBtn, mPestControlBtn, mAddRequestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        db = new DatabaseHandler(this);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        setContentView(R.layout.activity_customer_request);
        mApplianceBtn = findViewById(R.id.view_appliance_btn);
        mElectricalBtn = findViewById(R.id.view_electrical_btn);
        mPlumbingBtn = findViewById(R.id.view_plumbing_btn);
        mHomeCleaningBtn = findViewById(R.id.view_home_cleaning_btn);
        mPackagingBtn = findViewById(R.id.view_packaging_btn);
        mTutoringBtn = findViewById(R.id.view_tutoring_btn);
        mComputerRepairBtn = findViewById(R.id.view_computer_repair_btn);
        mHomeRepairBtn = findViewById(R.id.view_home_repair_btn);
        mPestControlBtn = findViewById(R.id.view_pest_control_btn);
        mAddRequestBtn = findViewById(R.id.add_request_btn);
        /*
        BUTTONS FOR TESTING
         */
        mApplianceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", mApplianceBtn.getText().toString().trim());
                startActivity(intent);
            }
        });
        mElectricalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", mElectricalBtn.getText().toString().trim());
                startActivity(intent);
            }
        });
        mPlumbingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", mPlumbingBtn.getText().toString().trim());
                startActivity(intent);
            }
        });
        mHomeCleaningBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", mHomeCleaningBtn.getText().toString().trim());
                startActivity(intent);
            }
        });
        mPackagingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", mPackagingBtn.getText().toString().trim());
                startActivity(intent);
            }
        });
        mTutoringBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", mTutoringBtn.getText().toString().trim());
                startActivity(intent);
            }
        });
        mComputerRepairBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", mComputerRepairBtn.getText().toString().trim());
                startActivity(intent);
            }
        });
        mHomeRepairBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", mHomeRepairBtn.getText().toString().trim());
                startActivity(intent);
            }
        });
        mPestControlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", mPestControlBtn.getText().toString().trim());
                startActivity(intent);
            }
        });
        /*
         END BUTTONS FOR TESTING
         */

        endDate = findViewById(R.id.request_end_date);
        endDate.setInputType(InputType.TYPE_NULL);
        endDate.requestFocus();

        Calendar endCalendar = Calendar.getInstance();
        datePickerDialogEnd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                endDate.setText(dateFormatter.format(newDate.getTime()));
            }

        }, endCalendar.get(Calendar.YEAR), endCalendar.get(Calendar.MONTH), endCalendar.get(Calendar.DAY_OF_MONTH));

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialogEnd.show();
            }
        });
        startDate = findViewById(R.id.request_start_date);
        startDate.setInputType(InputType.TYPE_NULL);
        startDate.requestFocus();
        Calendar startCalendar = Calendar.getInstance();
        datePickerDialogStart = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                startDate.setText(dateFormatter.format(newDate.getTime()));
            }

        }, startCalendar.get(Calendar.YEAR), startCalendar.get(Calendar.MONTH), startCalendar.get(Calendar.DAY_OF_MONTH));

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialogStart.show();
            }
        });
        submit_button=findViewById(R.id.submit_request_btn);
        submit_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean correct_request = true;
                //Your values for validation :)
                requestTitle = findViewById(R.id.request_title);
                String mTitle = requestTitle.getText().toString();
                requestExplanation = findViewById(R.id.request_explanation);
                String mExplanation = requestExplanation.getText().toString();
                String mEndDate = endDate.getText().toString();
                String mStartDate = startDate.getText().toString();

                Intent data = getIntent();
                // customerId retrieved
                int customerId = data.getIntExtra("customerId",-1);
                Log.println(Log.ERROR,TAG,"customerId:"+customerId+"\n mEndDate:"+mEndDate+"\n mExplanation: "+mExplanation);

                // TODO: Verify these and set errors depending on whether or not they are valid

                // TODO: Integrate this value with Mit/Gef

                String temp_Category="Plumbing";
                // TODO:Add Validations here
                Date oStartDate = new Date();
                Date oEndDate = new Date();


                try {
                    oStartDate = new SimpleDateFormat("dd-MM-yyyy").parse(mStartDate);
                }
                catch(Exception e){

                }
                try {
                    oEndDate = new SimpleDateFormat("dd-MM-yyyy").parse(mEndDate);
                }
                catch(Exception e){

                }

                boolean titleBoolean=true;
                if(mTitle.equals("") ){
                    requestTitle.setError("Fill the Field");
                    titleBoolean=false;
                }
                else if (mTitle.length()<10){

                    requestTitle.setError("Title length too short");
                    titleBoolean=false;

                }
                else if (mTitle.length()> 50)
                {

                    requestTitle.setError("Title length too long");
                    titleBoolean=false;

                }


                //description validation

                boolean explanationBoolean=true;

                if(mExplanation.equals("")){
                    requestExplanation.setError("Fill the field");
                    explanationBoolean=false;

                }
                else if(mExplanation.length() > 255){
                    requestExplanation.setError("Please describe under 255 characters");
                    explanationBoolean=false;
                }
                else if (mExplanation.length() < 40){
                    requestExplanation.setError("Please Describe in more than 40 character");
                    explanationBoolean=false;
                }
                Date today=new Date();
                long mintime=today.getTime()+1*24*60*60*1000;
                Date sMin=new Date(mintime);
                long maxtime=today.getTime()+14*24*60*60*1000;
                Date sMax=new Date(maxtime);
                boolean dateBoolean=true;
                if(mStartDate.equals("")){
                    startDate.setError("Fill the field");
                    dateBoolean=false;
                }
                else if(oStartDate.before(sMin)){
                    ((TextView) findViewById(R.id.request_start_date)).requestFocus();
                    ((TextView) findViewById(R.id.request_start_date)).setError("Date needs to be at least 2 days later ");
                    dateBoolean=false;

                }

                else if(oStartDate.after(sMax)){
                    ((TextView) findViewById(R.id.request_start_date)).requestFocus();
                    ((TextView) findViewById(R.id.request_start_date)).setError("Date needs to be no less than 14 days later ");
                    dateBoolean=false;


                }
                /*if(mEndDate.equals("")){
                    endDate.setError("Fill the field");

                }*/

                if(dateBoolean&&explanationBoolean&&titleBoolean) {
                    Intent i = new Intent(getApplicationContext(), CustomerSignInActivity.class);
                    CustomerRequest cust = new CustomerRequest();
                    cust.setCustomerId(customerId);
                    cust.setTitle(mTitle);
                    cust.setDescription(mExplanation);
                    cust.setStartDate(mStartDate);
                    cust.setEndDate(mEndDate);
                    cust.setServiceCategory(temp_Category);

                    db.insertCustomerRequest(cust);
                    startActivity(i);
                    finish();

                }
                else{
                   
                    Toast.makeText(CustomerRequestActivity.this, "Some of these fields are incorrect, please correct them", Toast.LENGTH_SHORT).show();


                }
            }
        });


        /*String[] arraySpinner = new String[] {
                "1", "2", "3", "4", "5", "6", "7"
        };
        Spinner s = (Spinner) findViewById(R.id.);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);*/
    }


}
