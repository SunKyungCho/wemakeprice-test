package me.codetest.wemakepricetest.dto;


import lombok.Getter;

@Getter
public class Request {

    private String url;
    private int groupCount;
    private String type;

    public void setUrl(String url) {
        if (url == null || "".equals(url)) {
            throw new IllegalArgumentException("url must not be null or empty");
        }
        this.url = url;
    }

    public void setGroupCount(int groupCount) {
        if (groupCount < 1) {
            throw new IllegalArgumentException("groupCount must be greater than 00");
        }
        this.groupCount = groupCount;
    }

    public void setType(String type) {
        if (!type.equals("removeHtmlTag") && !type.equals("text")) {
            throw new IllegalArgumentException("type must be text or removeHtmlTag type");
        }
        this.type = type;
    }
}
