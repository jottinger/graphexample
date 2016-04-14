package com.autumncode.example;

import java.util.Set;

public interface Graph<E> {
    void addEdge(E from, E to, int weight);
    void removeEdge(E from, E to);
    boolean hasEdge(E from, E to);
    int nodeCount();
    int edgeCount();
    Set<E> getAdjacent(E value);
}
