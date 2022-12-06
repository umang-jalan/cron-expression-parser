package com.cronexpressionparser;

import com.cronexpressionparser.exceptions.InvalidCronExpression;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("[ERROR] cron expression cant be empty");
        }

        CronExpressionParser cronExpressionParser = new CronExpressionParser();
        CronExpressionResult cronExpressionResult = null;
        try {
            cronExpressionResult = cronExpressionParser.parseCronExpression(args[0]);
            System.out.println(cronExpressionResult.toString());
        } catch (InvalidCronExpression exception) {
            System.out.println("[ERROR] " + exception.getMessage());
        }
    }
}
