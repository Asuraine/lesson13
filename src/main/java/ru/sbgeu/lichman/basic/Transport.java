package ru.sbgeu.lichman.basic;

public interface Transport {

    boolean move(int distance, Location location, Human driver);
}