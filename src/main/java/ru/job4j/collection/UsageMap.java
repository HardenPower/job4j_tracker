package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("j4j@ya.ru", "John Malcolm Doe");
        map.put("admin@ya.ru", "Admin Admin Admin");
        map.put("admin@vk.ru", "VK CEO");
        map.put("admin@vk.ru", "VK CTO");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
