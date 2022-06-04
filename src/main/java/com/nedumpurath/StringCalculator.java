package com.nedumpurath;

import java.math.BigInteger;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static int add(String textInput) {
        if (textInput.isBlank()) return 0;

        var numberStrings = textInput.split(",");
        var firstNumberStringStripped = numberStrings[0].strip();
        var firstNumberBigInteger = new BigInteger(firstNumberStringStripped); //if firstNumberString is not an integer, this will throw NumberFormatException

        //throw ArithmeticException, if the number is not in the integer range supported
        if (moreThanMaxInt(firstNumberBigInteger) || lessThanMinInt(firstNumberBigInteger)) {
            throw new ArithmeticException();
        }
        if (numberStrings.length == 1) {
            return Math.addExact(parseInt(firstNumberStringStripped), 0); //firstNumberString has a valid integer. But if it is not in the Java integer range, parseInt will throw NumberFormatException
        }

        var secondNumberStringStripped = numberStrings[1].strip();
        var secondNumberBigInteger = new BigInteger(secondNumberStringStripped); //if secondNumberString is not an integer, this will throw NumberFormatException
        //throw ArithmeticException, if the number is not in the integer range supported
        if (moreThanMaxInt(secondNumberBigInteger) || lessThanMinInt(secondNumberBigInteger)) {
            throw new ArithmeticException();
        }

        return Math.addExact(parseInt(firstNumberStringStripped), parseInt(secondNumberStringStripped)); //addExact will throw ArithmeticException, if the sum is more than MAXVALUE or less than MINVALUE
    }

    private  static Boolean moreThanMaxInt(BigInteger number) {
        return number.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0;
    }

    private static Boolean lessThanMinInt(BigInteger number) {
        return number.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0;
    }
}
