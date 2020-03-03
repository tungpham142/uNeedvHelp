package com.example.uneedvhelp;


import android.os.Bundle;
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
        lvCustomerRequest = findViewById(R.id.lv_vendor_request);
        db = new DatabaseHandler(this);

        mRequestList  = db.getListCustomerRequest();
        adapter = new ListRequestAdapter(this, mRequestList);
        lvCustomerRequest.setAdapter(adapter);
    }
}
