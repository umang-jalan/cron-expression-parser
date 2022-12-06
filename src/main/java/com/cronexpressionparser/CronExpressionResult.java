package com.cronexpressionparser;

import java.util.List;

import static com.cronexpressionparser.util.CommonHelper.listToString;
import static java.lang.String.format;

public class CronExpressionResult {
    private List<Integer> minutes;
    private List<Integer> hours;
    private List<Integer> daysOfMonth;
    private List<Integer> months;
    private List<Integer> daysOfWeek;
    private String command;


    public String toString() {
        return format("%-14s%s\n", "minute", listToString(minutes)) +
                format("%-14s%s\n", "hour", listToString(hours)) +
                format("%-14s%s\n", "day of month", listToString(daysOfMonth)) +
                format("%-14s%s\n", "month", listToString(months)) +
                format("%-14s%s\n", "day of week", listToString(daysOfWeek)) +
                format("%-14s%s\n", "command", command);
    }
}
