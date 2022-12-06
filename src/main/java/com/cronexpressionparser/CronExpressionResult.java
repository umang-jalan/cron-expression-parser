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


    public void setMinutes(List<Integer> minutes) {
        this.minutes = minutes;
    }

    public void setHours(List<Integer> hours) {
        this.hours = hours;
    }

    public void setDaysOfMonth(List<Integer> daysOfMonth) {
        this.daysOfMonth = daysOfMonth;
    }

    public void setMonths(List<Integer> months) {
        this.months = months;
    }

    public void setDaysOfWeek(List<Integer> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String toString() {
        return format("%-14s%s\n", "minute", listToString(minutes)) +
                format("%-14s%s\n", "hour", listToString(hours)) +
                format("%-14s%s\n", "day of month", listToString(daysOfMonth)) +
                format("%-14s%s\n", "month", listToString(months)) +
                format("%-14s%s\n", "day of week", listToString(daysOfWeek)) +
                format("%-14s%s\n", "command", command);
    }
}
