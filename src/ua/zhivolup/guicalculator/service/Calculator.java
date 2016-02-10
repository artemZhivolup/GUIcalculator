package ua.zhivolup.guicalculator.service;

public class Calculator {
    public static double calculate(double a, double b, char operation){
        double result;
        switch (operation){
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Not supported operation: " + operation);
        }
        return result;
    }
}
