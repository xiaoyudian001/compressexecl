package com.xyd.teststudy.designpatterns.abstractFactoryPattern;

public class ConcreateProductB implements Product {
    @Override
    public void use() {
        System.out.println("使用具体产品B");
    }
}
