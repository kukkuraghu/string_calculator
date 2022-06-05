import com.nedumpurath.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    void addUpToTwoNumber() {
        assertEquals(5, StringCalculator.add("2,3"), "when the input string has two integers separated by comma, StringCalculator.add should return the sum of the two numbers");
    }

    @Test
    void addUpToTwoNumberInvokedWithSingleNumber() {
        assertEquals(6, StringCalculator.add("6"), "when the input string has only one integer StringCalculator.add should return the single integer in the input string");
    }

    @Test
    void addUpToTwoNumberInvokedWithEmptyString() {
        assertEquals(0, StringCalculator.add(""), "when the input string is empty, StringCalculator.add should return 0");
    }

    @Test
    void addUpToTwoNumberInvokedWithBlankString() {
        assertEquals(0, StringCalculator.add("   "), "when the input string is blank, StringCalculator.add should return 0");
        assertEquals(0, StringCalculator.add("  \t "), "when the input string is blank, StringCalculator.add should return 0");
        assertEquals(0, StringCalculator.add(" \t \n \r  "), "when the input string is blank, StringCalculator.add should return 0");
    }

    @Test
    void addUpToTwoNumberInvokedWithIntegersSurroundedWithWhiteSpaces() {
        assertEquals(7, StringCalculator.add(" 3  , 4   "), "when the input string has two integers with whitespaces around them and separated by comma, StringCalculator.add should return the sum of the two integers - it should ignore whitespaces");
    }

    @Test
    void addUpToTwoNumberInvokedWithNonIntegers() {
        assertThrows(NumberFormatException.class, () -> StringCalculator.add(" 3.4, 4.5"), "when the input string has non integer numbers, StringCalculator.add should throw NumberFormatException");
    }

    @Test
    void addUpToTwoNumberInvokedWithNonNumbers() {
        assertThrows(NumberFormatException.class, () -> StringCalculator.add(" 3, xyz"), "when the input string has non numbers, StringCalculator.add should throw NumberFormatException");
        assertThrows(NumberFormatException.class, () -> StringCalculator.add(" abc, 5"), "when the input string has non numbers, StringCalculator.add should throw NumberFormatException");
        assertThrows(NumberFormatException.class, () -> StringCalculator.add(" a, a"), "when the input string has non numbers, StringCalculator.add should throw NumberFormatException");
    }

    @Test
    void addUpToTwoNumberInvokedWithIntegersWhoseSumExceedsMaxInt() {
        assertThrows(ArithmeticException.class, () -> StringCalculator.add("2, 2147483647"), "if the input string has integers whose sum  is not in the integers range supported, the Add method should throw ArithmeticException");
        assertThrows(ArithmeticException.class, () -> StringCalculator.add("2147483647, 2"), "if the input string has integers whose sum  is not in the integers range supported, the Add method should throw ArithmeticException");
        assertThrows(ArithmeticException.class, () -> StringCalculator.add("2147483648"), "if the input string has integers whose sum  is not in the integers range supported or has integers who are outside the integer range, the Add method should throw ArithmeticException");
        assertThrows(ArithmeticException.class, () -> StringCalculator.add("2, 2147483648"), "if the input string has integers whose sum  is not in the integers range supported or has integers who are outside the integer range, the Add method should throw ArithmeticException");
    }

    @Test
    void addUpToTwoNumberInvokedWithNegativeIntegers() {
        assertEquals(-5, StringCalculator.add("-2,-3"), "when the input string has negative integers separated by comma, StringCalculator.add should do the normal integer addition");
        assertEquals(0, StringCalculator.add("+3, -3"), "when the input string has negative integers separated by comma, StringCalculator.add should do the normal integer addition");
    }

    @Test
    void addUpToTwoNumberInvokedWithIntegersWhoseSumLessThanMinInt() {
        assertThrows(ArithmeticException.class, () -> StringCalculator.add("-2, -2147483648"), "if the input string has integers whose sum(or any input integer) is not in the integers range supported, the Add method should throw ArithmeticException");
        assertThrows(ArithmeticException.class, () -> StringCalculator.add("-2, -2147483649"), "if the input string has integers whose sum(or any input integer) is not in the integers range supported, the Add method should throw ArithmeticException");
        assertThrows(ArithmeticException.class, () -> StringCalculator.add("-2147483649, -3"), "if the input string has integers whose sum(or any input integer) is not in the integers range supported, the Add method should throw ArithmeticException");
        assertThrows(ArithmeticException.class, () -> StringCalculator.add("-2147483649"), "if the input string has integers whose sum(or any input integer) is not in the integers range supported or has integers who are outside the integer range, the Add method should throw ArithmeticException");
    }

    @Test
    void addToSumMoreThanTwoNumbers() {
        assertEquals(10, StringCalculator.add("2,3,5"), "when the input string has more than two integers separated by comma, StringCalculator.add should return the sum of all the integers");
        assertEquals(170, StringCalculator.add("2,3,5, 100,  50 , \t 10"), "when the input string has more than two integers separated by comma, StringCalculator.add should return the sum of all the integers");
        assertThrows(ArithmeticException.class, () -> StringCalculator.add("2, 3, 4, 2147483647, 5"), "if the input string has integers whose sum  is not in the integers range supported, the Add method should throw ArithmeticException");
        assertThrows(ArithmeticException.class, () -> StringCalculator.add("2, 3, 5, 2147483648"), "if the input string has integers whose sum  is not in the integers range supported or has integers who are outside the integer range, the Add method should throw ArithmeticException");
    }

    @Test
    void addToSumNumbersWithCommaAndNewLineAsSeparators() {
        assertEquals(10, StringCalculator.add("2,3\n5"), "when the input string has only integers separated by comma or newline, StringCalculator.add should return the sum of all the integers");
        assertEquals(8, StringCalculator.add("2\n 6"), "when the input string has two integers separated by comma or newline, StringCalculator.add should return the sum of both the integers");
        assertEquals(170, StringCalculator.add("2,3,5, 100 \n  50 , \t 10"), "when the input string has more than two integers separated by comma or newline, StringCalculator.add should return the sum of all the integers");
    }

    @Test
    void addToSumNumbersSomeEdgeCases() {
        assertThrows(NumberFormatException.class, () -> StringCalculator.add(","), "when the input string has only a separator(non white space separator) and no integers, StringCalculator.add should throw NumberFormatException");
        assertEquals(0, StringCalculator.add("\n"), "when the input string has only white spaces(even when a white space is considered as  a separator) and no integers, StringCalculator.add should return 0");
        assertThrows(NumberFormatException.class, () -> StringCalculator.add(" , "), "when the input string has only a separator and no integers, StringCalculator.add should throw NumberFormatException");
        assertThrows(NumberFormatException.class, () -> StringCalculator.add(" , 2"), "when the input string starts with a separator(with or without whitespaces around it), StringCalculator.add should throw NumberFormatException");
        assertThrows(NumberFormatException.class, () -> StringCalculator.add(",2"), "when the input string starts with a non white space separator(with or without whitespaces around it), StringCalculator.add should throw NumberFormatException");
        assertThrows(NumberFormatException.class, () -> StringCalculator.add("2,"), "when the input string ends with a non white space separator(with or without whitespaces around it), StringCalculator.add should throw NumberFormatException");
        assertThrows(NumberFormatException.class, () -> StringCalculator.add("3\n"), "when the input string ends with a separator(with or without whitespaces around it), StringCalculator.add should throw NumberFormatException");
        assertThrows(NumberFormatException.class, () -> StringCalculator.add("\n3"), "when the input string starts with a separator(with or without whitespaces around it), StringCalculator.add should throw NumberFormatException");
        assertThrows(NumberFormatException.class, () -> StringCalculator.add("3,\n"), "when the input string has consecutive separators(without an integer between them), StringCalculator.add should throw NumberFormatException");
        assertThrows(NumberFormatException.class, () -> StringCalculator.add("\n,5"), "when the input string has consecutive separators(without an integer between them), StringCalculator.add should throw NumberFormatException");
    }

    @Test
    void addToSumNumbersWithSeparatorDefinition() {
        assertEquals(10, StringCalculator.add("//;\n2;3;5"), "when the input string has separator definition, StringCalculator.add should consider the separator in the definition");
    }
}
