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
import android.widget.Toast;

import com.example.agecalculator.MainActivity;
import com.example.agecalculator.R;
import com.example.agecalculator.SQLLiteHelper;


import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    EditText ed1,ed2;
    Button login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SQLLiteHelper sqhp=new SQLLiteHelper(this);
        SQLiteDatabase sqdp=sqhp.getWritableDatabase();
        ContentValues cv=new ContentValues();
        ed1=(EditText) findViewById(R.id.log1);
        ed2=(EditText) findViewById(R.id.log2);
        login_btn=(Button) findViewById(R.id.btn_login);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phn=ed1.getText().toString();
                String pswd=ed2.getText().toString();
                int flag=0;
                cv.get("phone_number");
                cv.get("pass_word");
                String query="select * from register_table";
                Cursor c1=sqdp.rawQuery(query,null);
                while(c1.moveToNext()){
                    @SuppressLint("Range") String rfname=c1.getString(c1.getColumnIndex("full_name"));
                    @SuppressLint("Range") String rphone=c1.getString(c1.getColumnIndex("phone_number"));
                    @SuppressLint("Range") String rpass=c1.getString(c1.getColumnIndex("pass_word"));
                    if(rphone.equals(phn) && rpass.equals(pswd)){
                        flag=1;
                        break;
                    }
                    else
                        flag=0;
                    System.out.println(rfname);
                    System.out.println(rphone);
                    System.out.println(rpass);
                }
//                System.out.println(c1.getCount());
                System.out.println(flag);
//                System.out.println(phn);
//                System.out.println(pswd);
                if(flag==1){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else
                    Toast.makeText(LoginActivity.this, "Incorrect credentials!", Toast.LENGTH_SHORT).show();
                c1.close();
            }
        });
    }
    public void register(View view) {
        startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
    }
}