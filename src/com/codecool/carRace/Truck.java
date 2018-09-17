package com.codecool.carRace;

class Truck extends Vehicle { // speed: 100km/h. 5% chance of breaking down for 2 hours.
    // Truck drivers are boring. They call all their trucks a random number between 0 and 1000.
    private int breakdownTurnsLeft; // holds how long its still broken down.
    public int distanceTraveled;
    private int speed = 100;
    public String name;

    Truck() {
        this.name = nameGenerator();
    }

    private boolean isItBrokeDown(Race race) {
        boolean isItBreakingDownNow = (rand.nextInt(100)) > 95;
        if (isItBreakingDownNow) {
            race.deadTruck = true;
            breakdownTurnsLeft = 2;
            return true;
        } else if (this.breakdownTurnsLeft > 0) {
            this.breakdownTurnsLeft -= 1;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void moveForAnHour(Race race) {
        if (!isItBrokeDown(race)) {
            this.distanceTraveled += race.deadTruck ? 75 : speed;
        }
    }

    private String nameGenerator() {
        int name = rand.nextInt(1000);
        return Integer.toString(name);
    }

}

