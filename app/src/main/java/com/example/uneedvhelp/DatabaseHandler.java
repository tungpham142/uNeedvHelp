package com.example.uneedvhelp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SQLiteDatabase.db";
    public static final String TABLE_NAME = "VENDOR";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String COLUMN_LAST_NAME = "LAST_NAME";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_MOBILE = "MOBILE";
    public static final String COLUMN_DOB = "DOB";
    public static final String COLUMN_GENDER = "GENDER";
    public static final String COLUMN_ADDRESS = "ADDRESS";
    public static final String COLUMN_CITY = "CITY";
    public static final String COLUMN_STATE = "STATE";
    public static final String COLUMN_ZIPCODE = "ZIPCODE";
    public static final String COLUMN_SSN = "SSN";
    public static final String COLUMN_RATE = "RATE";


    public static final String TABLE_CUSTOMER = "CUSTOMER";
    public static final String TABLE_REQUESTS = "REQUEST";


    private SQLiteDatabase database;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FIRST_NAME + " VARCHAR, " + COLUMN_LAST_NAME + " VARCHAR," + COLUMN_EMAIL + " VARCHAR, " + COLUMN_PASSWORD + " VARCHAR, " + COLUMN_MOBILE + " VARCHAR, " + COLUMN_DOB + " VARCHAR, " + COLUMN_GENDER + " VARCHAR, " + COLUMN_ADDRESS + " VARCHAR, " + COLUMN_CITY + " VARCHAR, " + COLUMN_STATE + " VARCHAR, " + COLUMN_ZIPCODE + " VARCHAR, " + COLUMN_SSN + " VARCHAR, " + COLUMN_RATE + " VARCHAR );");

        String customerTable = "CREATE TABLE " + TABLE_CUSTOMER + " (CustomerId INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                                    "FirstName  VARCHAR(255)    NOT NULL," +
                                                                    "LastName   VARCHAR(255)    NOT NULL," +
                                                                    "Email      VARCHAR(255)    NOT NULL," +
                                                                    "Password   VARCHAR(255)    NOT NULL," +
                                                                    "Phone      VARCHAR(100)    NOT NULL," +
                                                                    "Gender     VARCHAR(100), " +
                                                                    "DOB        DATETIME )";
        String customerRequest = "CREATE TABLE " + TABLE_REQUESTS + " (RequestId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CustomerId   VARCHAR(255)    NOT NULL," +
                "Description   VARCHAR(255)    NOT NULL," +
                "Title      VARCHAR(51)    NOT NULL," +
                "EndDate    VARCHAR(51), " +
                "StartDate        VARCHAR(51) NOT NULL )";

        sqLiteDatabase.execSQL(customerRequest);
        sqLiteDatabase.execSQL(customerTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
        onCreate(sqLiteDatabase);

    }

    //insert data
    public void insertRecord(VendorRegistrationDataModel Model) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME, Model.getFirstName());
        contentValues.put(COLUMN_LAST_NAME, Model.getLastName());
        contentValues.put(COLUMN_EMAIL, Model.getEmail());
        contentValues.put(COLUMN_PASSWORD, Model.getPassword());
        contentValues.put(COLUMN_MOBILE, Model.getMobile());
        contentValues.put(COLUMN_DOB, Model.getDob());
        contentValues.put(COLUMN_GENDER, Model.getGender());
        contentValues.put(COLUMN_ADDRESS, Model.getAddress());
        contentValues.put(COLUMN_CITY, Model.getCity());
        contentValues.put(COLUMN_STATE, Model.getState());
        contentValues.put(COLUMN_ZIPCODE, Model.getZipcode());
        contentValues.put(COLUMN_SSN, Model.getSsn());
        contentValues.put(COLUMN_RATE, Model.getHourly_rate());

        database.insert(TABLE_NAME, null, contentValues);

        // Insert Data for Customer Table

        database.close();
    }

    public ArrayList<VendorRegistrationDataModel> getAllRecords() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        ArrayList<VendorRegistrationDataModel> vendor = new ArrayList<VendorRegistrationDataModel>();
        VendorRegistrationDataModel model;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                model = new VendorRegistrationDataModel();
                model.setId(cursor.getString(0));
                model.setFirstName(cursor.getString(1));
                model.setLastName(cursor.getString(2));
                model.setEmail(cursor.getString(3));
                model.setPassword(cursor.getString(4));
                model.setMobile(cursor.getString(5));
                model.setDob(cursor.getString(6));
                model.setGender(cursor.getString(7));
                model.setAddress(cursor.getString(8));
                model.setCity(cursor.getString(9));
                model.setState(cursor.getString(10));
                model.setZipcode(cursor.getString(11));
                model.setSsn(cursor.getString(12));
                model.setHourly_rate(cursor.getString(13));


                vendor.add(model);
            }
        }
        cursor.close();
        database.close();
        return vendor;
    }

    public void retiriveData(VendorRegistrationDataModel model,String email,String password) {
        database = this.getReadableDatabase();
        //database.rawQuery("Select * from VENDOR where EMAIL=? and PASSWORD=?", new String[]{email,password});

        /*Cursor cursor = database.rawQuery("SELECT EMAIL, PASSWORD FROM VENDOR WHERE
                 COLUMN_ID = ?", new String[]{email,password});");*/
        Cursor cursor = database.rawQuery("SELECT * FROM VENDOR WHERE EMAIL = ? AND PASSWORD = ?",new String[]{email,password});



        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                model.getEmail();
                model.getPassword();
            }
        }

    }

    public void insertCustomer(Customer customer){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("FirstName", customer.getFirstName());
        values.put("LastName", customer.getLastName());
        values.put("Email", customer.getEmail());
        values.put("Password", customer.getPassword());
        values.put("Phone", customer.getPhone());
        values.put("Gender", customer.getGender());

        db.insert(TABLE_CUSTOMER, null, values);
        db.close();
    }
    public void insertCustomerRequest(CustomerRequest request){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("CustomerId", request.getId());
        values.put("RequestId", request.getId());
        values.put("EndDate", request.getEndDate());
        values.put("StartDate", request.getStartDate());
        values.put("Title", request.getTitle());
        values.put("Description", request.getDescription());

        db.insert(TABLE_CUSTOMER, null, values);
        db.close();
    }


    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<Customer>();
        String sql = "SELECT * FROM " + TABLE_CUSTOMER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        if(c.moveToFirst()){
            do{
                Customer customer = new Customer();
                customer.setCustomerId(c.getInt(c.getColumnIndex("CustomerId")));
                customer.setEmail(c.getString(c.getColumnIndex("Email")));
                customer.setFirstName(c.getString(c.getColumnIndex("FirstName")));
                customer.setLastName(c.getString(c.getColumnIndex("LastName")));
                customer.setPhone(c.getString(c.getColumnIndex("Phone")));
                customer.setGender(c.getString(c.getColumnIndex("Gender")));

                customers.add(customer);
            } while (c.moveToNext());
        }
        db.close();
        return customers;
    }

    public Customer getCustomerByEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();

        String sql = "SELECT * FROM Customer WHERE Email = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{email});

        if (cursor!= null)
            cursor.moveToFirst();

        Customer customer = new Customer();
        customer.setPassword(cursor.getString(cursor.getColumnIndex("Password")));
        customer.setFirstName(cursor.getString(cursor.getColumnIndex("FirstName")));
        customer.setLastName(cursor.getString(cursor.getColumnIndex("LastName")));
        customer.setPhone(cursor.getString(cursor.getColumnIndex("Phone")));
        customer.setEmail(cursor.getString(cursor.getColumnIndex("Email")));
        customer.setCustomerId(cursor.getInt(cursor.getColumnIndex("CustomerId")));

        db.close();
        return customer;
    }

    /*public void updateRecord(ContactModel contactModel) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();;
        contentValues.put(COLUMN_FIRST_NAME,contactModel.getFirstName());
        contentValues.put(COLUMN_LAST_NAME, contactModel.getLastName());
        database.update(TABLE_NAME,contentValues, COLUMN_ID + " =? " , new String[] {contactModel.getID()} );
        database.close();

    }
    public void deleteRecord(ContactModel contactModel){
        database = this.getReadableDatabase();
        database.delete(TABLE_NAME,COLUMN_ID + " =? ", new String[]{contactModel.getID()});
        database.close();
    }*/
}
