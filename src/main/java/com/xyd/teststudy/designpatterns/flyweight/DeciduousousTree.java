package com.xyd.teststudy.designpatterns.flyweight;

public class DeciduousousTree extends Tree {
    private String appearance;

    public DeciduousousTree(String appearance) {
        this.appearance = appearance;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a deciduousous tree at(" + x + "," + y + ") with appearance :" + appearance);
    }
}
