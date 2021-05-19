package me.codetest.wemakepricetest.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HTMLCharacterFilterTest {

    private HTMLCharacterFilter htmlCharacterFilter;

    @BeforeEach
    void setup() {
        htmlCharacterFilter = new HTMLCharacterFilter();
    }

    @Test
    @DisplayName("HTML 태그를 삭제한다.")
    void remove_html_tag_test() {
        String html = "<p>Welcome to HTML world! 저와 함께 html을 배워봅시다.</p>";
        String result = htmlCharacterFilter.apply(html);
        assertThat(result).isEqualTo("Welcome to HTML world! 저와 함께 html을 배워봅시다.");
    }

    @Test
    @DisplayName("문자열 중간의 HTML 태그를 삭제한다.")
    void remove_middle_of_html_tag_test() {
        String html = "<body>Welcome to HTML<br> world! \n\nhtml</body>";
        String result = htmlCharacterFilter.apply(html);
        assertThat(result).isEqualTo("Welcome to HTML world! \n\nhtml");
    }

    @Test
    @DisplayName("빈값의 경우 예외처리한다")
    void must_not_be_empty_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            htmlCharacterFilter.apply("");
        });
    }

    @Test
    @DisplayName("null의 경우 예외처리한다")
    void must_not_be_null_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            htmlCharacterFilter.apply(null);
        });
    }
}
