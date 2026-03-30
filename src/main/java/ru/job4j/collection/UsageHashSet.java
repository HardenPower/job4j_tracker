package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>(Arrays.asList("Lada", "BMW", "Volvo", "Toyota"));
        for (String item : autos) {
            System.out.println(item);
        }
    }
}