package com.example;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LoggingExampleTest {

    @Test
    public void testMainMethodRunsWithoutError() {
        LoggingExample.main(null); // run main
        assertTrue(true); // dummy test just to confirm it runs
    }
}
