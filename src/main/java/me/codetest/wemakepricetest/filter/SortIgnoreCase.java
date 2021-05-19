package me.codetest.wemakepricetest.filter;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortIgnoreCase implements Function<String, String> {

    @Override
    public String apply(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException("Must not be empty or null.  input: " + input);
        }
        return Arrays.stream(input.split(""))
                .sorted((x, y) -> {
                    int compareToIgnoreCase = x.compareToIgnoreCase(y);
                    return compareToIgnoreCase == 0 ? x.compareTo(y) : compareToIgnoreCase;
                })
                .collect(Collectors.joining());
    }
}
