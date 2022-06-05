package com.nedumpurath;

import java.math.BigInteger;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static int add(String textInput) {
        if (textInput.isBlank()) return 0;

        var componentList = List.of(textInput.split("[,\n]"));
        return componentList.stream().map(component -> {
            //strip the surrounding whitespaces from each component
            var strippedComponent = component.strip();

            //if the strippedComponent is not an integer, the following will throw a NumberFormatException
            var componentBigInteger = new BigInteger(strippedComponent);

            //throw ArithmeticException, if the number is not in the integer range supported
            if (moreThanMaxInt(componentBigInteger) || lessThanMinInt(componentBigInteger)) {
                throw new ArithmeticException();
            }

            return parseInt(strippedComponent);

        }).reduce(0, Math::addExact); //addExact will throw ArithmeticException, if the sum is more than MAXVALUE or less than MINVALUE*/
    }

    private  static Boolean moreThanMaxInt(BigInteger number) {
        return number.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0;
    }

    private static Boolean lessThanMinInt(BigInteger number) {
        return number.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0;
    }
}
