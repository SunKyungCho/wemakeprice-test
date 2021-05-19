package me.codetest.wemakepricetest.dto;

import me.codetest.wemakepricetest.filter.DivisionFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RequestTest {


    @Test
    @DisplayName("text type 확인")
    void text_type_test() {
        Request request = new Request();
        request.setType("text");
    }


    @Test
    @DisplayName("removeHtml type 확인")
    void removeHtmlTag_type_test() {
        Request request = new Request();
        request.setType("removeHtmlTag");
    }

    @Test
    @DisplayName("알수 없는 타입 예외처리")
    void unknown_type_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Request request = new Request();
            request.setType("test");
        });
    }

    @Test
    @DisplayName("URL 빈값의 경우 예외처리한다")
    void must_not_be_empty_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Request request = new Request();
            request.setUrl("");
        });
    }

    @Test
    @DisplayName("URL null의 경우 예외처리한다")
    void must_not_be_null_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Request request = new Request();
            request.setUrl(null);
        });
    }

    @Test
    @DisplayName("groupCount 1보다 작을 수 없다")
    void must_be_greater_than_0_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Request request = new Request();
            request.setGroupCount(0);
        });
    }
}
