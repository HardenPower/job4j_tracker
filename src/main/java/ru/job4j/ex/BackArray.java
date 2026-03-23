package ru.job4j.ex;

public class BackArray {
    public String[] turn(String[] names) {
        int middle = names.length / 2;
        int count = names.length - 1;
        for (int index = 0; index < middle; index++) {
            String temp = names[index];
            names[index] = names[count - index];
            names[count - index] = temp;
        }
        return names;
    }
}