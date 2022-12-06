package com.cronexpressionparser.enums;

public enum OperatorType {
    ANY("*"), STEP("/"), RANGE("-"), COMMA(",");

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
