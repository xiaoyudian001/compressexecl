package com.xyd.teststudy.designpatterns.abstractFactoryPattern;

public class ConcreateFactoryA implements Factory {
    @Override
    public Product createProduct() {
        return new ConcreateProductA();
    }
}
