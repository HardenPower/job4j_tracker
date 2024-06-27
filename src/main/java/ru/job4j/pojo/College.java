package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullname("Иванов Иван Иванович");
        student.setGroup("101А");
        student.setDateFrom(new Date());
        System.out.println("Студент - " + student.getFullname() + ". " + "Группа - " + student.getGroup() + ". Дата зачисления: " + student.getDateFrom());
    }
}
