package com.example.uneedvhelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class VendorCategoryButtons extends AppCompatActivity {
    ImageButton mApplianceBtn, mElectricalBtn, mPlumbingBtn, mHomeCleaningBtn, mTutoringBtn, mPackagingBtn, mComputerRepairBtn, mHomeRepairBtn, mPestControlBtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_buttons);
        mApplianceBtn = findViewById(R.id.applianceCat);
        mElectricalBtn = findViewById(R.id.electricalCat);
        mPlumbingBtn = findViewById(R.id.plumbingCat);
        mHomeCleaningBtn = findViewById(R.id.cleanCat);
        mPackagingBtn = findViewById(R.id.packagingCat);
        mTutoringBtn = findViewById(R.id.tutoringCat);
        mComputerRepairBtn = findViewById(R.id.computerRepairCat);
        mHomeRepairBtn = findViewById(R.id.homeRepairAndPaintingCat);
        mPestControlBtn = findViewById(R.id.pestControlCat);

        mApplianceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", "Appliance");
                startActivity(intent);
            }
        });
        mElectricalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", "Electrical");
                startActivity(intent);
            }
        });
        mPlumbingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", "Plumbing");
                startActivity(intent);
            }
        });
        mHomeCleaningBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", "Home Cleaning");
                startActivity(intent);
            }
        });
        mPackagingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", "Packaging");
                startActivity(intent);
            }
        });
        mTutoringBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", "Tutoring");
                startActivity(intent);
            }
        });
        mComputerRepairBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", "Computer Repair");
                startActivity(intent);
            }
        });
        mHomeRepairBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", "Home Repair");
                startActivity(intent);
            }
        });
        mPestControlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VendorRequestListActivity.class);
                intent.putExtra("category", "Pest Control");
                startActivity(intent);
            }
        });
    }
}
