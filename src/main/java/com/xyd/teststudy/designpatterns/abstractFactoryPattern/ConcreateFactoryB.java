package com.xyd.teststudy.designpatterns.abstractFactoryPattern;

public class ConcreateFactoryB implements Factory {
    @Override
    public Product createProduct() {
        return new ConcreateProductB();
    }
}
