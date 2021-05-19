package me.codetest.wemakepricetest.filter;

import me.codetest.wemakepricetest.dto.DivideResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DivisionFilterTest {

    @Test
    @DisplayName("빈값의 경우 예외처리한다")
    void must_not_be_empty_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DivisionFilter divisionFilter = new DivisionFilter(5);
            divisionFilter.apply("");
        });
    }

    @Test
    @DisplayName("null의 경우 예외처리한다")
    void must_not_be_null_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DivisionFilter divisionFilter = new DivisionFilter(5);
            divisionFilter.apply(null);
        });
    }

    @Test
    @DisplayName("나눌값은 1보다 작을 수 없다")
    void must_be_greater_than_0_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DivisionFilter divisionFilter = new DivisionFilter(0);
        });
    }

    @Test
    @DisplayName("묶음 개수에 딱 맞게 떨어져서 나머지가 없는 경우")
    void no_rest_test() {
        DivisionFilter divisionFilter = new DivisionFilter(2);
        DivideResult result = divisionFilter.apply("a1b2c3d4e5f6");
        assertThat(result.getQuotient()).isEqualTo("a1b2c3d4e5f6");
        assertThat(result.getRemainder()).isEqualTo("");
    }

    @Test
    @DisplayName("묶음 개수에 맞는 몫과 나머지를 분류한다")
    void make_up_a_bundle_that_fits_the_number_of_test() {
        DivisionFilter divisionFilter = new DivisionFilter(5);
        DivideResult result = divisionFilter.apply("a1b2c3d4e5f6");
        assertThat(result.getQuotient()).isEqualTo("a1b2c3d4e5");
        assertThat(result.getRemainder()).isEqualTo("f6");
    }

    @Test
    @DisplayName("묶음이 너무 큰경우 나머지에 속하게 된다.")
    void if_the_bundle_is_too_large_test() {
        DivisionFilter divisionFilter = new DivisionFilter(100);
        DivideResult result = divisionFilter.apply("a1b2c3d4e5f6");
        assertThat(result.getQuotient()).isEqualTo("");
        assertThat(result.getRemainder()).isEqualTo("a1b2c3d4e5f6");

    }
}
