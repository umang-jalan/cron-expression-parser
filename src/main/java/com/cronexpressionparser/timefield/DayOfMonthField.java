package com.cronexpressionparser.timefield;

import com.cronexpressionparser.enums.TimeFieldType;

public class DayOfMonthField extends AbstractTimeField {

    public DayOfMonthField(String expression) {
        super(expression, TimeFieldType.DAY_OF_MONTH);
    }

    @Override
    public int getMinValue() {
        return 1;
    }

    @Override
    public int getMaxValue() {
        return 31;
    }
}
