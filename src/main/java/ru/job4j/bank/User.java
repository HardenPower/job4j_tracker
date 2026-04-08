package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных User, с полями для номера паспорта (passport) и ФИ (username)
 * @author Alexey B.Harden
 * @version 1.0
 */
public class User {
    /**
     * Поля класса - {@code passport}, {@code username}
     */
    private String passport;
    private String username;

    /**
     * Конструктор класса принимает на вход эти поля
     * @param passport (строковое поле для номера паспорта)
     * @param username (строковое поле для фамилии и имени)
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Простейший "геттер" для поля {@code passport}
     * @return поле {@code passport}
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Простейший "сеттер", устанавливается новое значение поля {@code passport} класса
     * @param passport новое значение для поля {@code passport}
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Простейший "геттер" для поля {@code username}
     * @return поле {@code username}
     */
    public String getUsername() {
        return username;
    }

    /**
     * Простейший "сеттер", устанавливается новое значение поля {@code username} класса
     * @param username новое значение для поля balance
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
    @param o объект который передается для сравнения значения текущего поля {@code passport} со значением
     * этого поля переданного объекта
     * @return возвращается результат сравнения (true/false)
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает hashcode объекта, вычисленный на основе поля {@code requisite}.
     * @return hashcode, основанный на {@code passport}
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}