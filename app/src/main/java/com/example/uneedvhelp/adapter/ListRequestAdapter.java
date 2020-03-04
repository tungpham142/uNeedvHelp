package com.example.uneedvhelp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.uneedvhelp.CustomerRequest;
import com.example.uneedvhelp.R;

import java.util.List;

public class ListRequestAdapter extends BaseAdapter {
    private Context mContext;
    private List<CustomerRequest> mRequestList;

    public ListRequestAdapter(Context mContext, List<CustomerRequest> mRequestList) {
        this.mContext = mContext;
        this.mRequestList = mRequestList;
    }


    @Override
    public int getCount() {
        return mRequestList.size();
    }

    @Override
    public Object getItem(int position) {
        return mRequestList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mRequestList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.request_listview, null);
        TextView tvTitle = v.findViewById(R.id.tv_request_title);
        TextView tvRequestBy = v.findViewById(R.id.tv_request_by);
        TextView tvDescription = v.findViewById(R.id.tv_description);
        TextView tvDate = v.findViewById(R.id.tv_date);
        TextView tvCategory = v.findViewById(R.id.tv_category);
        tvTitle.setText(mRequestList.get(position).getTitle());
        tvRequestBy.setText(mRequestList.get(position).getName());
        tvDescription.setText(mRequestList.get(position).getDescription());
        tvDate.setText(mRequestList.get(position).getDate());
        tvCategory.setText(mRequestList.get(position).getServiceCategory());

        return v;
    }
}
