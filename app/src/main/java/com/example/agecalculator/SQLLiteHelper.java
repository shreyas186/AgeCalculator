package com.example.agecalculator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="newMyFoodApp.db";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_NAME="register_table";
    private static final String FULL_NAME="full_name";
    private static final String PHONE_NUMBER="phone_number";
    private static final String PASS_WORD="pass_word";
//    private static final String USER_ID="user_id";
    public SQLLiteHelper(@Nullable Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(" create table "+TABLE_NAME+" (  "+FULL_NAME+" varchar(100), "+PHONE_NUMBER+" varchar(100), "+PASS_WORD+" varchar(100));");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int old_version,int new_version){
    }

}