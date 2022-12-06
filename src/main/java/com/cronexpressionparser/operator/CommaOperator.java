package com.cronexpressionparser.operator;

import com.cronexpressionparser.exceptions.InvalidCronExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CommaOperator implements IOperator{

    /**
     * splits at ',' and process each subexpression individually
     * return the final set of values
     * @param expression
     * @param minValue
     * @param maxValue
     * @return
     * @throws InvalidCronExpression
     */
    @Override
    public List<Integer> process(String expression, int minValue, int maxValue) throws InvalidCronExpression {
        Set<Integer> result = new TreeSet<>();
        String[] subExpressions = expression.split(",");
        /*
           comma can have multiple subExpressions, e.g.
           7,4-10,12-15
           hence parsing each subexpression individually
        */
        for(String subExpression: subExpressions){
            result.addAll(OperatorFactory.getOperator(subExpression).process(subExpression, minValue, maxValue));
        }
        return new ArrayList<>(result);
    }
}
