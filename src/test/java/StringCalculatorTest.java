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
}
