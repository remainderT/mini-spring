package org.springframework.test.beans.service;

public class HelloService {

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }
}
