package com.example.gymmange1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Date;
import java.util.Calendar;

public class AddActivity extends AppCompatActivity {
    TextView tvDate;
    DatePickerDialog.OnDateSetListener setListener;
     EditText Name_input,Age_input,Address_input,Mobile_input,Id_input,trainerID_input,etDate;
     Spinner MemberShip;
     Button save_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        tvDate=(TextView)findViewById(R.id.tv_date);
        etDate=(EditText)findViewById(R.id.et_date);
        Calendar calendar =Calendar.getInstance();
        final int year =calendar.get(Calendar.YEAR);
        final int month =calendar.get(Calendar.MONTH);
        final int day =calendar.get(Calendar.DAY_OF_MONTH);
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayofmonth) {
             month=month+1;
             String date = day+"/"+month+"/"+year;
             tvDate.setText(date);
            }
        };
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        etDate.setText(date);

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        Name_input=(EditText)findViewById(R.id.editUserName);
        Age_input=(EditText)findViewById(R.id.Age);
        Address_input=(EditText)findViewById(R.id.Address);
        Mobile_input=(EditText)findViewById(R.id.edMobile);
        Id_input=(EditText)findViewById(R.id.idMember);
        trainerID_input=(EditText)findViewById(R.id.idtrainer);
        save_button=(Button)findViewById(R.id.btnAddMembersave);
        MemberShip=(Spinner)findViewById(R.id.SpMemberShip);
        String text = MemberShip.getSelectedItem().toString();

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBase MyDB = new DataBase(AddActivity.this);
                MyDB.addUser(Name_input.getText().toString().trim(),
                        Integer.valueOf(Age_input.getText().toString().trim()),
                        Address_input.getText().toString().trim(),
                        Integer.valueOf(Mobile_input.getText().toString().trim()),
                        Integer.valueOf(Id_input.getText().toString().trim()),
                        Integer.valueOf(text.trim()),
                        etDate.getText().toString().trim(),
                        Integer.valueOf(trainerID_input.getText().toString().trim())
                        );
            }
        });


    }
}