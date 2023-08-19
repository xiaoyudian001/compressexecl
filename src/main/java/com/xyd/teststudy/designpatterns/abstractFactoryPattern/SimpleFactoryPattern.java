package com.xyd.teststudy.designpatterns.abstractFactoryPattern;

/**
 * 抽象工厂方法模式
 * <p>抽象工厂模式（Abstract Factory Pattern）是一种创建型设计模式，
 * 它提供了一种创建一系列相关或相互依赖对象的接口，而无需指定具体实现类。抽象工厂模式将对象的创建与使用解耦，使得客户端代码与具体对象的创建过程分离，
 * 从而实现了代码的灵活性、可扩展性和可维护性。
 * <p>
 * 在抽象工厂模式中，有以下几个关键角色：
 * <p>
 * 抽象工厂（Abstract Factory）：定义了创建一系列相关对象的接口，包括创建产品的抽象方法。
 * <p>
 * 具体工厂（Concrete Factory）：实现了抽象工厂中定义的创建产品的方法，负责实例化具体的产品对象。
 * <p>
 * 抽象产品（Abstract Product）：定义了产品的抽象接口，具体产品需要实现这个接口。
 * <p>
 * 具体产品（Concrete Product）：实现了抽象产品接口的具体产品类。</p>
 */
//客户端代码
public class SimpleFactoryPattern {
    public static void main(String[] args) {
//        //创建工厂对象
//        Factory factoryA = new ConcreateFactoryA();
//        Factory factoryB = new ConcreateFactoryB();
//        Product productA = factoryA.createProduct();
//        Product productb = factoryB.createProduct();
//        //使用产品
//        productA.use();
//        productb.use();
        String str="hello word";
        str=str.replace("hello","hi");
        String newStr=str.replace("hello","hi");

        System.out.println(str);
        System.out.println(newStr);

    }
}
/**
 * 在上面的示例中，抽象产品接口 Product 定义了产品的抽象方法 use()，具体产品类 ConcreteProductA 和 ConcreteProductB 分别实现了该接口。
 *
 * 抽象工厂接口 Factory 定义了创建产品的抽象方法 createProduct()，具体工厂类 ConcreteFactoryA 和 ConcreteFactoryB 实现了该接口，分别负责创建具体产品 A 和 B。
 *
 * 在客户端代码中，我们创建了工厂对象 factoryA 和 factoryB，并使用工厂方法 createProduct() 分别创建了具体产品 A 和 B。然后，我们可以通过产品的抽象接口 Product 来使用这些产品。
 *
 * 这样，通过工厂模式，我们可以将对象的创建过程和使用过程解耦，提高了代码的灵活性和可维护性。同时，如果需要扩展新的产品，只需创建新的具体产品和具体工厂类即可，不需要修改客户端代码。
 */
