package org.example;

import java.util.List;
import java.util.Stack;

/**
 * Класс для вычисления математических выражений.
 */
public class MathExpressionCalculator {

    /**
     * Метод для вычисления математического выражения на основе алгоритма сортировочной станции.
     *
     * @param tokens математическое выражение
     * @return результат вычисления выражения
     */
    public double computeExpression(List<String> tokens) {
        if (tokens == null || tokens.isEmpty()) {
            return 0;
        }

        Stack<Double> valueStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        for (String token : tokens) {
            if (isNumeric(token)){
                // Пустой блок кода
            }
        }
        return 0;
    }

    /**
     * Метод для проверки, является ли строка числом.
     *
     * @param token строка для проверки
     * @return true, если строка является числом, иначе false
     */
    private boolean isNumeric(String token) {
        return Character.isDigit(token.charAt(0));
    }
}

