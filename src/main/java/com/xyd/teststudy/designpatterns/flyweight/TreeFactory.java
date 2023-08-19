package com.xyd.teststudy.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private static Map<String, Tree> treePool = new HashMap<>();

    public static Tree getTree(String type, String appearance) {
        Tree tree = treePool.get(type);
        if (tree == null) {
            if (type.equals("coniferous")) {
                tree = new ConiferousTree(appearance);
            } else if (type.equals("deciduous")) {
                tree = new DeciduousousTree(appearance);
            }
            treePool.put(type, tree);
        }

        return tree;
    }

}
