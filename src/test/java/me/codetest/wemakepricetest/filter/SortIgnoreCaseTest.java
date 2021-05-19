package me.codetest.wemakepricetest.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SortIgnoreCaseTest {

    private SortIgnoreCase sortIgnoreCase;

    @BeforeEach
    void setup() {
        sortIgnoreCase = new SortIgnoreCase();
    }

    @ParameterizedTest
    @DisplayName("알파벳 정렬 AaBb...YyZz 순으로 정렬한다")
    @CsvSource({
            "CABA, AABC",
            "AAabACa, AAAaabC"
    })
    void alphabet_sort(String input, String expect) {
        String result = sortIgnoreCase.apply(input);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("숫자와 영문을 같이 정렬한다")
    void sort_numbers_and_alphabets_test() {
        String result = sortIgnoreCase.apply("abACb3124");
        assertThat(result).isEqualTo("1234AabbC");
    }

    @Test
    @DisplayName("숫자를 정렬 한다")
    void number_sort_test() {
        String result = sortIgnoreCase.apply("3124");
        assertThat(result).isEqualTo("1234");
    }

    @Test
    @DisplayName("빈값의 경우 예외처리한다")
    void must_not_be_empty_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sortIgnoreCase.apply("");
        });
    }

    @Test
    @DisplayName("null의 경우 예외처리한다")
    void must_not_be_null_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            sortIgnoreCase.apply(null);
        });
    }
}
