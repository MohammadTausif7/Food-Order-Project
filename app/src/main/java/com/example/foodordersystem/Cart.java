package com.example.foodordersystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    DatabaseHelper myDB;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_cart);
        ListView listView = (ListView) findViewById(R.id.listview);
        myDB = new DatabaseHelper(this);

        ArrayList<String> list = new ArrayList<>();
        Cursor data = myDB.getListContents();

        if(data.getCount() == 0) {
            Toast.makeText(Cart.this, "No items added", Toast.LENGTH_LONG).show();
        }
        else {
            while (data.moveToNext()) {
                list.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, R.layout.row, list );
                listView.setAdapter(listAdapter);
            }
        }

        Button home = (Button) findViewById(R.id.cart_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cart.this, Home.class);
                startActivity(intent);
            }
        });

    }

}