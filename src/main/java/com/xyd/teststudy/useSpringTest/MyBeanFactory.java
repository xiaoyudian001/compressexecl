package com.xyd.teststudy.useSpringTest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactory implements FactoryBean<MyBean> {

    @Override
    public MyBean getObject() throws Exception {
        // 在这里编写复杂的实例创建逻辑
        MyBean myBean = new MyBean();
        myBean.setField1("Value 1");
        myBean.setField2("Value 2");
        return myBean;
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

class MyBean {
    private String field1;
    private String field2;

    // 省略构造函数、getter 和 setter 方法

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public void doSomething() {
        System.out.println("Doing something...");
    }
}
