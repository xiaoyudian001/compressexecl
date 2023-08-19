package com.xyd.teststudy.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * <P>
 *     观察者模式（Observer Pattern）是一种行为型设计模式，它定义了对象之间的一对多依赖关系，使得当一个对象的状态发生变化时，所有依赖它的对象都会得到通知并自动更新。
 * 在观察者模式中，有两个主要角色：
 *
 * Subject（主题）：它是被观察的对象，也被称为主题或可观察者。它维护了一个观察者列表，并提供了添加、删除和通知观察者的方法。当主题的状态发生变化时，会通知所有注册的观察者。
 *
 * Observer（观察者）：它是接收主题通知的对象。观察者定义了一个更新方法，当接收到主题通知时，会调用该方法进行相应的更新操作。多个观察者可以同时观察同一个主题。
 * </P>
 */
public class ObserverPatternExample {
    public static void main(String[] args) {
// 创建具体主题对象
        ConcreteSubject subject = new ConcreteSubject();

        // 创建具体观察者对象
        Observer observer1 = new ConcreteObserver("Observer 1");
        Observer observer2 = new ConcreteObserver("Observer 2");
        Observer observer3 = new ConcreteObserver("Observer 3");

        // 注册观察者
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.registerObserver(observer3);

        // 设置主题状态，并通知观察者
        subject.setState(1);

        // 移除一个观察者
        subject.removeObserver(observer2);

        // 设置主题状态，并通知观察者
        subject.setState(2);
    }
}
// 主题接口
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
// 具体主题类
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }
   @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

// 观察者接口
interface Observer {
    void update(int state);
}

// 具体观察者类
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update(int state) {
        System.out.println("Observer " + name + " received update. New state: " + state);
    }
}
