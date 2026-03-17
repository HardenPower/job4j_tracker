package ru.job4j.cast;

public class Aircraft implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " как птица, летит по воздуху.");
    }
}
