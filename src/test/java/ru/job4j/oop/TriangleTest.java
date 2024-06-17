package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TriangleTest {
    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 8;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when00and010and04ThenMinus1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 10);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when000and01010and0410Then10Dot77() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 10, 10);
        Point c = new Point(0, 4, 10);
        double result = c.distance3d(a);
        double expected = 10.77;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void when000and01010and0410Then14Dot1() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 10, 10);
        Point c = new Point(0, 4, 10);
        double result = b.distance3d(a);
        double expected = 14.1;
        assertThat(result).isCloseTo(expected, offset(0.1));
    }

    @Test
    public void when000and01010and0410Then6() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(0, 10, 10);
        Point c = new Point(0, 4, 10);
        double result = c.distance3d(b);
        double expected = 6;
        assertThat(result).isCloseTo(expected, offset(0.1));
    }

    @Test
    public void when000and01010and0410Then10Dot18() {
        Point a = new Point(0, 0, 20);
        Point b = new Point(0, 15, 10);
        Point c = new Point(6, 7, 8);
        double result = b.distance3d(c);
        double expected = 10.18;
        assertThat(result).isCloseTo(expected, offset(0.1));
    }
}