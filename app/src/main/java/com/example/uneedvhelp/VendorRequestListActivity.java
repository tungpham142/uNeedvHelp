package com.example.uneedvhelp;


import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class VendorRequestListActivity extends AppCompatActivity {
    private ListView lvCustomerRequest;
    private DatabaseHandler db;
    private List<CustomerRequest> mRequestList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_request_list);
        lvCustomerRequest = findViewById(R.id.lv_vendor_request);
        db = new DatabaseHandler(this);

        mRequestList  = db.getListCustomerRequest();

    }
}
