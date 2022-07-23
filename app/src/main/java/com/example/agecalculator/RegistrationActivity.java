package com.example.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.agecalculator.MainActivity;
import com.example.agecalculator.R;
import com.example.agecalculator.SQLLiteHelper;

public class RegistrationActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    Button reg_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        SQLLiteHelper sqhp=new SQLLiteHelper(this);
        SQLiteDatabase sqdp=sqhp.getWritableDatabase();
        ContentValues cv=new ContentValues();
        ed1=(EditText)findViewById(R.id.e1);
        ed2=(EditText)findViewById(R.id.e2);
        ed3=(EditText)findViewById(R.id.e3);
        reg_button=(Button) findViewById(R.id.button_reg);
        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv.put("full_name",ed1.getText().toString());
                cv.put("phone_number",ed2.getText().toString());
                cv.put("pass_word",ed3.getText().toString());
                sqdp.insert("register_table",null,cv);
                String query="Select * from register_table";
                Cursor c1=sqdp.rawQuery(query,null);
                while(c1.moveToNext()){
                    @SuppressLint("Range") String rfname=c1.getString(c1.getColumnIndex("full_name"));
                    @SuppressLint("Range") String rphone=c1.getString(c1.getColumnIndex("phone_number"));
                    @SuppressLint("Range") String rpass=c1.getString(c1.getColumnIndex("pass_word"));
                    System.out.println(rfname);
                    System.out.println(rphone);
                    System.out.println(rpass);
                }
                c1.close();
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });

    }
    public void login(View view) {
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
    }
}