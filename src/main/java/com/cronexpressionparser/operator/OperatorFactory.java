package com.cronexpressionparser.operator;

import com.cronexpressionparser.enums.OperatorType;

import java.util.LinkedHashMap;
import java.util.Map;

public class OperatorFactory {
    private static final Map<OperatorType, IOperator> operatorMap;
    static {
        operatorMap = new LinkedHashMap<>();
        // in order of precedence
        operatorMap.put(OperatorType.COMMA, new CommaOperator());
        operatorMap.put(OperatorType.SLASH, new SlashOperator());
        operatorMap.put(OperatorType.HYPHEN, new HyphenOperator());
        operatorMap.put(OperatorType.ANY, new AnyValueOperator());
    }

    public static IOperator getOperator(String expression){
        for (OperatorType operatorType : operatorMap.keySet()){
            if (expression.contains(operatorType.getSymbol())) return operatorMap.get(operatorType);
        }
        return operatorMap.get(OperatorType.ANY);
    }
}
