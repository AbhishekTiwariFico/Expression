package com.tree;

public class Node {
    public String value;
    public Node left, right;

    public Node(String item)
    {
        value = item;
        left = right = null;
    }
}
