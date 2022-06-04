package com.nedumpurath;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static int add(String textInput) {
        var numberStrings = textInput.split(",");
        if (numberStrings.length == 1) return parseInt(numberStrings[0]);
        return parseInt(numberStrings[0])+ parseInt(numberStrings[1]);
    }
}
