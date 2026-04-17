package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-21, -2, -1, 0, 5, 6, 7, 8, 9);
        List<Integer> positive = numbers.stream().filter(pos -> pos > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}