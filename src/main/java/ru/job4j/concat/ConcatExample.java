package ru.job4j.concat;

import java.util.StringJoiner;

public class ConcatExample {
    public static void main(String[] args) {
        String string = "abc" + "def" + "ghi";
        StringBuilder builder = new StringBuilder("abc");
        builder.append("def").append("ghi");
        System.out.println(builder);
        String string2 = "abc".concat("def").concat("ghi").concat("jkl");
        System.out.println(string2);

        String string3 = String.join(" ", "abc", "def", "ghi");
        System.out.println(string3);

        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        stringJoiner.add("abc").add("def").add("ghi");
        System.out.println(stringJoiner);
        String joined = stringJoiner.toString();
        System.out.println(joined);
    }
}