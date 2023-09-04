package com.xyd.teststudy.staticProxy;

public class test {
    public static void main(String[] args) {
        //生成被代理对象
        User user=new User();
        //生成代理，顺便告诉代理他要代理谁
        UserProxy userProxy = new UserProxy(user);
        //触发代理方法
        userProxy.sayHello("XYD");

    }
}
