package com.nedumpurath;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static int add(String textInput) {
        var numbers = textInput.split(",");
        return parseInt(numbers[0])+ parseInt(numbers[1]);
    }
}
