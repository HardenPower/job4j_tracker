package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation(int s) {
        return sum(s) + multiply(s) + minus(s) + divide(s);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(sum(10));
        System.out.println(calc.multiply(5));
        System.out.println(minus(5));
        System.out.println(calc.divide(5));
        System.out.println(calc.sumAllOperation(5));
    }
}
