package com.cronexpressionparser;

import com.cronexpressionparser.exceptions.InvalidCronExpression;

public class CronExpressionParser {

    public CronExpressionResult parseCronExpression(String cronExpressionArg) throws InvalidCronExpression {
        String[] subExpressions = cronExpressionArg.split("\\s+");
        if (subExpressions.length < 6){
            throw new InvalidCronExpression("cron expression must have 6 parts");
        }

        return null;
    }
}
