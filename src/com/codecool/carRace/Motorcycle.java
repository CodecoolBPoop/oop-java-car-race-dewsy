package com.codecool.carRace;

class Motorcycle extends Vehicle { // speed is 100km/h. If it rains, travels with 5-50km/h slower (randomly).

    private static int nameNumber = 0; // The number of the instance created. Used for its name.
    private int speed = 100;
    public int distanceTraveled;
    String name; // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.

    Motorcycle() {
        nameNumber += 1;
        this.name = String.format("Motorcycle %d", nameNumber);
    }

    @Override
    public void moveForAnHour(Race race) {
        if (race.isRaining()) {
            this.distanceTraveled += this.speed - (rand.nextInt(45) + 5);
        } else if (race.isThereABrokenTruck()) {
            this.distanceTraveled += 75;
        } else {
            this.distanceTraveled += this.speed;
        }
    }

    @Override
    public String toString(){
        return String.format("Name: %s, Distance: %s km", this.name, this.distanceTraveled);
    }

}
