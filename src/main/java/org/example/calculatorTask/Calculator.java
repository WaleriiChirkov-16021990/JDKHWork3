package org.example.calculatorTask;

public class Calculator {
    public static<T extends Number, N extends Number> Number sum(T a, N b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static<T extends Number,N extends Number> Number sub(T a, N b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static<T extends Number,N extends Number> Number mul(T a, N b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static<T extends Number,N extends Number> Number div(T a, N b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a.doubleValue() / b.doubleValue();
    }

}
