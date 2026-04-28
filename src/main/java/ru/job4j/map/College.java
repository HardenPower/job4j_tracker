package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Student stud = students.keySet()
                .stream()
                .filter(student -> student.account().equals(account))
                .findFirst()
                .orElse(null);
        if (stud == null) {
            return Optional.empty();
        }
        return Optional.of(stud);
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> studentOptional = findByAccount(account);
        if (!studentOptional.isPresent()) {
            return Optional.empty();
        }
        Student student = studentOptional.get();
        Subject subjects =  students.get(student)
                    .stream()
                    .filter(subject -> subject.name().equals(name))
                    .findFirst()
                    .orElse(null);
        if (subjects == null) {
           return Optional.empty();
        }
        return Optional.of(subjects);
    }
}
