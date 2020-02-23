package com.example.uneedvhelp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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

    private SQLiteDatabase database;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FIRST_NAME + " VARCHAR, " + COLUMN_LAST_NAME + " VARCHAR," + COLUMN_EMAIL + " VARCHAR, " + COLUMN_PASSWORD + " VARCHAR, " + COLUMN_MOBILE + " VARCHAR, " + COLUMN_DOB + " VARCHAR, " + COLUMN_GENDER + " VARCHAR, " + COLUMN_ADDRESS + " VARCHAR, " + COLUMN_CITY + " VARCHAR, " + COLUMN_STATE + " VARCHAR, " + COLUMN_ZIPCODE + " VARCHAR, " + COLUMN_SSN + " VARCHAR, " + COLUMN_RATE + " VARCHAR );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
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
