package ru.sbgeu.lichman.basic;

public class Main {
    public static void main(String[] args) {

    Human human = new Human("Lena");

    Transport transportCar = new Car(" Автомобиль");
    Transport transportOfRoader = new AllterrainVehicle("Вездеход");
    Transport transportHorse = new Horse("Лошадь");
    Transport transportBicycle = new Bike("Велосипед");

        human.useTransport(transportHorse);
}}