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
    Button mViewRequestBtn, mAddRequestBtn;
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

        mViewRequestBtn = findViewById(R.id.view_request_btn);
        mAddRequestBtn = findViewById(R.id.add_request_btn);

        mViewRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), VendorRequestListActivity.class));
                finish();
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
        });
    }
}

