package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    @Test
    public void whenException() {
        String text = "Number could not be less than 0";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    new Factorial().calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo(text);
    }

    @Test
    public void whenCorrect() {
        int result = new Factorial().calc(3);
        assertThat(result).isEqualTo(6);
    }

}