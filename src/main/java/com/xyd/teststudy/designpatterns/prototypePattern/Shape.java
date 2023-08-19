package com.xyd.teststudy.designpatterns.prototypePattern;


public interface Shape extends Cloneable {
    void draw();
    Shape clone();
}
