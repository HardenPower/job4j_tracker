package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных Account, с полями для реквизитов (requisite) и баланса (balance)
 * @author Alexey B.Harden
 * @version 1.0
 */
public class Account {
    /**
     * Поля класса - {@code requisite}, {@code balance}
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор класса принимает на вход эти поля
     * @param requisite (строковое поле для рекизитов)
     * @param balance (поле для баланса с плавающей точкой)
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Простейший "геттер" для поля {@code requisite}
     * @return поле {@code requisite}
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Простейший "сеттер", устанавливается новое значение поля {@code requisite} класса
     * @param requisite новое значение для поля {@code requisite}
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Простейший "геттер" для поля {@code balance}
     * @return поле {@code balance}
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Простейший "сеттер", устанавливается новое значение поля {@code requisite} класса
     * @param balance новое значение для поля balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     *
     * @param o объект который передается для сравнения значения текущего поля {@code requisite} со значением
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Возвращает hashcode объекта, вычисленный на основе поля {@code requisite}.
     * @return hashcode, основанный на {@code requisite}
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}