package me.codetest.wemakepricetest.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MixAlphabetNumberFilterTest {

    private MixAlphabetNumberFilter mixAlphabetNumberFilter;

    @BeforeEach
    void setup() {
        mixAlphabetNumberFilter = new MixAlphabetNumberFilter();
    }

    @ParameterizedTest
    @CsvSource({
            "1234abcd, a1b2c3d4",
            "Abad12ef, A1b2adef"
    })
    @DisplayName("알파벳과 숫자를 하나씩 교차한다")
    void mix_alphabets_and_numbers_one_by_one_test(String input, String expect) {
        assertThat(mixAlphabetNumberFilter.apply(input)).isEqualTo(expect);
    }


    @ParameterizedTest
    @CsvSource({
            "1234, 1234",
            "1234!$#$, 1234"
    })
    @DisplayName("숫자만 있는경우")
    void only_number_test(String input, String expect) {
        assertThat(mixAlphabetNumberFilter.apply(input)).isEqualTo(expect);
    }

    @Test
    @DisplayName("빈값의 경우 예외처리한다")
    void must_not_be_empty_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            mixAlphabetNumberFilter.apply("");
        });
    }

    @Test
    @DisplayName("null의 경우 예외처리한다")
    void must_not_be_null_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            mixAlphabetNumberFilter.apply(null);
        });
    }
}
