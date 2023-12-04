package ru.sbgeu.lichman.basic;

public class Horse extends LinkToTransport implements Transport {
    private int horsePowerConsumption;

    private int Power;

    public Horse(String transportName) {
        this.transportName = transportName;
        this.Power = 10;
        this.horsePowerConsumption = 40;
    }

    private float calcRequiredPower(int distance) {
        return distance * horsePowerConsumption / 100;
    }

    private void decreasePower(int distance) {
        Power = Power - (distance * horsePowerConsumption / 100);
        if (Power < 0) {
            Power = 0;
        }
    }

    @Override
    public boolean move(int distance, Location location, Human driver) {
        System.out.println();
        System.out.println("Поедет при помощи " + transportName +
                " по местности: " + location.getNameRus() +
                " на " + distance + " км.");

        if (location == location.SWAMP) {
            System.out.println(transportName + " не может перемещаться по местности: " + location.getNameRus());
            return false;
        }


        if (Power == 0 || calcRequiredPower(distance) > Power) {
            System.out.println(transportName + " не может перемеcтиться на " + distance + " км. Нет сил.");
            return false;
        }

        System.out.println("Остаток сил у лошади до перемещения: " + (float) Power);
        System.out.println(transportName + " успешно переместилась по местности: " + location.getNameRus() + " на " + distance + " км.");
        decreasePower(distance);
        System.out.println("Остаток сил у лошади после перемещения: " + (float) Power);
        return true;
    }
}