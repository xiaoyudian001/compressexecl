package com.xyd.teststudy.jdkProxy;


import com.xyd.teststudy.jdkProxy.ElectricCar;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {
    private ElectricCar car;
    public InvocationHandlerImpl (ElectricCar electricCar){
        this.car=electricCar;
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("You are going to invoke "+method.getName()+" ...");
        method.invoke(car, null);
        System.out.println(method.getName()+" invocation Has Been finished...");
        return null;
    }
}
