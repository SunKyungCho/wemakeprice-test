package me.codetest.wemakepricetest.application;

import me.codetest.wemakepricetest.application.StringFilterProcessor;
import me.codetest.wemakepricetest.dto.DivideResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringFilterProcessorTest {


    private StringFilterProcessor stringFilterProcessor;

    @BeforeEach
    void setup() {
        stringFilterProcessor = new StringFilterProcessor();
    }

    @Test
    @DisplayName("HTML를 제거하는 프로세스를 갖는다")
    void process_test() {
        DivideResult result = stringFilterProcessor.process("<div>aDBAc15623</div>", 7);
        assertThat(result.getQuotient()).isEqualTo("A1a2B3c");
        assertThat(result.getRemainder()).isEqualTo("5D6");
    }

    @Test
    @DisplayName("HTML 태그를 제거하지 않는다")
    void process_without_HTML_filter_test() {
        DivideResult result = stringFilterProcessor.processWithOutHTMLFilter("<div>aDBAc15623</div>", 7);
        assertThat(result.getQuotient()).isEqualTo("A1a2B3c5D6ddii");
        assertThat(result.getRemainder()).isEqualTo("vv");
    }

    @Test
    @DisplayName("처리 초기값이 빈값의 경우 예외처리한다")
    void must_not_be_empty_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringFilterProcessor.process("", 1);
        });
    }

    @Test
    @DisplayName("초기값이 null의 경우 예외처리한다")
    void must_not_be_null_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringFilterProcessor.process(null, 1);
        });
    }

    @Test
    @DisplayName("나눌값은 1보다 작을 수 없다")
    void must_be_greater_than_0_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringFilterProcessor.process("test", 0);
        });
    }
}
