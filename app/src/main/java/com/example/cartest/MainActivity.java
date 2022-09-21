package com.example.cartest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button showCarsButton = findViewById(R.id.showCarsButton);


        showCarsButton.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, ActivityList.class);
            startActivity(intent);

        });
    }
}