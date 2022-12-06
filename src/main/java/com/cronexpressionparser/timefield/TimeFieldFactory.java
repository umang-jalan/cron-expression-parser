package com.cronexpressionparser.timefield;

import com.cronexpressionparser.enums.TimeFieldType;
import com.cronexpressionparser.exceptions.InvalidCronExpression;

public class TimeFieldFactory {
    public static AbstractTimeField getTimeField(int position, String expression) throws InvalidCronExpression {
        switch (TimeFieldType.getEnumFromPosition(position)){
            case MINUTE:
                return new MinuteField(expression);
            case HOUR:
                return new HourField(expression);
            case DAY_OF_MONTH:
                return new DayOfMonthField(expression);
            case MONTH:
                return new MonthField(expression);
            case DAY_OF_WEEK:
                return new DayOfWeekField(expression);
            default:
                throw new InvalidCronExpression("unknown time field in cron expression");
        }
    }
}
