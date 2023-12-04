package ru.sbgeu.lichman.basic;

public class Human {
    private String name;
    private Transport currentTransport;


    // Человеческие силы
    private int hPower;

    private int humanPowerBikeConsumption;

    public int getHumanPower() {
        return hPower;
    }

    public Human(String name) {
        this.name = name;
        this.hPower = 10;
        this.humanPowerBikeConsumption = 50;
    }

    public float RequiredPower(int distance) {
        return distance * humanPowerBikeConsumption / 100;
    }

    public void decreasePower(int distance) {
        hPower = hPower - (distance * humanPowerBikeConsumption / 100);
        if (hPower < 0) {
            hPower = 0;
        }
    }


    public void freeTransport() {
        if (currentTransport != null) {
            System.out.println();
            System.out.println(name + " вышел из транспорта: " + ((LinkToTransport) currentTransport).transportName);
            currentTransport = null;
        } else {
            System.out.println(name + "  не в транспорте!");
        }
    }


    public void useTransport(Transport newTransport) {
        System.out.println();
        if (currentTransport == null) {
            currentTransport = newTransport;
            System.out.println(name + " сел в транспорт: " + ((LinkToTransport) newTransport).transportName);
        } else {
            System.out.println(
                    "Невозможно сесть в новый транспорт: " + ((LinkToTransport) newTransport).transportName);
            System.out.println("Надо выйти из  транспорта, так как человек уже в нем: "
                    + ((LinkToTransport) currentTransport).transportName);
        }
    }


    public boolean move(int distance, Location location) {

        if (currentTransport == null) {


            System.out.println();
            System.out.println(name + " должен переместиться пешком " +
                    " по местности: " + location.getNameRus() +
                    " на " + distance + " км.");


            if (hPower == 0) {
                System.out.println("Остаток сил у человека до перемещения: " + (float) hPower);
                System.out.println(
                        name + " не может перемеcтиться на " + distance + " км. У человека не хватает сил.");
                return false;
            }

            System.out.println(" Остаток сил у человека до перемещения: " + (float) hPower);
            System.out.println(
                    name + " успешно переместился пешком по местности: " + location.getNameRus() + " на "
                            + distance + " км.");
            System.out.println("Остаток сил у человека после перемещения: " + (float) hPower);
            return true;

        } else {
            return currentTransport.move(distance, location, this);
        }
    }
}