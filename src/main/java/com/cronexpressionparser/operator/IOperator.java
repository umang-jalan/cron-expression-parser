package com.cronexpressionparser.operator;

import com.cronexpressionparser.exceptions.InvalidCronExpression;

import java.util.List;


public interface IOperator {

    List<Integer> process(String expression, int minValue, int maxValue) throws InvalidCronExpression;

    default int parseNumber(String value) throws InvalidCronExpression {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            throw new InvalidCronExpression("Invalid number " + value);
        }
    }
}
