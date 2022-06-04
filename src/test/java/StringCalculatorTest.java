import com.nedumpurath.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    void addUpToTwoNumber() {
        assertEquals(5, StringCalculator.add("2,3"), "when the input string has two integers separated comma, StringCalculator.add should return the sum of the two numbers");
    }

    @Test
    void addUpToTwoNumberInvokedWithSingleNumber() {
        assertEquals(6, StringCalculator.add("6"), "when the input string has only one integer StringCalculator.add should return the single integer in the input string");
    }

    @Test
    void addUpToTwoNumberInvokedWithEmptyString() {
        assertEquals(0, StringCalculator.add(""), "when the input string is empty StringCalculator.add should return 0");
    }
}
