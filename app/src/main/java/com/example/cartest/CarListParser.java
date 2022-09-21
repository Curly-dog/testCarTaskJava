package com.example.cartest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class CarListParser {
    private String[] marksOfCar = new String[5];
    private int[] carsDoor = new int[5];
    private boolean[] carsRegistration = new boolean[5];
    private final Car[] listOfCar = new Car[5];

    public String[] getMarksOfCar() {
        return marksOfCar;
    }

    public void setMarksOfCar(String[] marksOfCar) {
        this.marksOfCar = marksOfCar;
    }

    public int[] getCarsDoor() {
        return carsDoor;
    }

    public void setCarsDoor(int[] carsDoor) {
        this.carsDoor = carsDoor;
    }

    public boolean[] getCarsRegistration() {
        return carsRegistration;
    }

    public void setCarsRegistration(boolean[] carsRegistration) {
        this.carsRegistration = carsRegistration;
    }

    public CarListParser(String url) throws JSONException, ExecutionException, InterruptedException {
        this.parsJSON(url);

    }

    private void parsJSON(String url) throws ExecutionException, InterruptedException, JSONException {


        JSONArray jsonArray = new JSONArray(new GetURLData().execute(url).get());

        final String[] marksOfCar = new String[5];
        final int[] carsDoor = new int[5];
        final boolean[] carsRegistration = new boolean[5];
        for (int i = 0; i < 5; ++i) {
            final JSONObject carJson = jsonArray.getJSONObject(i);
            Car bufferCar = new Car();
            bufferCar.setId(carJson.getInt("id"));
            bufferCar.setMark(carJson.getString("mark"));
            bufferCar.setNumberOfDoor(carJson.getInt("numberOfDoor"));
            bufferCar.setRegistration(carJson.getBoolean("registration"));
            listOfCar[i] = bufferCar;
            marksOfCar[i] = bufferCar.getMark();
            carsDoor[i] = bufferCar.getNumberOfDoor();
            carsRegistration[i] = bufferCar.getRegistration();
            this.setMarksOfCar(marksOfCar);
            this.setCarsDoor(carsDoor);
            this.setCarsRegistration(carsRegistration);

        }

    }
}
