package com.cronexpressionparser;

import com.cronexpressionparser.exceptions.InvalidCronExpression;
import com.cronexpressionparser.timefield.AbstractTimeField;
import com.cronexpressionparser.timefield.TimeFieldFactory;

import java.util.List;

/**
 * Entry point for the application to parse cron expression
 */
public class CronExpressionParser {

    /**
     * parses cron expression and returns the parsed values or throws exception
     * @param cronExpressionArg : Cron expression to be parsed
     * @return CronExpressionResult
     * @throws InvalidCronExpression
     */
    public CronExpressionResult parseCronExpression(String cronExpressionArg) throws InvalidCronExpression {
        String[] subExpressions = cronExpressionArg.split("\\s+");
        if (subExpressions.length < 6){
            throw new InvalidCronExpression("cron expression must have 6 parts");
        }

        CronExpressionResult cronExpressionResult = new CronExpressionResult();
        for (int position=0; position < 5; position++){
            String timeSubExpression = subExpressions[position];
            AbstractTimeField abstractTimeField = TimeFieldFactory.getTimeField(position, timeSubExpression);
            List<Integer> values = abstractTimeField.process();
            updateCronExpression(cronExpressionResult, abstractTimeField, values);
        }

        // command can have more than one parts e,g, /usr/bin/run arg1 arg2 is a single command
        StringBuilder commandBuilder = new StringBuilder();
        for (int position=5; position < subExpressions.length;position++){
            commandBuilder.append(subExpressions[position]);
            if (position != subExpressions.length - 1) {
                commandBuilder.append(" ");
            }
        }

        cronExpressionResult.setCommand(commandBuilder.toString());
        return cronExpressionResult;
    }

    private void updateCronExpression(CronExpressionResult cronExpressionResult, AbstractTimeField abstractTimeField, List<Integer> values){
        switch (abstractTimeField.getType()){
            case MINUTE:
                cronExpressionResult.setMinutes(values);
                break;
            case HOUR:
                cronExpressionResult.setHours(values);
                break;
            case DAY_OF_MONTH:
                cronExpressionResult.setDaysOfMonth(values);
                break;
            case MONTH:
                cronExpressionResult.setMonths(values);
                break;
            case DAY_OF_WEEK:
                cronExpressionResult.setDaysOfWeek(values);
                break;
        }
    }
}
