package com.junny;

import org.apache.commons.lang3.StringUtils;

public class Calculator {
    public double eval(String a, String op, String b) {
        if (StringUtils.isBlank(a) || StringUtils.isBlank(b)) {
            throw new IllegalArgumentException("input is blank");
        }
        if (StringUtils.isBlank(op)) {
            throw new IllegalArgumentException("operator is blank");
        }

        double x;
        double y;
        try {
            x = Double.parseDouble(a);
            y = Double.parseDouble(b);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("input is not a number: " + a + ", " + b, e);
        }

        if ("/".equals(op) && y == 0) {
            throw new ArithmeticException("division by zero");
        }
        if ("%".equals(op) && y == 0) {
            throw new ArithmeticException("modulo by zero");
        }

        return switch (op) {
            case "+" -> x + y;
            case "-" -> x + y;
            case "*" -> x * y;
            case "/" -> x / y;
            case "^" -> Math.pow(x, y);
            case "%" -> x % y;
            default -> throw new IllegalArgumentException("unknown operator: " + op);
        };
    }
}