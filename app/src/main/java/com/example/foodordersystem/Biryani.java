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

public class Biryani extends AppCompatActivity {
    DatabaseHelper myDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biryani);

        TextView vs1 = (TextView) findViewById(R.id.vb1);
        TextView vs2 = (TextView) findViewById(R.id.vb2);
        TextView nvs1 = (TextView) findViewById(R.id.nvb1);
        TextView nvs2 = (TextView) findViewById(R.id.nvb2);
        TextView vs1p = (TextView) findViewById(R.id.vb1pr);
        TextView vs2p = (TextView) findViewById(R.id.vb2pr);
        TextView nvs1p = (TextView) findViewById(R.id.nvb1pr);
        TextView nvs2p = (TextView) findViewById(R.id.nvb2pr);

        myDB = new DatabaseHelper(this);



        Button fri = (Button) findViewById(R.id.fri);
        fri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = vs1.getText().toString();
                AddData(newEntry);
                fri.setEnabled(false);
            }
        });

        Button vbir = (Button) findViewById(R.id.vbir);
        vbir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = vs2.getText().toString();
                AddData(newEntry);
                vbir.setEnabled(false);
            }
        });

        Button chidb = (Button) findViewById(R.id.chidb);
        chidb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = nvs1.getText().toString();
                AddData(newEntry);
                chidb.setEnabled(false);
            }
        });

        Button mutdb = (Button) findViewById(R.id.mutdb);
        mutdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = nvs2.getText().toString();
                AddData(newEntry);
                mutdb.setEnabled(false);
            }
        });

        Button cart = (Button) findViewById(R.id.bir_cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Biryani.this, Cart.class);
                startActivity(intent);

            }
        });

        Button home = (Button) findViewById(R.id.bir_back);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Biryani.this, Home.class);
                startActivity(intent);
            }
        });
    }

    public void AddData(String newEntry){
        boolean insertData = myDB.addData(newEntry);

        if(insertData == true) {
            Toast.makeText(Biryani.this, "Added", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(Biryani.this, "Not Added", Toast.LENGTH_LONG).show();
        }
    }
}