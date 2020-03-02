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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        setContentView(R.layout.activity_customer_request);
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
                requestExplanation = findViewById(R.id.request_title);
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

                if(correct_request==false) {
                    // TODO: show error message
                }
                else{
                    // TODO:Add Database Code Here
                    Intent i = new Intent(getApplicationContext(), CustomerSignInActivity.class);

                    startActivity(i);
                    finish();

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
