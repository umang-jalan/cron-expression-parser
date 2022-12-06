package com.cronexpressionparser;

import com.cronexpressionparser.exceptions.InvalidCronExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CronExpressionParserTest {
    private CronExpressionParser cronExpressionParser;

    @BeforeEach
    public void setup(){
        cronExpressionParser = new CronExpressionParser();
    }

    @Test
    public void testIncompleteCronExpression(){
        assertThrows(InvalidCronExpression.class, () -> {
            cronExpressionParser.parseCronExpression("* * * *");
        }, "cron expression must have 6 parts");
    }

    @Test
    public void testInvalidCronExpression(){
        Exception exception1 = assertThrows(InvalidCronExpression.class, () -> {
            cronExpressionParser.parseCronExpression("*/15 blah blah * * *");
        });
        assertEquals("[HOUR] Invalid number blah", exception1.getMessage());

        Exception exception2 = assertThrows(InvalidCronExpression.class, () -> {
            cronExpressionParser.parseCronExpression("*/15 0-23 32 * * *");
        });
        assertEquals("[DAY_OF_MONTH] value not in range :min = 1 max = 31", exception2.getMessage());

        Exception exception3 = assertThrows(InvalidCronExpression.class, () -> {
            cronExpressionParser.parseCronExpression("minute * * * * *");
        });
        assertEquals("[MINUTE] Invalid number minute", exception3.getMessage());
    }

    @Test
    public void testBasicValidCronExpression() throws InvalidCronExpression {
        String expected = format("%-14s%s\n", "minute", "0 15 30 45") +
                format("%-14s%s\n", "hour", "0") +
                format("%-14s%s\n", "day of month", "1 15") +
                format("%-14s%s\n", "month", "1 2 3 4 5 6 7 8 9 10 11 12") +
                format("%-14s%s\n", "day of week", "1 2 3 4 5") +
                format("%-14s%s\n", "command", "/usr/bin/run arg1 arg2");
        String actual = cronExpressionParser.parseCronExpression("*/15 0 1,15 * 1-5 /usr/bin/run arg1 arg2").toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testValidCronWithMultipleSubExpression() throws InvalidCronExpression {
        String expected = format("%-14s%s\n", "minute", "0 15 30 45") +
                format("%-14s%s\n", "hour", "1 2 3 4") +
                format("%-14s%s\n", "day of month", "1 5 6 7 9 11 13 16 17 21 25 26 29 31") +
                format("%-14s%s\n", "month", "1 2 3 4 5") +
                format("%-14s%s\n", "day of week", "0 1 2 3 4 5 6") +
                format("%-14s%s\n", "command", "/usr/bin/run");
        String actual = cronExpressionParser.parseCronExpression("*/15 1-4 */4,*/5,7 1-5 * /usr/bin/run").toString();
        assertEquals(expected, actual);
    }
}
