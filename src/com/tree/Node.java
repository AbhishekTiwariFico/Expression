package com.tree;

public class Node {
    public String value;
    Node left, right;

    public Node(String item)
    {
        value = item;
        left = right = null;
    }
}
