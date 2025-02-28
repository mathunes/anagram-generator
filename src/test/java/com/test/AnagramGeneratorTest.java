package com.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class AnagramGeneratorTest {

    @Test
    public void testAddAnagramToList() {
        ArrayList<String> anagrams = new ArrayList<>();
        char[] anagram = {'a', 'b', 'c'};

        AnagramGenerator.addAnagramToList(anagrams, anagram);
        assertEquals(1, anagrams.size());
        assertEquals("abc", anagrams.get(0));

        AnagramGenerator.addAnagramToList(anagrams, anagram);
        assertEquals(2, anagrams.size());
        assertEquals("abc", anagrams.get(1));

        anagram = new char[0];
        AnagramGenerator.addAnagramToList(anagrams, anagram);
        assertEquals(2, anagrams.size());
    }

    @Test
    public void testGenerateAnagrams() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        AnagramGenerator.generateAnagrams("abc");
        String expectedOutput1 = "abc, bac, cab, acb, bca, cba";
        assertEquals(expectedOutput1, outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();

        AnagramGenerator.generateAnagrams("a");
        String expectedOutput2 = "a";
        assertEquals(expectedOutput2, outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();

        AnagramGenerator.generateAnagrams("aabb");
        String expectedOutput3 = "ab, ba";
        assertEquals(expectedOutput3, outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();

        AnagramGenerator.generateAnagrams("");
        String expectedOutput4 = "Invalid input for anagram generation.";
        assertEquals(expectedOutput4, outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();

        AnagramGenerator.generateAnagrams(null);
        String expectedOutput5 = "Invalid input for anagram generation.";
        assertEquals(expectedOutput5, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testSwap() {
        char[] arr = {'a', 'b', 'c'};
        AnagramGenerator.swap(arr, 0, 2);
        assertArrayEquals(new char[] {'c', 'b', 'a'}, arr);

        arr = new char[] {'x', 'y', 'z'};
        AnagramGenerator.swap(arr, 1, 1);
        assertArrayEquals(new char[] {'x', 'y', 'z'}, arr);

        arr = new char[] {'a', 'a', 'a'};
        AnagramGenerator.swap(arr, 0, 2);
        assertArrayEquals(new char[] {'a', 'a', 'a'}, arr);
    }

    @Test
    public void testPrintAnagrams() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        ArrayList<String> anagrams = new ArrayList<>();
        anagrams.add("abc");
        AnagramGenerator.printAnagrams(anagrams);
        assertEquals("abc", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();

        anagrams.add("acb");
        anagrams.add("bac");
        AnagramGenerator.printAnagrams(anagrams);
        assertEquals("abc, acb, bac", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();

        anagrams.clear();
        AnagramGenerator.printAnagrams(anagrams);
        assertEquals("", outputStreamCaptor.toString().trim());
    }
}
