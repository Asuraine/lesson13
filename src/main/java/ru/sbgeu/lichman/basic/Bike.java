package ru.sbgeu.lichman.basic;

public class Bike extends  LinkToTransport implements Transport {
    public Bike(String transportName) {
        this.transportName = transportName;
    }
    @Override
    public boolean move(int distance, Location location, Human driver) {
        System.out.println();
        System.out.println(" Поедет при помощи " + transportName +
                " по местности: " +  location.getNameRus() +
                " на " + distance + " км.");

        if (location == location.SWAMP) {
            System.out.println(transportName + " не может перемещаться по местности: " + location.getNameRus());
            return false;
        }

        if ( driver.getHumanPower() == 0 || driver.RequiredPower(distance) > driver.getHumanPower()) {
            System.out.println(transportName + " не может перемеcтиться на " + distance + " км. Не хватает сил водителя.");
            return false;
        }

        System.out.println("Остаток сил: " + (float) driver.getHumanPower() );
        System.out.println(transportName + " успешно переместился по местности: " + location.getNameRus() + " на " + distance + " км.");
        driver.decreasePower(distance);
        System.out.println("Остаток сил: " + (float) driver.getHumanPower());
        return true;
    }
}