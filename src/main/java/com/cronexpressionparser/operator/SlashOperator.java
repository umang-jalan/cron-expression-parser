package com.cronexpressionparser.operator;


import com.cronexpressionparser.exceptions.InvalidCronExpression;

import java.util.LinkedList;
import java.util.List;

public class SlashOperator implements IOperator{

    /**
     * Step Operator
     * validates
     *  1. if expression is valid
     *  2. valid interval
     * processes and returns the calculated values
     *
     * @param expression
     * @param minValue
     * @param maxValue
     * @return
     * @throws InvalidCronExpression
     */
    @Override
    public List<Integer> process(String expression, int minValue, int maxValue) throws InvalidCronExpression {
        if (!expression.startsWith("*")){
            throw new InvalidCronExpression("/ requires expression to start with *");
        }

        String[] intervals = expression.split("/");
        if (intervals.length != 2){
            throw new InvalidCronExpression("too many intervals in expression");
        }
        int step = parseNumber(intervals[1]);
        List<Integer> result = new LinkedList<>();
        for (int i = minValue; i<= maxValue; i+=step){
            result.add(i);
        }
        return result;
    }
}
