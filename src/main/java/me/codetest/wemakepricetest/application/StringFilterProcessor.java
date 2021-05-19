package me.codetest.wemakepricetest.application;

import me.codetest.wemakepricetest.dto.DivideResult;
import me.codetest.wemakepricetest.filter.*;
import org.springframework.stereotype.Component;

@Component
public class StringFilterProcessor {

    public DivideResult process(String input, int groupCount) {
        verify(input, groupCount);
        return Processor.start(input)
                .next(new HTMLCharacterFilter())
                .next(new AlphaAndNumberFilter())
                .next(new SortIgnoreCase())
                .next(new MixAlphabetNumberFilter())
                .end(new DivisionFilter(groupCount));
    }

    public DivideResult processWithOutHTMLFilter(String input, int groupCount) {
        verify(input, groupCount);
        return Processor.start(input)
                .next(new AlphaAndNumberFilter())
                .next(new SortIgnoreCase())
                .next(new MixAlphabetNumberFilter())
                .end(new DivisionFilter(groupCount));
    }
    private void verify(String input, int groupCount) {
        if (input == null || "".equals(input)) {
            throw new IllegalArgumentException("Must not be empty or null");
        }
        if (groupCount < 1) {
            throw new IllegalArgumentException("Must be greater than 0");
        }
    }
}
