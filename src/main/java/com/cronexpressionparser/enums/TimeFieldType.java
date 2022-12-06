package com.cronexpressionparser.enums;

import java.util.HashMap;
import java.util.Map;

public enum TimeFieldType {
    MINUTE(0), HOUR(1), DAY_OF_MONTH(2), MONTH(3), DAY_OF_WEEK(4), UNKNOWN(-1);

    private final int position;

    TimeFieldType(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
    private static final Map<Integer, TimeFieldType> positionEnumMap = new HashMap<>();

    static {
        for (TimeFieldType timeField : TimeFieldType.values()){
            positionEnumMap.put(timeField.getPosition(), timeField);
        }
    }

    public static TimeFieldType getEnumFromPosition(int position){
        if (position<0 || position > 4 || !positionEnumMap.containsKey(position)){
            return TimeFieldType.UNKNOWN;
        }
        return positionEnumMap.get(position);
    }
}
