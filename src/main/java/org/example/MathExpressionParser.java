package org.example;

import java.util.List;

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
        return 0;
    }

    /**
     * Проверить сбалансированность скобок в математическом выражении.
     *
     * @return true, если скобки сбалансированы, иначе false
     */
    public boolean areBracketsBalanced() {
        return false;
    }

    /**
     * Разбор математического выражения на токены.
     *
     * @param expression математическое выражение
     * @return список токенов
     */
    public List<String> parseExpression(String expression) {
        return null;
    }

    /**
     * Проверить, является ли символ оператором.
     *
     * @param c символ
     * @return true, если символ является оператором, иначе false
     */
    public boolean isOperator(char c) {
        return false;
    }

    /**
     * Проверить, является ли символ скобкой.
     *
     * @param c символ
     * @return true, если символ является скобкой, иначе false
     */
    public boolean isParenthesis(char c) {
        return false;
    }
}