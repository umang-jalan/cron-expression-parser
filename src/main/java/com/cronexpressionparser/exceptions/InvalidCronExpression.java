package com.cronexpressionparser.exceptions;

public class InvalidCronExpression extends Exception{
    public InvalidCronExpression(String message) {
        super(message);
    }
}
