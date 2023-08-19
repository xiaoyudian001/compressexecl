package com.xyd.teststudy.reflect;

import java.lang.reflect.Constructor;

public class TestReflect2 {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.xyd.teststudy.reflect.Worker");
            System.out.println("成功加载类文件 " + aClass.getSimpleName());
            //返回公共构造器
            Constructor<?>[] constructors = aClass.getConstructors();
            System.out.println("公共构造器共有 "+ constructors.length +" 个。");
            System.out.println("它们分别是：");
            for(Constructor cons : constructors)
            {
                System.out.println(cons.toGenericString());
            }
            Constructor<?> constructor = aClass.getConstructor(String.class, String.class);
            Worker worker = (Worker)constructor.newInstance(new String("1111"), new String("xyd"));
            System.out.println(worker.toString());
        } catch (Exception e) {

        }

    }
}
