package com.example.gymmange1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView username =(TextView)findViewById(R.id.editUserName);
        TextView password =(TextView)findViewById(R.id.editPassword);
        Button loginbtn =(Button)findViewById(R.id.btnLogin);
        //admin,12345
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("12345")){
                    //correct
                    Toast.makeText(LoginActivity.this,"LOGIN SUCCESSFULL !!",Toast.LENGTH_SHORT).show();
                    startActivity( new Intent(LoginActivity.this, HomeActivity.class));
                }else
                    //incorrect
                    Toast.makeText(LoginActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });


        }
    }


