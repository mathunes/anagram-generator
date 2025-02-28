package com.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {

    @Test
    public void testMain() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        String[] args1 = {"abc"};
        App.main(args1);
        String expectedOutput1 = "abc, bac, cab, acb, bca, cba";
        assertTrue(outputStreamCaptor.toString().contains(expectedOutput1));

        outputStreamCaptor.reset();

        String[] args2 = {};
        App.main(args2);
        String expectedOutput2 = "Invalid input for anagram generation.";
        assertEquals(expectedOutput2, outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
    }
}
