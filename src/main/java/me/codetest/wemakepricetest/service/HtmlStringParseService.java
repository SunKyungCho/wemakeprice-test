package me.codetest.wemakepricetest.service;


import lombok.RequiredArgsConstructor;
import me.codetest.wemakepricetest.application.StringFilterProcessor;
import me.codetest.wemakepricetest.application.UrlTemplate;
import me.codetest.wemakepricetest.dto.DivideResult;
import me.codetest.wemakepricetest.dto.Request;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HtmlStringParseService {

    private final UrlTemplate urlTemplate;
    private final StringFilterProcessor stringFilterProcessor;

    public DivideResult parse(Request request) {
        String contents = urlTemplate.getHtmlByUrl(request.getUrl());
        return isIgnoreHtmlTag(request.getType()) ?
                stringFilterProcessor.process(contents, request.getGroupCount())
                : stringFilterProcessor.processWithOutHTMLFilter(contents, request.getGroupCount());
    }

    private boolean isIgnoreHtmlTag(String type) {
        return "removeHtmlTag".equals(type);
    }
}
