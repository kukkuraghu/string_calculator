package com.nedumpurath;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static int add(String textInput) {
        if (textInput.isBlank()) return 0;
        var numberStrings = textInput.split(",");
        if (numberStrings.length == 1) return parseInt(numberStrings[0].strip());
        return parseInt(numberStrings[0].strip())+ parseInt(numberStrings[1].strip());
    }
}
