package com.cronexpressionparser.operator;

import com.cronexpressionparser.exceptions.InvalidCronExpression;

import java.util.List;


public interface IOperator {

    /**
     * Every operator implements this method to process expression based on respective operator(/, *, ',', -)
     * @param expression
     * @param minValue
     * @param maxValue
     * @return
     * @throws InvalidCronExpression
     */
    List<Integer> process(String expression, int minValue, int maxValue) throws InvalidCronExpression;

    default int parseNumber(String value) throws InvalidCronExpression {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            throw new InvalidCronExpression("Invalid number " + value);
        }
    }
}
