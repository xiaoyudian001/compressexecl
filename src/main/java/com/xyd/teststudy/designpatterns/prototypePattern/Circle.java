package com.xyd.teststudy.designpatterns.prototypePattern;

public class Circle implements Shape {
    private int radius;
    public Circle(int radius){
        this.radius=radius;
    }
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }

    @Override
    public Shape clone() {
        return new Circle(radius);
    }
}
