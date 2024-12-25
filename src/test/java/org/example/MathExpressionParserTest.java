package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathExpressionParserTest {

    private MathExpressionParser parser;

    @BeforeEach
    void setUp() {
        parser = new MathExpressionParser("3 + 5 * 2");
    }

    @Test
    void getExpression() {
        String expression = parser.getExpression();
        assertEquals("3 + 5 * 2", expression);
    }

    @Test
    void evaluateExpression() {
        double result = parser.evaluateExpression();
        assertEquals(13.0, result, 0.0001);

        parser = new MathExpressionParser("10 + 2 * 6");
        result = parser.evaluateExpression();
        assertEquals(22.0, result, 0.0001);

        parser = new MathExpressionParser("100 * 2 + 12");
        result = parser.evaluateExpression();
        assertEquals(212.0, result, 0.0001);

        parser = new MathExpressionParser("100 * (2 + 12)");
        result = parser.evaluateExpression();
        assertEquals(1400.0, result, 0.0001);
    }

    @Test
    void areBracketsBalanced() {
        boolean result = parser.areBracketsBalanced();
        assertTrue(result);

        parser = new MathExpressionParser("3 + 5 * (2 + 1)");
        result = parser.areBracketsBalanced();
        assertTrue(result);

        parser = new MathExpressionParser("3 + 5 * (2 + 1");
        result = parser.areBracketsBalanced();
        assertEquals(false, result);
    }

    @Test
    void parseExpression() {
        List<String> tokens = parser.parseExpression("3 + 5 * 2");
        assertEquals(Arrays.asList("3", "+", "5", "*", "2"), tokens);

        parser = new MathExpressionParser("10 + 2 * 6");
        tokens = parser.parseExpression("10 + 2 * 6");
        assertEquals(Arrays.asList("10", "+", "2", "*", "6"), tokens);

        parser = new MathExpressionParser("100 * (2 + 12)");
        tokens = parser.parseExpression("100 * (2 + 12)");
        assertEquals(Arrays.asList("100", "*", "(", "2", "+", "12", ")"), tokens);
    }

    @Test
    void isOperator() {
        boolean result = parser.isOperator('+');
        assertTrue(result);

        result = parser.isOperator('*');
        assertTrue(result);

        result = parser.isOperator('a');
        assertEquals(false, result);
    }

    @Test
    void isParenthesis() {
        boolean result = parser.isParenthesis('(');
        assertTrue(result);

        result = parser.isParenthesis(')');
        assertTrue(result);

        result = parser.isParenthesis('a');
        assertEquals(false, result);
    }
}