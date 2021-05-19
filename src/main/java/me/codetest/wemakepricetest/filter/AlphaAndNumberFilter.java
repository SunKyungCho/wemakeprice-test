package me.codetest.wemakepricetest.filter;

import java.util.function.Function;

public class AlphaAndNumberFilter implements Function<String, String> {

    @Override
    public String apply(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException("Must not be empty or null.  input: " + input);
        }
        return input.replaceAll("[^a-zA-Z0-9]", "");
    }
}
