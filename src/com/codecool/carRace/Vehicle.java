package com.codecool.carRace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Vehicle {

    static Random rand = new Random();
    private String name;
    private int distanceTraveled;
    int speed;
    abstract void moveForAnHour(Race race);


}
