package com.xyd.teststudy.designpatterns;

/**
 * 模板方法模式（Template Method Pattern）是一种行为型设计模式，它定义了一个算法的框架，并允许子类实现其中的具体步骤。
 * 在模板方法模式中，算法的整体结构在父类中定义，但具体的步骤实现延迟到子类中。
 * <p>
 * 模板方法模式的核心思想是将算法的结构和具体实现分离，通过定义一个模板方法作为算法的框架，
 * 将算法中可变的部分延迟到子类中实现，从而使得算法的框架稳定，而具体实现可以灵活变化。
 * <p>
 * 下面是模板方法模式的主要角色：
 * <p>
 * 抽象类（Abstract Class）：抽象类定义了算法的框架，其中包含一个或多个抽象方法和模板方法。
 * 抽象方法用于延迟到子类实现的具体步骤，而模板方法定义了算法的框架，其中包含一系列的步骤，这些步骤可以是具体方法或抽象方法。
 * <p>
 * 具体类（Concrete Class）：具体类是抽象类的子类，它实现了抽象方法，完成算法的具体步骤。
 */
public class TemplateMethodPatternExample {
    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        coffee.makeBeverage();

        System.out.println("-------------------");

        Beverage tea = new Tea();
        tea.makeBeverage();
    }
}

abstract class Beverage {
    // 模板方法，定义了制作饮料的框架
    public final void makeBeverage() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    // 具体步骤的实现由子类完成
    protected abstract void brew();

    protected abstract void addCondiments();

    // 具体步骤的实现在父类中定义
    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // 钩子方法，子类可以覆盖该方法来控制算法的某个步骤
    protected boolean customerWantsCondiments() {
        return true;
    }
}
    class Coffee extends Beverage {
        @Override
        protected void brew() {
            System.out.println("Brewing coffee");
        }

        @Override
        protected void addCondiments() {
            System.out.println("Adding milk and sugar");
        }

        // 覆盖钩子方法，控制是否添加调料
        protected boolean customerWantsCondiments() {
            return false;
        }
    }

    class Tea extends Beverage {
        @Override
        protected void brew() {
            System.out.println("Steeping tea");
        }

        @Override
        protected void addCondiments() {
            System.out.println("Adding lemon");
        }
    }


