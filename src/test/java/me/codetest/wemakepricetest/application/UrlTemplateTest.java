package me.codetest.wemakepricetest.application;

import me.codetest.wemakepricetest.exception.FailedUrlLoaderException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

class UrlTemplateTest {

    UrlTemplate urlTemplate;

    @BeforeEach
    void setup() {
        urlTemplate = new UrlTemplate(new RestTemplate());
    }

    @Test
    @DisplayName("URL에서 contents를 가지고 온다")
    void get_contents_test() {
        String contents = urlTemplate.getHtmlByUrl("https://www.google.com/");
        assertThat(contents.length()).isGreaterThan(0);
    }

    @Test
    @DisplayName("정상적인 URL이 아닌 경우 예외처리한다")
    void is_not_url() {
        Assertions.assertThrows(FailedUrlLoaderException.class, () -> {
            urlTemplate.getHtmlByUrl("test");
        });
    }

    @Test
    @DisplayName("빈값의 경우 예외처리한다")
    void must_not_be_empty_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            urlTemplate.getHtmlByUrl("");
        });
    }

    @Test
    @DisplayName("null의 경우 예외처리한다")
    void must_not_be_null_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            urlTemplate.getHtmlByUrl("");
        });
    }
}
