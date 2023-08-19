package com.xyd.teststudy.polymorphism;

public class Testpmp {
        public static void main(String[] args) {
            // 使用父类引用指向子类对象
            Animal animal1 = new Dog();
            // 使用父类引用指向子类对象
            Animal animal2 = new Cat();
            animal1.makeSound();  // 调用的是 Dog 类的 makeSound() 方法
            animal2.makeSound();  // 调用的是 Cat 类的 makeSound() 方法
        }
}
class Animal {
    public void makeSound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }
}