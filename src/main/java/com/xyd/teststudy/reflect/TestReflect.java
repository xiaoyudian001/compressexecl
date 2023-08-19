package com.xyd.teststudy.reflect;

public class TestReflect {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.xyd.teststudy.reflect.Animal");
            System.out.println("成功加载类文件 " + aClass.getSimpleName());
        } catch (ClassNotFoundException e) {

        }

    }
}
