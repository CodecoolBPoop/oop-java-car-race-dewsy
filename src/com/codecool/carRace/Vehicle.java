package com.codecool.carRace;

import java.util.List;
import java.util.Random;

abstract class Vehicle {

    static Random rand = new Random();
    private String name;
    private int distanceTraveled;
    int speed;
    public static List<Vehicle> vehicleList;
    abstract void moveForAnHour(Race race);

    @Override
    public String toString(){
        return String.format("Name: %s, Distance: %s km", this.name, this.distanceTraveled);
    }
}
