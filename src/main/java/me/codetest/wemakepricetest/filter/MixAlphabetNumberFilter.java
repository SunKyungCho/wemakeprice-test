package me.codetest.wemakepricetest.filter;

import java.util.function.Function;

public class MixAlphabetNumberFilter implements Function<String, String> {

    @Override
    public String apply(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException("Must not be empty or null.  input: " + input);
        }
        StringBuilder numberStringBuilder = new StringBuilder();
        StringBuilder alphabetStringBuilder = new StringBuilder();
        for (char character : input.toCharArray()) {
            if (Character.isDigit(character)) {
                numberStringBuilder.append(character);
            }
            if (Character.isAlphabetic(character)) {
                alphabetStringBuilder.append(character);
            }
        }
        return mergeString(numberStringBuilder, alphabetStringBuilder);
    }

    private String mergeString(StringBuilder numberStringBuilder, StringBuilder alphabetStringBuilder) {
        StringBuilder result = new StringBuilder();
        String alphabets = alphabetStringBuilder.toString();
        String numbers = numberStringBuilder.toString();
        int shorterLength = getShorterLength(alphabets, numbers);
        for (int i = 0; i < shorterLength; i++) {
            result.append(alphabets.charAt(i));
            result.append(numbers.charAt(i));
        }
        result.append(alphabets.substring(shorterLength));
        result.append(numbers.substring(shorterLength));
        return result.toString();
    }

    private int getShorterLength(String alphabets, String numbers) {
        int alphabetLength = alphabets.length();
        int numberLength = numbers.length();
        return Math.min(alphabetLength, numberLength);
    }
}
