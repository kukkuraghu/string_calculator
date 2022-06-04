import com.nedumpurath.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    void addUpToTwoNumber() {
        assertEquals(5, StringCalculator.add("2,3"), "when the input string has two integers separated comma, StringCalculator.add should return the sum of the two numbers");
    }
}
