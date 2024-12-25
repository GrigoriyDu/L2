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
            if (isNumeric(token)) {
                valueStack.push(Double.parseDouble(token));
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                processParenthesis(valueStack, operatorStack);
            } else {
                processOperator(token, valueStack, operatorStack);
            }
        }
        return 0;
    }

    /**
     * Метод для обработки операторов и выполнения операций.
     *
     * @param token текущий оператор
     * @param valueStack стек значений
     * @param operatorStack стек операторов
     */
    private void processOperator(String token, Stack<Double> valueStack, Stack<String> operatorStack) {
        while (!operatorStack.isEmpty() && getOperatorPriority(operatorStack.peek()) >= getOperatorPriority(token)) {
            valueStack.push(performOperation(valueStack.pop(), valueStack.pop(), operatorStack.pop()));
        }
        operatorStack.push(token);
    }

    /**
     * Метод для определения приоритета оператора.
     *
     * @param operator оператор
     * @return приоритет оператора
     */
    private int getOperatorPriority(String operator) {
        switch (operator) {
            case "(": return 0;
            case "+": return 1;
            case "-": return 1;
            case "*": return 2;
            case "/": return 2;
            default: return 2;
        }
    }

    /**
     * Метод для обработки скобок и выполнения операций внутри них.
     *
     * @param valueStack стек значений
     * @param operatorStack стек операторов
     */
    private void processParenthesis(Stack<Double> valueStack, Stack<String> operatorStack) {
        while (!operatorStack.peek().equals("(")) {
            valueStack.push(performOperation(valueStack.pop(), valueStack.pop(), operatorStack.pop()));
        }
        operatorStack.pop();
    }

    /**
     * Метод для выполнения операции над двумя числами с использованием оператора.
     *
     * @param left левое число
     * @param right правое число
     * @param operator оператор
     * @return результат операции
     */
    private double performOperation(double left, double right, String operator) {
        char op = operator.charAt(0);
        switch (op) {
            case '+': return left + right;
            case '-': return right - left;
            case '*': return left * right;
            case '/': return (double) right / left;
            default: return right;
        }
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

