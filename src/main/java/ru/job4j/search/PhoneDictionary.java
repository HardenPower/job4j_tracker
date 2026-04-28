package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> name = rsl -> rsl.getName() != null && rsl.getName().contains(key);
        Predicate<Person> surName = rsl -> rsl.getSurname() != null && rsl.getSurname().contains(key);
        Predicate<Person> phone = rsl -> rsl.getPhone() != null && rsl.getPhone().contains(key);
        Predicate<Person> address = rsl -> rsl.getAddress() != null && rsl.getAddress().contains(key);
        Predicate<Person> combine = name.or(surName).or(phone).or(address);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
