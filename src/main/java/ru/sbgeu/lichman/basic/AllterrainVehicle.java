package ru.sbgeu.lichman.basic;

public class AllterrainVehicle extends  LinkToTransport implements Transport  {

    private int Volume;

    private int Consumption;

    public AllterrainVehicle (String transportName) {
        this.transportName = transportName;
        this.Volume = 150;
        this.Consumption = 40;
    }

    private float calcRequiredFuel(int distance) {
        return distance * Consumption / 100;
    }

    private void decreaseFuelVolume(int distance) {
        Volume = Volume - (distance * Consumption / 100);
        if (Volume < 0) {
            Volume = 0;
        }
    }

    @Override
    public boolean move(int distance, Location location, Human driver) {
            System.out.println();
            System.out.println("Поедет при помощи " + transportName +
                    " по местности: " + location.getNameRus() +
                    " на " + distance + " км.");

            if (Volume == 0 ||  calcRequiredFuel(distance) > Volume) {
                System.out.println(transportName + " не может перемеcтиться на " + distance + " км. Не хватает топлива.");
                return false;
            }

            System.out.println("Осталось топливо: " + (float) Volume + " л.");
            System.out.println(transportName + " успешно переместился по местности: "
                    + location.getNameRus()
                    + " на " + distance + " км.");
            decreaseFuelVolume(distance);
            System.out.println("Осталось топливо: " + (float) Volume + " л.");
            return true;
    }
}
