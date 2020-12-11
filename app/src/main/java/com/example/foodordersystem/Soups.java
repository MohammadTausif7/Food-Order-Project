package com.example.foodordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeUtils;

import java.text.BreakIterator;
import java.util.List;

public class Soups extends AppCompatActivity {
    DatabaseHelper myDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soups);

        TextView vs1 = (TextView) findViewById(R.id.vso1);
        TextView vs2 = (TextView) findViewById(R.id.vso2);
        TextView nvs1 = (TextView) findViewById(R.id.nvso1);
        TextView nvs2 = (TextView) findViewById(R.id.nvso2);
        TextView vs1p = (TextView) findViewById(R.id.vso1pr);
        TextView vs2p = (TextView) findViewById(R.id.vso2pr);
        TextView nvs1p = (TextView) findViewById(R.id.nvso1pr);
        TextView nvs2p = (TextView) findViewById(R.id.nvso2pr);

        myDB = new DatabaseHelper(this);



        Button tom = (Button) findViewById(R.id.tom);
        tom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = vs1.getText().toString();
                AddData(newEntry);
                tom.setEnabled(false);
            }
        });

        Button corn = (Button) findViewById(R.id.corn);
        corn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = vs2.getText().toString();
                AddData(newEntry);
                corn.setEnabled(false);
            }
        });

        Button chi = (Button) findViewById(R.id.chi);
        chi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = nvs1.getText().toString();
                AddData(newEntry);
                chi.setEnabled(false);
            }
        });

        Button mut = (Button) findViewById(R.id.mut);
        mut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = nvs2.getText().toString();
                AddData(newEntry);
                mut.setEnabled(false);
            }
        });

        Button cart = (Button) findViewById(R.id.gotocart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Soups.this, Cart.class);
                startActivity(intent);

            }
        });

        Button home = (Button) findViewById(R.id.back);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Soups.this, Home.class);
                startActivity(intent);
            }
        });
    }

    public void AddData(String newEntry){
        boolean insertData = myDB.addData(newEntry);

        if(insertData == true) {
            Toast.makeText(Soups.this, "Added", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(Soups.this, "Not Added", Toast.LENGTH_LONG).show();
        }
    }
}