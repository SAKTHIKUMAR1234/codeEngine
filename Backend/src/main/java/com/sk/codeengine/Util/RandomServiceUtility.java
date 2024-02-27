package com.sk.codeengine.Util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RandomServiceUtility {
    public String getRandomId(){
        return UUID.randomUUID().toString();
    }
}
