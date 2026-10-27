package com.junny;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator c = new Calculator();

    @Test
    void addWorks() {
        assertEquals(4.0, c.eval("2", "+", "2"));
    }

    @Test
    void subtractWorks() {
        assertEquals(3.0, c.eval("5", "-", "2"));
    }

    @Test
    void multiplyWorks() {
        assertEquals(6.0, c.eval("2", "*", "3"));
    }

    @Test
    void divideWorks() {
        assertEquals(2.0, c.eval("10", "/", "5"));
    }

    @Test
    void powerWorks() {
        assertEquals(8.0, c.eval("2", "^", "3"));
    }

    @Test
    void moduloWorks() {
        assertEquals(1.0, c.eval("10", "%", "3"));
    }

    @Test
    void blankInputThrows() {
        assertThrows(IllegalArgumentException.class, () -> c.eval("", "+", "2"));
        assertThrows(IllegalArgumentException.class, () -> c.eval("2", "+", ""));
        assertThrows(IllegalArgumentException.class, () -> c.eval("2", "", "3"));
    }

    @Test
    void nonNumericInputThrows() {
        assertThrows(IllegalArgumentException.class, () -> c.eval("abc", "+", "2"));
        assertThrows(IllegalArgumentException.class, () -> c.eval("2", "+", "xyz"));
    }

    @Test
    void divisionByZeroThrows() {
        assertThrows(ArithmeticException.class, () -> c.eval("10", "/", "0"));
    }

    @Test
    void moduloByZeroThrows() {
        assertThrows(ArithmeticException.class, () -> c.eval("10", "%", "0"));
    }

    @Test
    void unknownOperatorThrows() {
        assertThrows(IllegalArgumentException.class, () -> c.eval("2", "?", "3"));
    }
}