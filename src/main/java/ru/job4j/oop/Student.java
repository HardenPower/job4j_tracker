package ru.job4j.oop;

public class Student {

    public void music() {
        System.out.println("Tra tra tra");
    }

    public void sing() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        short count = 0;
        while (count < 3) {
            petya.music();
            count++;
        }
        for (int i = 0; i < 3; i++) {
            petya.sing();
        }

    }
}
