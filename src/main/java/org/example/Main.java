package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическое выражение:");
        String expression = scanner.nextLine();

        MathExpressionParser parser = new MathExpressionParser(expression);
        try {
            double result = parser.evaluateExpression();
            System.out.println("Результат: " + result);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}