package com.xyd.teststudy.cglibProxy;

import com.xyd.teststudy.cglibProxy.Hacker;
import com.xyd.teststudy.cglibProxy.Programmer;
import org.springframework.cglib.proxy.Enhancer;

public class TestClbib {
    public static void main(String[] args) {
        Programmer programmer= new Programmer();
        Hacker hacker=new Hacker();
        //cglib 中加强器，用来创建动态代理
        Enhancer enhancer = new Enhancer();
        //设置要创建动态代理的类
        enhancer.setSuperclass(programmer.getClass());
        // 设置回调，这里相当于是对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实行intercept()方法进行拦截
        enhancer.setCallback(hacker);
        Programmer proxy =(Programmer)enhancer.create();
        proxy.code();
    }
}
