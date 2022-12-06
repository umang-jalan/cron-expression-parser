package com.cronexpressionparser.timefield;

import com.cronexpressionparser.enums.TimeFieldType;

public class DayOfWeekField extends AbstractTimeField {

    public DayOfWeekField(String expression) {
        super(expression, TimeFieldType.DAY_OF_WEEK);
    }

    @Override
    public int getMinValue() {
        return 0;
    }

    @Override
    public int getMaxValue() {
        return 6;
    }
}
