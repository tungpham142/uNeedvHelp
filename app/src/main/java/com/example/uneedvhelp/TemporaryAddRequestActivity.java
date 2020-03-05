package com.example.uneedvhelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class TemporaryAddRequestActivity  extends AppCompatActivity {
    EditText mTitle, mDescription, mStartDate, mEndDate, mCategory;
    Button mApplianceBtn, mElectricalBtn, mPlumbingBtn, mHomeCleaningBtn, mTutoringBtn, mPackagingBtn, mComputerRepairBtn, mHomeRepairBtn, mPestControlBtn, mAddRequestBtn;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temporary_addrequest);

        mTitle = findViewById(R.id.request_title);
        mDescription = findViewById(R.id.description);
        mStartDate = findViewById(R.id.start_date);
        mEndDate = findViewById(R.id.end_date);
        mCategory = findViewById(R.id.category);
        db = new DatabaseHandler(this);

        /*mApplianceBtn = findViewById(R.id.view_appliance_btn);
        mElectricalBtn = findViewById(R.id.view_electrical_btn);
        mPlumbingBtn = findViewById(R.id.view_plumbing_btn);
        mHomeCleaningBtn = findViewById(R.id.view_home_cleaning_btn);
        mPackagingBtn = findViewById(R.id.view_packaging_btn);
        mTutoringBtn = findViewById(R.id.view_tutoring_btn);
        mComputerRepairBtn = findViewById(R.id.view_computer_repair_btn);
        mHomeRepairBtn = findViewById(R.id.view_home_repair_btn);
        mPestControlBtn = findViewById(R.id.view_pest_control_btn);
        mAddRequestBtn = findViewById(R.id.add_request_btn);

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

        mAddRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String title = mTitle.getText().toString().trim();
                final String description = mDescription.getText().toString().trim();
                final String startDate = mStartDate.getText().toString().trim();
                final String endDate = mEndDate.getText().toString().trim();
                final String category = mCategory.getText().toString().trim();


                CustomerRequest request = new CustomerRequest();
                request.setServiceCategory(category);
                request.setStartDate(startDate);
                request.setEndDate(endDate);
                request.setDescription(description);
                request.setTitle(title);
                request.setCustomerId(1);

                try {
                    db.insertCustomerRequest(request);
                    Toast.makeText(TemporaryAddRequestActivity.this, "New Request Created. ", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), TemporaryAddRequestActivity.class));
                } catch (Exception e) {
                    Toast.makeText(TemporaryAddRequestActivity.this, "Error! " + e.getMessage(), Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });*/
    }
}

