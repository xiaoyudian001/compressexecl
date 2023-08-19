package com.xyd.teststudy.useSpringTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyBeanFactory.class);
        context.refresh();

        MyBean myBean = context.getBean(MyBean.class);
        System.out.println(myBean.getField1()); // Output: Value 1
        System.out.println(myBean.getField2()); // Output: Value 2

        context.close();
    }
}
