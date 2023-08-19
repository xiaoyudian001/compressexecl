package com.xyd.teststudy.reflect;

import java.math.BigDecimal;

public class Worker {
    public String id;//工号
    public String name;//姓名
    public BigDecimal salary;//工资

    private Worker()
    {

    }
    public Worker(String id,String name)
    {
        this.id = id;
        this.name = name;
    }
    public Worker(String id,String name,BigDecimal salary)
    {
        this(id,name);
        this.salary = salary;
    }

    public void work()
    {
        System.out.println("Working......");
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
