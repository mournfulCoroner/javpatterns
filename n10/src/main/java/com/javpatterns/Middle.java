package com.javpatterns;

import org.springframework.stereotype.Component;

@Component
public class Middle implements Programmer{
    public void doCoding() {
        System.out.println("Do normal coding");
    }
}
