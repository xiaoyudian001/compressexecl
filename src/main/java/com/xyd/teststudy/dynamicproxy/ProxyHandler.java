package com.xyd.teststudy.dynamicproxy;

import com.xyd.teststudy.staticProxy.User;
import com.xyd.teststudy.staticProxy.UserInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler<T> implements InvocationHandler {
    private T target;

    public ProxyHandler(T target) {
        this.target = target;
    }

    /**
     * 代理方法
     *
     * @param proxy  代理对象
     * @param method 代理方法
     * @param args   代理方法的参数
     * @return 方法执行结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("pre words");
        Object ans = method.invoke(target, args);
        System.out.println("post words");
        return ans;
    }

    public static void main(String[] args) {
        //创建被代理的对象
        User user = new User();

        //初始化一个ProxyHandler对象
        InvocationHandler proxyHandler = new ProxyHandler(user);
        //使用Proxy类的一个静态方法生成代理对象userProxy
        UserInterface userProxy = (UserInterface) Proxy.newProxyInstance(User.class.getClassLoader(), new Class[]{UserInterface.class}, proxyHandler);
        //通过接口调用相应的方法，实际由Proxy执行
        userProxy.sayHello("XYD");

    }
}
