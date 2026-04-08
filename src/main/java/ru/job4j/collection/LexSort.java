package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String first = left.split("\\.")[0];
        String second = right.split("\\.")[0];
        return Integer.compare(Integer.parseInt(first), Integer.parseInt(second));
    }
}