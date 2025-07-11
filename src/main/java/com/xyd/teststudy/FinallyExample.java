package com.xyd.teststudy;

public class FinallyExample {
    public static void main(String[] args) {
        System.out.println(doSomething());
    }

    public static int doSomething() {
        try {
            // 在try块中执行一些操作
            System.out.println("Inside try block");
            return 1; // 此处执行return语句
        } catch (Exception e) {
            System.out.println("Inside catch block");
            return 2;
        } finally {
            // 无论是否有return语句，finally块都会执行
            System.out.println("Inside finally block");
        }
    }
}

