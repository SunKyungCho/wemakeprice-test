package me.codetest.wemakepricetest.controller;

import lombok.RequiredArgsConstructor;
import me.codetest.wemakepricetest.dto.DivideResult;
import me.codetest.wemakepricetest.dto.Request;
import me.codetest.wemakepricetest.service.HtmlStringParseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final HtmlStringParseService htmlStringParseService;

    @GetMapping("")
    public String getTesttPage() {
        return "html_parse";
    }

    @GetMapping("/api/process")
    @ResponseBody
    public ResponseEntity<DivideResult> get(Request request) {
        return ResponseEntity.ok(htmlStringParseService.parse(request));
    }
}
