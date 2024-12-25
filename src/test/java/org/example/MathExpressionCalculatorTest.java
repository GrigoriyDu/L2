package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathExpressionCalculatorTest {

    private MathExpressionCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new MathExpressionCalculator();
    }

    @Test
    void computeExpression() {
        List<String> tokens = Arrays.asList("3", "+", "5", "*", "2");
        double result = calculator.computeExpression(tokens);
        assertEquals(13.0, result, 0.0001);

        tokens = Arrays.asList("10", "+", "2", "*", "6");
        result = calculator.computeExpression(tokens);
        assertEquals(22.0, result, 0.0001);

        tokens = Arrays.asList("100", "*", "2", "+", "12");
        result = calculator.computeExpression(tokens);
        assertEquals(212.0, result, 0.0001);

        tokens = Arrays.asList("100", "*", "(", "2", "+", "12", ")");
        result = calculator.computeExpression(tokens);
        assertEquals(1400.0, result, 0.0001);
    }
}