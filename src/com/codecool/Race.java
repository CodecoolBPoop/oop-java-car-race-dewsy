package com.codecool;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Race {

    static int nameNumber = 0; // The number of the instance created. Used for its name.


    interface Vehicle {

        Random rand = new Random();
        String name;
        int distanceTraveled;
        int speed;
        void moveForAnHour();


    }

    public static void main(String[] args) {

        Random rand = new Random();
        createVehicles() // creates 10 cars, 10 trucks and 10 motorcycles.
        simulateRace() // simulates the race by
        // - calling moveForAnHour() on every vehicle 50 times
        // - setting whether its raining
        printRaceResults() // prints each vehicle's name, distance traveled and type.
        boolean isThereABrokenTruck()//

        boolean isRaining; // is it raining currently.

        static void setRaining() {
            int rainOMeter = rand.nextInt(9);
            if (rainOMeter <= 6) {
                isRaining = false;
            } else {
                isRaining =true;
            }
        }


        class Car implements Vehicle{

            private String[] carNames = {"Chase", "Reflect", "Freedom", "Origin", "Stardust", "Flux",
                    "Prophecy", "Inception", "Rune", "Formula"};
            private int speed;
            public String name;
            public int distanceTraveled;


            private String pickName() {
                return carNames[rand.nextInt(9)];
            }

            public void moveForAnHour() {
                if (isThereABrokenTruck) {
                    this.distanceTraveled += 75;
                } else {
                    this.distanceTraveled += this.speed;
                }
            } // The vehicle travels for an hour. It increases the distance traveled. Call this from the main class only!

            Car() {
                this.speed = rand.nextInt(30) + 80;
                this.name = String.format("%s %s", pickName(), pickName());
            }


            //!!!!! If there is a broken down Truck on the track, then limit the max speed of vehicles to 75 km/h.
        }

        class Motorcycle implements Vehicle { // speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly).

            int speed = 100;
            public int distanceTraveled;
            String name; // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.

            public void moveForAnHour() {
                if (isRaining) {
                    this.distanceTraveled += this.speed - (rand.nextInt(45) + 5);
                } else {
                    this.distanceTraveled += this.speed;
                }
            }

            Motorcycle() {
                     nameNumber += 1;
                     this.name = String.format("Motorcycle %d", nameNumber);
            }
        }

        class Truck implements Vehicle { // speed: 100km/h. 5% chance of breaking down for 2 hours.
            // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.
            private int breakdownTurnsLeft; // holds how long its still broken down.
            public int distanceTraveled;
            private int speed = 100;
            public String name;
            private boolean isItBrokeDown() {
                if ((rand.nextInt(99) + 1) > 95) {
                    isThereABrokenTruck = true;
                    this.breakdownTurnsLeft = 2;
                    return true;
                } else if (this.breakdownTurnsLeft > 0) {
                    this.breakdownTurnsLeft -= 1;
                    return true;
                } else {
                    return false;
                }
            }

            public void moveForAnHour() {
                if (!isItBrokeDown()) {
                    this.distanceTraveled += speed;
                }
            }

            private String nameGenerator() {
                int name = rand.nextInt(999) +1;
                return Integer.toString(name);
            }

            Truck() {
                this.name = nameGenerator();
            }
        }


    }
    static main(String[]) // The entry point of our program.
}
