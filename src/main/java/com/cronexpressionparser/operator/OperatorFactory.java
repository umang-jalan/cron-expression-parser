package com.cronexpressionparser.operator;

import com.cronexpressionparser.enums.OperatorType;

import java.util.LinkedHashMap;
import java.util.Map;

public class OperatorFactory {
    private static final Map<OperatorType, IOperator> operatorMap;
    static {
        operatorMap = new LinkedHashMap<>();
        // order of precedence
        operatorMap.put(OperatorType.COMMA, new CommaOperator());
        operatorMap.put(OperatorType.STEP, new StepOperator());
        operatorMap.put(OperatorType.RANGE, new RangeOperator());
        operatorMap.put(OperatorType.ANY, new AnyValueOperator());
    }

    public static IOperator getOperator(String expression){
        for (OperatorType operatorType : operatorMap.keySet()){
            if (expression.contains(operatorType.getSymbol())) return operatorMap.get(operatorType);
        }
        return operatorMap.get(OperatorType.ANY);
    }
}
