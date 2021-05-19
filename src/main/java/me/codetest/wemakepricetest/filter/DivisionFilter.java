package me.codetest.wemakepricetest.filter;

import me.codetest.wemakepricetest.dto.DivideResult;

import java.util.function.Function;

public class DivisionFilter implements Function<String, DivideResult> {
    private final int number;

    public DivisionFilter(int number) {
        verify(number);
        this.number = number;
    }

    private void verify(int number) {
        if(number < 1) {
            throw new IllegalArgumentException("Must be greater than 0");
        }
    }

    @Override
    public DivideResult apply(String input) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException("Must not be empty or null.  input: " + input);
        }
        int length = input.length();
        int bundle = (length / number) * number;
        String substring = input.substring(0, bundle);
        String rest = input.substring(bundle, length);
        return new DivideResult(substring, rest);
    }
}
