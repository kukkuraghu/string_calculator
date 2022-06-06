
# string_calculator
Integer Adder where the input is accepted as text.

**Environment**
Programming Language: Java 17
Build Tool: Maven

**Description**
The class StringCalculator has a static method add which accepts integers separated by comma or newline (or a specified delimiter). The method returns the sum of integers. If non integers are included in the input string, it throws the NumberFormatException. If the sum exceeds the integer range supported by language, it throws ArithmeticException.

**Examples**

    Calculator.add("4,5")  // returns 9
    Calculator.add("//;\n4;5;6") //returns 15
