package com.example.foodordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foodordersystem.R;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button soups = (Button) findViewById(R.id.soups);
        Button starters = (Button) findViewById(R.id.starters);
        Button Biryani = (Button) findViewById(R.id.biryani);
        Button hcart = (Button) findViewById(R.id.home_cart);

        soups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSoups();
            }
        });

        starters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStarters();
            }
        });

        Biryani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBiryani();
            }
        });

        hcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Cart.class);
                startActivity(intent);
            }
        });


    }

    public void openSoups() {
        Intent intent = new Intent(this, Soups.class);
        startActivity(intent);
    }

    public void openStarters() {
        Intent intent = new Intent(this, Starters.class);
        startActivity(intent);
    }

    public void openBiryani() {
        Intent intent = new Intent(this, Biryani.class);
        startActivity(intent);
    }
}