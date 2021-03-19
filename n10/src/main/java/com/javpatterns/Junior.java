package com.javpatterns;

import org.springframework.stereotype.Component;

@Component
public class Junior implements Programmer {
    public void doCoding() {
        System.out.println("Do bad coding");
    }
}
