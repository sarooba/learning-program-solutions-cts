package test;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

import main.Calculator;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        int result = c.add(2, 3);
        assertEquals(5, result);
    }
}
