package com.example.cartest;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONException;
import java.util.concurrent.ExecutionException;

public class ActivityList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView carListView = findViewById(R.id.carListView);

        String[] marksOfCar = new String[5];
        int[] carsDoor = new int[5];
        boolean[] carsRegistration = new boolean[5];
        String url = getString(R.string.url);

        try {
            CarListParser carListParser = new CarListParser(url);
            marksOfCar = carListParser.getMarksOfCar();
            carsDoor = carListParser.getCarsDoor();
            carsRegistration = carListParser.getCarsRegistration();

        } catch (JSONException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, marksOfCar);
        carListView.setAdapter(adapter);

        boolean[] finalCarsRegistration = carsRegistration;
        int[] finalCarsDoor = carsDoor;

        carListView.setOnItemClickListener((parent, itemClicked, position, id) -> {
            String chekRegistration;
            if (finalCarsRegistration[position])
                chekRegistration = "Да";
            else
                chekRegistration = "Нет";

            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityList.this);
            builder.setMessage("Количество дверей: " + finalCarsDoor[position] + "\n" + "Регистрация: " + chekRegistration)
                    .setCancelable(true);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });
    }
}