package com.example.uneedvhelp;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uneedvhelp.adapter.ListRequestAdapter;

import java.util.List;

public class VendorRequestListActivity extends AppCompatActivity {
    private ListView lvCustomerRequest;
    private DatabaseHandler db;
    private List<CustomerRequest> mRequestList;
    private ListRequestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_request_list);
        String category = getIntent().getStringExtra("category");

        lvCustomerRequest = findViewById(R.id.lv_vendor_request);
        db = new DatabaseHandler(this);
        Log.w("category:====",category.trim());
        mRequestList  = db.getListCustomerRequestByCategory(category);
        adapter = new ListRequestAdapter(this, mRequestList);
        lvCustomerRequest.setAdapter(adapter);
    }
}
