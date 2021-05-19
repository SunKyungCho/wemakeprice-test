package me.codetest.wemakepricetest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DivideResult {

    private final String quotient;
    private final String remainder;

    public DivideResult(String quotient, String remainder) {
        this.quotient = quotient;
        this.remainder = remainder;
    }
}
