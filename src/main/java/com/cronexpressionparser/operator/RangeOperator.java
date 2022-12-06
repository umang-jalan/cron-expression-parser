package com.cronexpressionparser.operator;


import com.cronexpressionparser.exceptions.InvalidCronExpression;

import java.util.LinkedList;
import java.util.List;

public class RangeOperator implements IOperator{

    @Override
    public List<Integer> process(String expression, int minValue, int maxValue) throws InvalidCronExpression {
        String[] range = expression.split("-");
        if (range.length != 2){
            throw new InvalidCronExpression("range(-) must contain only two range");
        }

        int start = parseNumber(range[0]);
        int end = parseNumber(range[1]);

        if (start > end || start < minValue || start > maxValue || end > maxValue){
            throw new InvalidCronExpression("invalid start and end range allowed : " + "min = " + minValue + " max = " + maxValue);
        }

        List<Integer> result = new LinkedList<>();
        for (int i=start;i<=end;i++){
            result.add(i);
        }
        return result;
    }
}
