package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {
    public static void main(String[] args) {
        System.out.println("Текущая дата: " + LocalDate.now());
        System.out.println("Текущее время: " + LocalTime.now());
        System.out.println("Текущее время: " + LocalDateTime.now());
        System.out.println("Текущее время: " + LocalDateTime.now());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(LocalDateTime.now().format(formatter));
    }
}