package com.nashtech.demoqa.pages.helper.utils.api.contents;

import java.util.Map;

public class HeaderHelper {
    static Map<String, String> headers;
    public Map<String, String> getHeader(String token) {
        headers.put("Content-Type", "application/json");
        headers.put("authorization", "Bearer " + token);
        return headers;
    }
}
