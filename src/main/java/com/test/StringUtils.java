package com.test;

public class StringUtils {

    public static String removeDuplicateLetters(String input) {
        StringBuilder inputWithoutRepeatedLetters = new StringBuilder();

        for (char letter : input.toCharArray()) {
            if (inputWithoutRepeatedLetters.indexOf(String.valueOf(letter)) == -1) {
                inputWithoutRepeatedLetters.append(letter);
            }
        }

        return inputWithoutRepeatedLetters.toString();
    }

    public static String removeNonAlphaChars(String input) {
        return input.replaceAll("[^a-zA-Z]", "");
    }

    public static boolean isStringEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }    

    public static char[] sanitizeLettersGroup(String lettersGroup) {
        if (isStringEmpty(lettersGroup)) {
            return null;
        }

        String alphaChars = removeNonAlphaChars(lettersGroup);
        String distinctAlphaChars = removeDuplicateLetters(alphaChars);

        return distinctAlphaChars.isEmpty() ? null : distinctAlphaChars.toCharArray();
    }
}