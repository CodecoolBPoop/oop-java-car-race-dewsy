package com.codecool.carRace;
import java.util.*;


public class Race {

    public boolean isThereABrokenTruck(){
        return deadTruck;
    }

    private static Random rand = new Random();
    public boolean deadTruck;

    private boolean isRaining; // is it raining currently.


    private void setRaining() {
        int rainOMeter = rand.nextInt(9);
        isRaining = (rainOMeter > 6);
    }

    public boolean isRaining() {
        return isRaining;
    }

    private void simulateRace(Race race) {
        for (int i = 0; i < 50; i++) {
            for (Vehicle vehicle : Vehicle.vehicleList) {
                vehicle.moveForAnHour(race);
            }
        }
    }

    private void printRaceResults () {
        for (Vehicle vehicle : Vehicle.vehicleList) {
            vehicle.toString();
        }
    }

    private void createVehicles() {
        for (int i = 0; i < 10; i++) {
            Vehicle.vehicleList.add(new Car());
        }
    }

    public static void main(String[] args) {
        Race race = new Race();
        race.createVehicles();// creates 10 cars, 10 trucks and 10 motorcycles.
        race.simulateRace(race);// simulates the race by
        // - calling moveForAnHour() on every vehicle 50 times
        // - setting whether its raining
        race.printRaceResults();// prints each vehicle's name, distance traveled and type.
    }
}
