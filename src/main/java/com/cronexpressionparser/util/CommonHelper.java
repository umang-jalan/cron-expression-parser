package com.cronexpressionparser.util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommonHelper {

    public static String listToString(List<Integer> values){
        return values.stream().map(Objects::toString).collect(Collectors.joining(" "));
    }
}
