package com.xyd.teststudy.designpatterns;

/**
 * <p>装饰器模式是一种结构型设计模式，它允许动态地向对象添加额外的功能，而不需要修改其原始类。这种模式通过创建一个包装类，
 * 将原始对象包装在内，并提供与原始对象相同的接口，以便通过包装类来扩展对象的行为。
 *
 * 在装饰器模式中，有以下几个角色：
 *
 * 抽象组件（Component）：定义了原始对象和装饰器对象的共同接口，可以是抽象类或接口。
 *
 * 具体组件（ConcreteComponent）：实现了抽象组件接口，是需要被装饰的原始对象。
 *
 * 抽象装饰器（Decorator）：继承了抽象组件，持有一个抽象组件对象的引用，并定义了与抽象组件相同的接口。
 *
 * 具体装饰器（ConcreteDecorator）：继承了抽象装饰器，通过对抽象组件进行装饰，添加额外的功能。</p>
 * */
public class TestDecoratorPattern {
    public static void main(String[] args) {
        // 使用装饰器模式
        Text text = new BasicText();
        Text decoratedText = new UppercaseTextDecorator(text);
        decoratedText.write("Hello, World!");
    }
}
// 抽象组件
 interface Text {
    void write(String content);
}

// 具体组件
 class BasicText implements Text {
    @Override
    public void write(String content) {
        System.out.println("Basic Text: " + content);
    }
}

// 抽象装饰器
 abstract class TextDecorator implements Text {
    protected Text text;

    public TextDecorator(Text text) {
        this.text = text;
    }
        @Override
    public void write(String content) {
        text.write(content);
    }
}

// 具体装饰器
 class UppercaseTextDecorator extends TextDecorator {
    public UppercaseTextDecorator(Text text) {
        super(text);
    }
    @Override
    public void write(String content) {
        String uppercaseContent = content.toUpperCase();
        super.write(uppercaseContent);
    }
}
/**
 *在上述例子中，Text接口是抽象组件，BasicText是具体组件。TextDecorator是抽象装饰器，
 * UppercaseTextDecorator是具体装饰器。通过创建装饰器对象并将原始对象作为参数传递给装饰器的构造函数，
 * 我们可以在不修改原始对象的情况下，动态地为其添加额外的功能。在上面的例子中，UppercaseTextDecorator将文本内容转换为大写，
 * 并通过调用父类的write方法来输出结果。
 *
 * 装饰器模式的优点包括灵活性、扩展性和遵循开闭原则。
 */