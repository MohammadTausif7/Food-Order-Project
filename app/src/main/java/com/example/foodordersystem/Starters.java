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

public class Starters extends AppCompatActivity {
    DatabaseHelper myDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        TextView vs1 = (TextView) findViewById(R.id.vs1);
        TextView vs2 = (TextView) findViewById(R.id.vs2);
        TextView nvs1 = (TextView) findViewById(R.id.nvs1);
        TextView nvs2 = (TextView) findViewById(R.id.nvs2);
        TextView vs1p = (TextView) findViewById(R.id.vs1pr);
        TextView vs2p = (TextView) findViewById(R.id.vs2pr);
        TextView nvs1p = (TextView) findViewById(R.id.nvs1pr);
        TextView nvs2p = (TextView) findViewById(R.id.nvs2pr);

        myDB = new DatabaseHelper(this);



        Button man = (Button) findViewById(R.id.man);
        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = vs1.getText().toString();
                AddData(newEntry);
                man.setEnabled(false);
            }
        });

        Button pan = (Button) findViewById(R.id.pan);
        pan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = vs2.getText().toString();
                AddData(newEntry);
                pan.setEnabled(false);
            }
        });

        Button chi65 = (Button) findViewById(R.id.chi65);
        chi65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = nvs1.getText().toString();
                AddData(newEntry);
                chi65.setEnabled(false);
            }
        });

        Button chichi = (Button) findViewById(R.id.chichi);
        chichi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = nvs2.getText().toString();
                AddData(newEntry);
                chichi.setEnabled(false);
            }
        });

        Button cart = (Button) findViewById(R.id.star_cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Starters.this, Cart.class);
                startActivity(intent);

            }
        });

        Button home = (Button) findViewById(R.id.star_back);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Starters.this, Home.class);
                startActivity(intent);
            }
        });
    }

    public void AddData(String newEntry){
        boolean insertData = myDB.addData(newEntry);

        if(insertData == true) {
            Toast.makeText(Starters.this, "Added", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(Starters.this, "Not Added", Toast.LENGTH_LONG).show();
        }
    }
}