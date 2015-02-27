package com.peace.linkedList;

public class Node {
    String data;
    Node next;
    public Node(){
    	
    }  
    // Node constructor
    public Node(String _data) {
        next = null;
        data = _data;
    }

    //Another Node constructor if we want to specify the node to point to.
    public Node(String _data, Node _next) {
        next = _next;
        data = _data;
    }
}
