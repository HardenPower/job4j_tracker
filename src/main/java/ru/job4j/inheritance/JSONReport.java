package ru.job4j.inheritance;

public class JSONReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        String ln = System.lineSeparator();
        String dQuote = "\"";
        return "{" + ln + "\t\"name\" : " +  dQuote + name + dQuote + "," + ln
            + "\t\"body\" : " +  dQuote + body + dQuote + ln + "}";
    }
}
