package com.nedumpurath;

import java.math.BigInteger;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static int add(String textInput) {
        if (textInput.isBlank()) return 0;
        var numberStrings = textInput.split(",");
        var firstNumberString = numberStrings[0].strip();
        var firstNumberBigInteger = new BigInteger(firstNumberString); //if firstNumberString is not an integer, this will throw NumberFormatException
        var secondNumberString = "";
        if (firstNumberBigInteger.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0 ) {
            throw new ArithmeticException();
        }
        if (firstNumberBigInteger.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0 ) {
            throw new ArithmeticException();
        }
        if (numberStrings.length == 1) {
            return Math.addExact(parseInt(firstNumberString), 0); //firstNumberString has a valid integer. But if it is not in the Java integer range, parseInt will throw NumberFormatException
        }
        secondNumberString = numberStrings[1].strip();
        var secondNumberBigInteger = new BigInteger(secondNumberString); //if secondNumberString is not an integer, this will throw NumberFormatException
        if (secondNumberBigInteger.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0 ) {
            throw new ArithmeticException();
        }
        if (secondNumberBigInteger.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0 ) {
            throw new ArithmeticException();
        }
        return Math.addExact(parseInt(firstNumberString), parseInt(secondNumberString));
    }
}
