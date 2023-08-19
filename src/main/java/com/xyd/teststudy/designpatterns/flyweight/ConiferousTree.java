package com.xyd.teststudy.designpatterns.flyweight;

public class ConiferousTree extends Tree {
    private String appearance;

    public ConiferousTree(String appearance) {
        this.appearance = appearance;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a coniferoue tree at(" + x + "," + y + ") with appearance :" + appearance);
    }
}
