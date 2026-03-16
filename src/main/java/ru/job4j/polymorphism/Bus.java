package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("Transport is moving");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Default amount of passengers");
    }

    @Override
    public int refuel(int fuel) {
        return 0;
    }
}
