package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String result = switch (position) {
            case 1 -> "Пусть бегут неуклюже";
            case 2 -> "Спокойной ночи";
            default -> "Песня не найдена";
        };
        System.out.println(result);
    }

    public static void main(String[] args) {
        Jukebox obj = new Jukebox();
        obj.music(1);
        obj.music(2);
        obj.music(3);
        obj.music(99);
    }
}
