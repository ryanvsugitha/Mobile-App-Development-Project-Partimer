package com.example.partimerfinal.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    public static final String DATABASE_NAME = "PARTIMER.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_WORKER_TABLE =
                "CREATE TABLE workers (" +
                        "email TEXT, " +
                        "name TEXT, " +
                        "password TEXT)";

        String CREATE_COMPANY_TABLE =
                "CREATE TABLE company (" +
                        "email TEXT, " +
                        "companyName TEXT, " +
                        "password TEXT)";

        db.execSQL(CREATE_WORKER_TABLE);
        db.execSQL(CREATE_COMPANY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void add_worker(String email, String name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv  = new ContentValues();

        cv.put("email", email);
        cv.put("name", name);
        cv.put("password", password);

        long result = db.insert("workers", null, cv);
//        if (result == -1){
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(context, "User Added", Toast.LENGTH_SHORT).show();
//        }
    }

    public void add_company(String email, String company_name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv  = new ContentValues();

        cv.put("email", email);
        cv.put("companyName", company_name);
        cv.put("password", password);

        long result = db.insert("company", null, cv);
//        if (result == -1){
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(context, "User Added", Toast.LENGTH_SHORT).show();
//        }
    }

    public boolean auth_worker(String email, String password){
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT * FROM workers WHERE email = ? AND password = ?";
        String args[] = {email, password};

        Cursor cursor = db.rawQuery(query, args);

        if(cursor.moveToNext()){
            return true;
        }
        return false;
    }

    public boolean auth_company(String email, String password){
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT * FROM company WHERE email = ? AND password = ?";
        String args[] = {email, password};

        Cursor cursor = db.rawQuery(query, args);

        if(cursor.moveToNext()){
            return true;
        }
        return false;
    }

    public boolean exist_email_workers(String email) {
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT email FROM workers WHERE email = ?";
        String args[] = {email};
        Cursor cursor = db.rawQuery(query, args);
        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean exist_email_company(String email) {
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT email FROM company WHERE email = ?";
        String args[] = {email};
        Cursor cursor = db.rawQuery(query, args);
        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }
}