package com.foreflight.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

@Component
public class GenerateBasicAuth {
    public String generate(String username, String password) {
        byte[] encodedBytes = Base64Utils.encode((username + ":" + password).getBytes());
        return "Basic " + new String(encodedBytes);
    }
}
