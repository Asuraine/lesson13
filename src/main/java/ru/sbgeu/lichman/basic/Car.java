package ru.sbgeu.lichman.basic;

public class Car extends LinkToTransport implements Transport {

    private int fuelVolume;

    private int fuelConsumption;


    public Car(String transportName) {
        this.transportName = transportName;
        this.fuelVolume = 50;
        this.fuelConsumption = 10;
    }

    private float calcRequiredFuel(int distance) {
        return distance * fuelConsumption / 100;
    }

    private void decreaseFuelVolume(int distance) {
        fuelVolume = fuelVolume - (distance * fuelConsumption / 100);
        if (fuelVolume < 0) {
            fuelVolume = 0;
        }
    }

    @Override
    public boolean move(int distance, Location location, Human driver) {
        System.out.println();
        System.out.println("Поедет при помощи " + transportName +
                " по местности: " + location.getNameRus() + " на " + distance + " км.");

        if (location == location.FOREST || location == location.SWAMP) {
            System.out.println(transportName + " не может перемещаться по местности: " + location.getNameRus());
            return false;
        }

        if (fuelVolume == 0 || calcRequiredFuel(distance) > fuelVolume) {
            System.out.println(transportName + " не может перемеcтиться на " + distance + " км. Не хватает топлива.");
            return false;
        }

        System.out.println("Осталось топливо: " + (float) fuelVolume + " л.");
        System.out.println(transportName + " успешно переместился по местности: " + location.getNameRus() + " на " + distance + " км.");
        decreaseFuelVolume(distance);
        System.out.println("Осталось топливо: " + (float) fuelVolume + " л.");

        return true;

    }
}



