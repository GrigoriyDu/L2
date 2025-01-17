package org.example;

import java.util.List;
import java.util.Stack;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Класс для разбора математических выражений.
 */
public class MathExpressionParser {
    private String expression;

    /**
     * Конструктор класса.
     *
     * @param expression математическое выражение
     */
    public MathExpressionParser(String expression) {
        this.expression = expression;
    }

    /**
     * Получить математическое выражение.
     *
     * @return математическое выражение
     */
    public String getExpression() {
        return expression;
    }

    /**
     * Метод для проверки корректности математического выражения и вычисления его, если все в порядке.
     *
     * @return результат вычисления выражения
     * @throws RuntimeException если скобки в выражении не сбалансированы
     */
    public double evaluateExpression() {
        if (areBracketsBalanced()) {
            List<String> tokens = parseExpression(expression);
            MathExpressionCalculator calculator = new MathExpressionCalculator();
            return calculator.computeExpression(tokens);
        }
        throw new RuntimeException("Скобки в выражении не сбалансированы");
    }

    /**
     * Проверить сбалансированность скобок в математическом выражении.
     *
     * @return true, если скобки сбалансированы, иначе false
     */
    public boolean areBracketsBalanced() {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Разбор математического выражения на токены.
     *
     * @param expression математическое выражение
     * @return список токенов
     */
    public List<String> parseExpression(String expression) {
        List<String> tokens = new ArrayList<>();
        StringBuilder currentToken = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                currentToken.append(c);
            } else if (isOperator(c) || isParenthesis(c)) {
                if (currentToken.length() > 0) {
                    tokens.add(currentToken.toString());
                    currentToken = new StringBuilder();
                }
                tokens.add(String.valueOf(c));
            } else if (Character.isLetter(c)) {
                System.out.println("Введите значение для переменной " + c + ":");
                String value = scanner.nextLine();
                tokens.add(value);
            }
        }

        if (currentToken.length() > 0) {
            tokens.add(currentToken.toString());
        }

        return tokens;
    }

    /**
     * Проверить, является ли символ оператором.
     *
     * @param c символ
     * @return true, если символ является оператором, иначе false
     */
    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * Проверить, является ли символ скобкой.
     *
     * @param c символ
     * @return true, если символ является скобкой, иначе false
     */
    public boolean isParenthesis(char c) {
        return c == '(' || c == ')';
    }
}