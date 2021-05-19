package me.codetest.wemakepricetest.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProcessorTest {

    @Test
    @DisplayName("next -> end 파이프라인 처리를 진행한다")
    void null_exception_test() {
        String test = Processor.start("test")
                .next(x -> {
                    x += 123;
                    return x;
                })
                .end(String::toUpperCase);
        assertThat(test).isEqualTo("TEST123");
    }

    @Test
    @DisplayName("next에서는 Processor를 리턴한다")
    void class_test() {
        Processor<String> processor = Processor.start("test")
                .next(x -> {
                    x += 123;
                    return x;
                });
        assertThat(processor.getClass()).isEqualTo(Processor.class);
    }

    @Test
    @DisplayName("end에서는 값을 받아올 수 있다.")
    void end_test() {
        String test = Processor.start("test")
                .end(String::toUpperCase);
        assertThat(test).isEqualTo("TEST");
    }

    @Test
    @DisplayName("null의 경우 예외처리한다")
    void must_not_be_null_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Processor.start(null);
        });
    }
}
