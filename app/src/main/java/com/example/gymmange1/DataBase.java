package com.example.gymmange1;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Date;

public class DataBase extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME="gym.db";
    private static final int DB_VERSION=1;
    private static final String USERS_TABLE="users";
    private static final String COLUMN_NAME ="Name";
    //private static final String COLUMN_LastName ="LastName";
    private static final String COLUMN_AGE ="Age";
    private static final String COLUMN_Gender ="Gender";
    private static final String COLUMN_Address ="Address";
    private static final String COLUMN_Mobile ="Mobile";
    private static final String COLUMN_Id ="Id";
    private static final String COLUMN_DateOfJoin ="DateOfJoin";
    private static final String COLUMN_ExpireOn ="ExpireOn";
    private static final String COLUMN_trainerID ="trainerID";
    private static final String COLUMN_MemberShip ="MemberShip";

    private static final String COATCH_TABLE="coatch";
    private static final String COLUMN_Email ="Email";
    private static final String COLUMN_Password ="Password";




    public static final String CREATE_TABLE_USERS="CREATE TABLE "+USERS_TABLE+" ("+COLUMN_Id
            + " INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_NAME+" TEXT,"+COLUMN_AGE
            + " INTEGER, "+COLUMN_Mobile + " INTEGER, "+COLUMN_Mobile + " INTEGER, "+COLUMN_Gender+" TEXT,"+COLUMN_DateOfJoin+" TEXT,"+COLUMN_ExpireOn+" TEXT,"+COLUMN_Address+" TEXT,"+COLUMN_trainerID+" TEXT);";



    public DataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL(CREATE_TABLE_USERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE );
        onCreate(DB);
    }

    public void addUser(String name , int age, String address, int mobile, int id,int MemberShip, String DateOfJoin, int trainerid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_AGE, age);
//        values.put(COLUMN_Gender, Gender);
        values.put(COLUMN_Address, address);
        values.put(COLUMN_Mobile, mobile);
        values.put(COLUMN_Id, id);
        values.put(COLUMN_MemberShip, MemberShip);
        values.put(COLUMN_DateOfJoin, String.valueOf(DateOfJoin));
//        values.put(COLUMN_ExpireOn, ExpireOn);
        values.put(COLUMN_trainerID, trainerid);
        long idd = db.insert(USERS_TABLE, null, values);
        if (idd == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(context, "Added successfully!!", Toast.LENGTH_SHORT).show();

        db.close();
    }




}
