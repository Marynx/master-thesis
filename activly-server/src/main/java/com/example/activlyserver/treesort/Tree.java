package com.example.activlyserver.treesort;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    Node node;
    List<Integer> result;
    Tree(int value){
        node = new Node(value);
        result = new ArrayList<>();
    }
    public Node insert(Node node, int value){
        if(node == null){
            return new Node(value);
        }
        // Move to the left if passed value is
        // less than the current node
        if(value < node.value){
            node.left = insert(node.left, value);
        }
        // Move to the right if passed value is
        // greater than the current node
        else if(value > node.value){
            node.right = insert(node.right, value);
        }
        return node;
    }
    
    // For traversing in order
    public List<Integer> inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            result.add(node.value);
            inOrder(node.right);
        }
        return result;
    }

}