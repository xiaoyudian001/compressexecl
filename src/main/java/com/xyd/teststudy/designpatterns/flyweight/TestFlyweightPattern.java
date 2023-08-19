package com.xyd.teststudy.designpatterns.flyweight;

/**
 * 1.享元模式（Flyweight Pattern）是一种结构型设计模式，它通过共享对象来减少内存使用和提高性能。
 * 享元模式的核心思想是将对象的状态分为内部状态（Intrinsic State）和外部状态（Extrinsic State），
 * 内部状态是可以共享的，而外部状态是每个对象独有的。
 * <p>
 * 在享元模式中，通过使用工厂类来创建和管理共享的对象实例。当需要获取对象时，工厂类首先检查是否已经存在具有相同内部状态的对象，
 * 如果存在，则返回已有的对象；如果不存在，则创建新的对象并将其添加到对象池中供后续使用。
 * </p>
 * <p>
 * 享元模式通常包含以下角色：
 * <p>
 * 抽象享元（Flyweight）：定义了享元对象的接口，其中包含了设置外部状态和获取内部状态的方法。
 * <p>
 * 具体享元（Concrete Flyweight）：实现了抽象享元接口，包含了内部状态，并提供了设置外部状态和获取内部状态的方法。
 * <p>
 * 享元工厂（Flyweight Factory）：负责创建和管理享元对象，包含了对象池用于存储和复用享元对象。
 * </p>
 */
public class TestFlyweightPattern {
    public static void main(String[] args) {
        Tree tree1 = TreeFactory.getTree("coniferous", "green");
        tree1.draw(10, 20);
        Tree tree2 = TreeFactory.getTree("deciduous", "yellow");
        tree2.draw(30, 40);
        Tree tree3 = TreeFactory.getTree("coniferous", "green");
        tree1.draw(50, 60);
    }
}
