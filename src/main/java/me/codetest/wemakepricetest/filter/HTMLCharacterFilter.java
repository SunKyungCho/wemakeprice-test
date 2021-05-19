package me.codetest.wemakepricetest.filter;

import java.util.function.Function;

public class HTMLCharacterFilter implements Function<String, String> {

    private final static String TAG_PATTERN = "<[^>]*>";
    private final static String EMPTY = "";

    @Override
    public String apply(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException("Must not be empty or null.  input: " + input);
        }
        return input.replaceAll(TAG_PATTERN, EMPTY);
    }
}
