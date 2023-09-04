package com.xyd.teststudy.staticProxy;

public class User implements UserInterface {
    @Override
    public String sayHello(String name) {
        System.out.println("Hello" + name);
        return "OK";
    }
}
