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
    }
}
