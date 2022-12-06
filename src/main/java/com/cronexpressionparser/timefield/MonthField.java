package com.cronexpressionparser.timefield;


import com.cronexpressionparser.enums.TimeFieldType;

public class MonthField extends AbstractTimeField {
    public MonthField(String expression) {
        super(expression, TimeFieldType.MONTH);
    }

    @Override
    public int getMinValue() {
        return 1;
    }

    @Override
    public int getMaxValue() {
        return 12;
    }
}
