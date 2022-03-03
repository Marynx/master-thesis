package com.example.activlyserver.treesort;

import java.util.List;

public class TreeSort {
    
    public List<Integer> sort(List<Integer> array){
        Tree tree = new Tree(array.get(0));
        for( int i : array){
            tree.insert(tree.node, i);
        }
        return tree.inOrder(tree.node);
    }
    
}
