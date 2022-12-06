package com.cronexpressionparser.timefield;

import com.cronexpressionparser.enums.TimeFieldType;
import com.cronexpressionparser.exceptions.InvalidCronExpression;
import com.cronexpressionparser.operator.IOperator;
import com.cronexpressionparser.operator.OperatorFactory;

import java.util.List;


public abstract class AbstractTimeField {
    private String expression;
    private final TimeFieldType type;

    public AbstractTimeField(String expression, TimeFieldType type) {
        this.expression = expression.toLowerCase();
        this.type = type;
    }

    public List<Integer> process() throws InvalidCronExpression {
        IOperator iOperator = OperatorFactory.getOperator(expression);
        try {
            return iOperator.process(expression, this.getMinValue(), this.getMaxValue());
        } catch (InvalidCronExpression invalidCronExpression) {
            throw new InvalidCronExpression(String.format("[%s] %s", type.name(), invalidCronExpression.getMessage()));
        }
    }

    abstract int getMinValue();

    abstract int getMaxValue();

    void setExpression(String expression) {
        this.expression = expression;
    }

    String getExpression() {
        return expression;
    }

    public TimeFieldType getType() {
        return type;
    }
}
