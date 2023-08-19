package com.xyd.teststudy.designpatterns.abstractFactoryPattern;

public class ConcreateProductA implements Product {
    @Override
    public void use() {
        System.out.println("使用具体产品A");
    }
}
