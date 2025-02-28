package com.test;

public class App {

    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                AnagramGenerator.generateAnagrams(args[0]);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Invalid input for anagram generation.");
        }
    }
}


// Para obter todos os anagrama de uma determinada palavra é necessário inicialmente calcular o fatorial da quantidade de caracteres daquela palavra contudo esse cálculo deve considerar apenas a quantidade de letras sem repetição
