package com.test;

import java.util.ArrayList;
import java.util.Arrays;

public class AnagramGenerator {
    public static void addAnagramToList(ArrayList<String> anagrams, char[] anagram) {
        if (anagram == null || anagram.length == 0) {
            return;
        }
        anagrams.add(new String(anagram));
    }

    public static void generateAnagrams(String lettersGroup) {
        char[] sanitizedLettersGroup = StringUtils.sanitizeLettersGroup(lettersGroup);

        if (sanitizedLettersGroup == null || sanitizedLettersGroup.length == 0) {
            System.out.println("Invalid input for anagram generation.");
            return;
        }

        int countLetters = sanitizedLettersGroup.length;
        int[] swapCount = new int[countLetters];
        Arrays.fill(swapCount, 0);

        ArrayList<String> anagrams = new ArrayList<>();
        addAnagramToList(anagrams, sanitizedLettersGroup);

        int i = 1;
        while (i < countLetters) {
            if (swapCount[i] < i) {
                if (i % 2 == 0) {
                    swap(sanitizedLettersGroup, 0, i);
                } else {
                    swap(sanitizedLettersGroup, swapCount[i], i);
                }
                addAnagramToList(anagrams, sanitizedLettersGroup);
                swapCount[i]++;
                i = 1;
            } else {
                swapCount[i] = 0;
                i++;
            }
        }
        printAnagrams(anagrams);
    }

    public static void swap(char[] sanitizedLettersGroup, int x, int y) {
        char temp = sanitizedLettersGroup[x];
        sanitizedLettersGroup[x] = sanitizedLettersGroup[y];
        sanitizedLettersGroup[y] = temp;
    }

    public static void printAnagrams(ArrayList<String> anagrams) {
        for (int i = 0; i < anagrams.size(); i++) {
            System.out.print(anagrams.get(i));
            if (i < anagrams.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
