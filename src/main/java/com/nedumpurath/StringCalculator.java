package com.nedumpurath;

import java.math.BigInteger;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static int add(String textInput) {
        var delimiter = "[,|\n]";
        var numbersString = textInput;
        if (startsWithDelimiterDefinition(textInput)) {
            var patternAndNumbersString = getPatternAndNumbersString(textInput);
            delimiter = patternAndNumbersString[0];
            numbersString = patternAndNumbersString[1];
        }

        if (numbersString.isBlank()) return 0;

        var componentList = List.of(numbersString.split(delimiter, -1));//don't eliminate trailing empty strings - set the limit -1

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

    private static Boolean startsWithDelimiterDefinition(String inputString) {
        return inputString.matches("//.\n(?s).*");
    }

    private static String[] getPatternAndNumbersString(String inputString) {
        String[] patternAndInputString = new String[2];
        var pattern = Pattern.compile("//(.)\n((?s).*)");
        var matchedGroups = pattern.matcher(inputString);
        if (matchedGroups.find()) {
            patternAndInputString[0] = matchedGroups.group(1);//delimiter
            patternAndInputString[1] = matchedGroups.group(2);//numbersString
            return patternAndInputString;
        }
        return null;
    }
}
