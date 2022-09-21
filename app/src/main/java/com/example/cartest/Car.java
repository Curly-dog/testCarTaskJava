package com.example.cartest;

public class Car {
    String mark;
    int id;
    int numberOfDoor;
    boolean registration;


    Car() {
    }

    // methods

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfDoor() {
        return numberOfDoor;
    }

    public void setNumberOfDoor(int numberOfDoor) {
        this.numberOfDoor = numberOfDoor;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public boolean getRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

}
