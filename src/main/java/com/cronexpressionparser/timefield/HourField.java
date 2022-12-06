package com.cronexpressionparser.timefield;

import com.cronexpressionparser.enums.TimeFieldType;

public class HourField extends AbstractTimeField {

    public HourField(String expression) {
        super(expression, TimeFieldType.HOUR);
    }

    @Override
    public int getMinValue() {
        return 0;
    }

    @Override
    public int getMaxValue() {
        return 23;
    }
}
