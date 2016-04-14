package com.autumncode.example;

import lombok.Data;

@Data
public class Edge<E> {
    int weight;
    E from;
    E to;

    public Edge(E from, E to, int weight) {
        this.from=from;
        this.to=to;
        this.weight=weight;
    }
}
