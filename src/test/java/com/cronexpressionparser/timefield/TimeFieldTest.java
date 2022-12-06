package com.cronexpressionparser.timefield;

import com.cronexpressionparser.exceptions.InvalidCronExpression;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeFieldTest {

    @Test
    public void invalidMinuteExpressionShouldThrowException(){
        InvalidCronExpression exception = assertThrows(InvalidCronExpression.class, () -> {
            new MinuteField("60").process();
        });
        assertEquals("[MINUTE] Value not in range. Allowed Range : min = 0 max = 59", exception.getMessage());
    }

    @Test
    public void validMinuteExpressionShouldReturnResult() throws InvalidCronExpression {
        List<Integer> actual = new MinuteField("*/15").process();
        List<Integer> expected = Arrays.asList(0,15,30,45);
        assertEquals(expected, actual);
    }

    @Test
    public void invalidDayOfMonthExpressionShouldThrowException(){
        InvalidCronExpression exception = assertThrows(InvalidCronExpression.class, () -> {
            new DayOfMonthField("1-32").process();
        });
        assertEquals("[DAY_OF_MONTH] invalid start and end values, Allowed Range : min = 1 max = 31", exception.getMessage());
    }

    @Test
    public void validDayOfMonthExpressionShouldReturnResult() throws InvalidCronExpression {
        List<Integer> actual = new DayOfMonthField("*/10").process();
        List<Integer> expected = Arrays.asList(1,11,21,31);
        assertEquals(expected, actual);
    }
}
