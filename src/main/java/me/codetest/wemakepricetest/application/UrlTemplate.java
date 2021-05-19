package me.codetest.wemakepricetest.application;

import me.codetest.wemakepricetest.exception.FailedUrlLoaderException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class UrlTemplate {

    private final RestTemplate restTemplate;

    public UrlTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getHtmlByUrl(String url) {
        if (url == null || "".equals(url)) {
            throw new IllegalArgumentException("Must not be empty or null.  url: " + url);
        }
        try {
            ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
            return result.getBody();
        } catch (Exception e) {
            throw new FailedUrlLoaderException(e.getMessage());
        }
    }
}
