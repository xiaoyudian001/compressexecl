package com.xyd.teststudy.designpatterns.prototypePattern;

/**
 * 原型模式（Prototype Pattern）是一种创建型设计模式，它通过复制（克隆）现有对象来创建新对象，
 * 而不是通过使用构造函数来创建。原型模式基于对象的克隆，可以在运行时动态地创建对象，并且能够避免频繁创建对象的开销。
 * <p>
 * 原型模式的主要目的是通过克隆现有对象来创建新对象，避免了创建对象时的初始化和构造过程。它适用于以下场景：
 * <p>
 * 当一个对象的创建过程比较复杂，或者需要耗费较多资源时，可以使用原型模式来复制已有对象，从而节省创建对象的开销。
 * <p>
 * 当需要创建的对象与已有对象具有相似的属性和行为时，可以使用原型模式来克隆已有对象，而无需重新编写相似的代码。
 * </p>
 * <p>
 * 原型模式通常包含以下角色：
 * <p>
 * 抽象原型（Prototype）：定义了克隆方法的接口，所有具体原型类都需要实现该接口。
 * <p>
 * 具体原型（Concrete Prototype）：实现了抽象原型接口，提供了克隆方法的具体实现。
 * <p>
 * 原型管理器（Prototype Manager）：负责管理原型对象的创建、注册和复制操作，可以通过该管理器获取新的对象实例。
 * </p>
 */
public class TestPrototypePattern {
    public static void main(String[] args) {
        Shape rectangleclone = new Rectangle(10, 5);
        Circle circleclone = new Circle(8);
        Shape clone01 = rectangleclone.clone();
        Shape clone02 = circleclone.clone();
        clone01.draw();
        clone02.draw();
    }
}
