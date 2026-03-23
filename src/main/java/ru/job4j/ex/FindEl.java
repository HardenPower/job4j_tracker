package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Индекс искомого элемента в массиве не найден");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] data = new String[]{"Hello", "Mister", "Mentor", "Good", "Day", "Nice", "Try", "Catch"};
        try {
            indexOf(data, "API");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
