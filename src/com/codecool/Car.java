package com.codecool;

public class Car extends Vehicle{

    private String[] carNames = {"Chase", "Reflect", "Freedom", "Origin", "Stardust", "Flux",
            "Prophecy", "Inception", "Rune", "Formula"};
    private int speed;
    public String name;
    public int distanceTraveled;


    Car() {
        this.speed = rand.nextInt(30) + 80;
        this.name = String.format("%s %s", pickName(), pickName());
    }

    private String pickName() {
        return carNames[rand.nextInt(10)];
    }

    @Override
    public void moveForAnHour(Race race) {
        this.distanceTraveled += race.isThereABrokenTruck() ? 75 : this.speed;
    } // The vehicle travels for an hour. It increases the distance traveled. Call this from the main class only!


    //!!!!! If there is a broken down Truck on the track, then limit the max speed of vehicles to 75 km/h.
}
