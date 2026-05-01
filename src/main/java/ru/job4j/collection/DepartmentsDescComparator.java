package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String rootLeft = left.split("/")[0];
        String rootRight = right.split("/")[0];
        int rootCompare = rootRight.compareTo(rootLeft);
        if (rootCompare == 0) {
            return left.compareTo(right);
        }
        return rootCompare;
    }
}