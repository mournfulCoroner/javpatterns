package com.javpatterns;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.javpatterns");

        Programmer jun = context.getBean("junior", Junior.class);
        Programmer mid = context.getBean("middle", Middle.class);
        Programmer sen = context.getBean("senior", Senior.class);

        jun.doCoding();
        mid.doCoding();
        sen.doCoding();
    }
}
