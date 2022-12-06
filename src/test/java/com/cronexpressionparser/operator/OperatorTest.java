package com.cronexpressionparser.operator;

import com.cronexpressionparser.exceptions.InvalidCronExpression;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperatorTest {

    @Test
    public void invalidRangeShouldThrowException(){
        InvalidCronExpression exception = assertThrows(InvalidCronExpression.class, () -> {
            new RangeOperator().process("0-32", 1, 31);
        });
        assertEquals("invalid start and end values, Allowed Range : min = 1 max = 31", exception.getMessage());
    }

    @Test
    public void validRangeShouldReturnResult() throws InvalidCronExpression {
        List<Integer> expected = Arrays.asList(2, 3, 4, 5);
        List<Integer> actual = new RangeOperator().process("2-5", 1, 31);
        assertEquals(expected, actual);
    }

    @Test
    public void invalidStepShouldThrowException(){
        InvalidCronExpression exception = assertThrows(InvalidCronExpression.class, () -> {
            new StepOperator().process("3/15", 1, 31);
        });
        assertEquals("/ requires expression to start with *", exception.getMessage());
    }

    @Test
    public void validStepShouldReturnResult() throws InvalidCronExpression {
        List<Integer> expected = Arrays.asList(0, 15, 30, 45);
        List<Integer> actual = new StepOperator().process("*/15", 0, 59);
        assertEquals(expected, actual);
    }

    @Test
    public void invalidExpressionValueShouldThrowException(){
        InvalidCronExpression exception1 = assertThrows(InvalidCronExpression.class, () -> {
            new AnyValueOperator().process("blah", 1, 31);
        });
        assertEquals("Invalid number blah", exception1.getMessage());

        InvalidCronExpression exception2 = assertThrows(InvalidCronExpression.class, () -> {
            new CommaOperator().process("2,3,blah,45", 1, 31);
        });
        assertEquals("Invalid number blah", exception2.getMessage());
    }
}
