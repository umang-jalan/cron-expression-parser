package com.cronexpressionparser.timefield;

import com.cronexpressionparser.enums.TimeFieldType;

public class MinuteField extends AbstractTimeField {
    public MinuteField(String expression) {
        super(expression, TimeFieldType.MINUTE);
    }

    @Override
    public int getMinValue() {
        return 0;
    }

    @Override
    public int getMaxValue() {
        return 59;
    }
}
