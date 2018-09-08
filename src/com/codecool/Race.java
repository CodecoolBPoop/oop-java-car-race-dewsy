package com.codecool;
import java.lang.reflect.Modifier;
import java.util.*;


public class Race {

    private static int nameNumber = 0; // The number of the instance created. Used for its name.
    private boolean isThereABrokenTruck(){
        return deadTruck;
    }

    private static Random rand = new Random();
    private boolean deadTruck = false;
    private boolean isRaining; // is it raining currently.
    private ArrayList<Car> listOfCars = new ArrayList<>();
    private ArrayList<Motorcycle> listOfMotorcycles = new ArrayList<>();
    private ArrayList<Truck> listOfTrucks = new ArrayList<>();
    private void setRaining() {
        int rainOMeter = rand.nextInt(9);
        if (rainOMeter <= 6) {
            isRaining = false;
        } else {
            isRaining =true;
        }
    }


    interface Vehicle {

        String name;
        int distanceTraveled;
        int speed;
        void moveForAnHour(Race race);
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

            public void moveForAnHour(Race race) {
                if (race.isThereABrokenTruck()) {
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

            public void moveForAnHour(Race race) {
                if (isRaining) {
                    this.distanceTraveled += this.speed - (rand.nextInt(45) + 5);
                } else if (race.isThereABrokenTruck()) {
                    this.distanceTraveled += 75;
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
            private boolean isItBrokeDown(Race race) {
                if ((rand.nextInt(99) + 1) > 95) {
                    race.deadTruck = true;
                    this.breakdownTurnsLeft = 2;
                    return true;
                } else if (this.breakdownTurnsLeft > 0) {
                    this.breakdownTurnsLeft -= 1;
                    return true;
                } else {
                    return false;
                }
            }

            public void moveForAnHour(Race race) {
                if (!isItBrokeDown(race)) {
                    if (!deadTruck) {
                        this.distanceTraveled += speed;
                    } else {
                        this.distanceTraveled += 75;
                    }
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

        private void createVehicles() {
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            listOfCars.add(car);
        }
        for (int i = 0; i < 10; i++) {
            Motorcycle moto = new Motorcycle();
            listOfMotorcycles.add(moto);
        }
        for (int i = 0; i < 10; i++) {
            Truck truck = new Truck();
            listOfTrucks.add(truck);
        }
    }

    private void simulateRace(Race race) {
        for (int i = 0; i < 50; i++) {
            race.setRaining();
            Iterator carIterator = listOfCars.iterator();
            while (carIterator.hasNext()) {
                 carIterator.next()

            }
        }
    }


    public static void main(String[] args) {
        Race race = new Race();

        race.createVehicles();// creates 10 cars, 10 trucks and 10 motorcycles.
        simulateRace() // simulates the race by
        // - calling moveForAnHour() on every vehicle 50 times
        // - setting whether its raining
        printRaceResults() // prints each vehicle's name, distance traveled and type.
    }
}
