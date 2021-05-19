package me.codetest.wemakepricetest.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AlphaAndNumberFilterTest {

    private AlphaAndNumberFilter alphaAndNumberFilter;

    @BeforeEach
    void setup() {
        alphaAndNumberFilter = new AlphaAndNumberFilter();
    }

    @ParameterizedTest
    @CsvSource({
            "@1%(2한글3)(*4~<>5, 12345",
            "123@#%4한글56_+-=7, 1234567"
    })
    @DisplayName("문자열에서 숫자만 추출해 온다")
    void Extracts_only_numbers_from_strings_test(String input, String expect) {
        assertThat(alphaAndNumberFilter.apply(input)).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({
            "@a%(b한글c)(*d~<>e, abcde",
            "abc@#%d한글efg_+-=h, abcdefgh"
    })
    @DisplayName("문자열에서 숫자만 추출해 온다")
    void Extracts_only_alphabets_from_strings_test(String input, String expect) {
        assertThat(alphaAndNumberFilter.apply(input)).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource({
            "1@a2%(b3한글c)(*d~<>e, 1a2b3cde",
            "a1bc@2#%d한3글efg_4+-=h, a1bc2d3efg4h",
            "<table>hello 123</table>, tablehello123table"
    })
    @DisplayName("문자열에서 숫자만 추출해 온다")
    void Extracts_only_alphabets_and_numbers_from_strings_test(String input, String expect) {
        assertThat(alphaAndNumberFilter.apply(input)).isEqualTo(expect);
    }

    @Test
    @DisplayName("빈값의 경우 예외처리한다")
    void must_not_be_empty_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            alphaAndNumberFilter.apply("");
        });
    }

    @Test
    @DisplayName("null의 경우 예외처리한다")
    void must_not_be_null_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            alphaAndNumberFilter.apply(null);
        });
    }

}
