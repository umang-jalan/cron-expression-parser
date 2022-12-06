package com.cronexpressionparser.operator;

import com.cronexpressionparser.exceptions.InvalidCronExpression;

import java.util.LinkedList;
import java.util.List;

public class AnyValueOperator implements IOperator{

    @Override
    public List<Integer> process(String expression, int minValue, int maxValue) throws InvalidCronExpression {
        List<Integer> result = new LinkedList<>();
        if (expression.equals("*")){
            for (int j = minValue; j<= maxValue; j++){
                result.add(j);
            }
        }else {
            int fixedValue = parseNumber(expression);
            if (fixedValue < minValue || fixedValue > maxValue){
                throw new InvalidCronExpression("value not in range :" + "min = " + minValue + " max = " + maxValue);
            }
            result.add(fixedValue);
        }
        return result;
    }
}
