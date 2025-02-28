package com.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void testRemoveDuplicateLetters() {
        String result = StringUtils.removeDuplicateLetters("aabbcc");
        assertEquals("abc", result);

        result = StringUtils.removeDuplicateLetters("abcdef");
        assertEquals("abcdef", result);

        result = StringUtils.removeDuplicateLetters("");
        assertEquals("", result);
    }

    @Test
    public void testRemoveNonAlphaChars() {
        String result = StringUtils.removeNonAlphaChars("abc123!@#");
        assertEquals("abc", result);

        result = StringUtils.removeNonAlphaChars("abcABC");
        assertEquals("abcABC", result);

        result = StringUtils.removeNonAlphaChars("12345!@#");
        assertEquals("", result);
    }

    @Test
    public void testIsStringEmpty() {
        boolean result = StringUtils.isStringEmpty("Hello");
        assertFalse(result);

        result = StringUtils.isStringEmpty("");
        assertTrue(result);

        result = StringUtils.isStringEmpty(null);
        assertTrue(result);

        result = StringUtils.isStringEmpty("   ");
        assertTrue(result);
    }

    @Test
    public void testSanitizeLettersGroup() {
        char[] result = StringUtils.sanitizeLettersGroup("aabbc123!@#");
        assertNotNull(result);
        assertArrayEquals(new char[] {'a', 'b', 'c'}, result);

        result = StringUtils.sanitizeLettersGroup("");
        assertNull(result);

        result = StringUtils.sanitizeLettersGroup(null);
        assertNull(result);

        result = StringUtils.sanitizeLettersGroup("12345!@#");
        assertNull(result);

        result = StringUtils.sanitizeLettersGroup("a");
        assertNotNull(result);
        assertArrayEquals(new char[] {'a'}, result);
    }
}
