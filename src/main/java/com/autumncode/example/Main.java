package com.autumncode.example;

public class Main {
    public static void main(String[] args) {
        GraphInt intGraph=new GraphInt();
        intGraph.addEdge(1,2,1);
        intGraph.addEdge(2,3,1);
        intGraph.addEdge(2,4,1);
        intGraph.addEdge(2,3,1);
        System.out.println(intGraph.getAdjacent(2));
    }
}
