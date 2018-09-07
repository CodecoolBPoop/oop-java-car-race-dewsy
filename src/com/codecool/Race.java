package com.codecool;

public class Race {

    public static void main(String[] args) {
	// write your code here
        createVehicles() // creates 10 cars, 10 trucks and 10 motorcycles.
        simulateRace() // simulates the race by
        // - calling moveForAnHour() on every vehicle 50 times
        // - setting whether its raining
        printRaceResults() // prints each vehicle's name, distance traveled ant type.
        boolean isThereABrokenTruck() //

        Weather
 static setRaining() // 30% chance of rain.
        static boolean isRaining() // is it raining currently.

        Car
        normalSpeed // the normal speed of the car. Set to a random number in the constructor between 80-110km/h.
        name // Make a list from the words here: http://www.fantasynamegenerators.com/car-names.php and pick 2 randomly for each instance.
        distanceTraveled // holds the current distance traveled.
        moveForAnHour(Race race) // The vehicle travels for an hour. It increases the distance traveled. Call this from the main class only!
        // If there is a broken down Truck on the track, then limit the max speed of vehicles to 75 km/h.

        Motorcycle // speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly).
        static nameNumber // The number of the instance created. Used for its name.
        name // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
        distanceTraveled
        moveForAnHour(Race race)

        Truck // speed: 100km/h. 5% chance of breaking down for 2 hours.
        // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.
        breakdownTurnsLeft // holds how long its still broken down.
        distanceTraveled
        moveForAnHour(Race race)


 static main(String[]) // The entry point of our program.
    }
}
