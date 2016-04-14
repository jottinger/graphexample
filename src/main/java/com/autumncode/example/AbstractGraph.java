package com.autumncode.example;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

abstract public class AbstractGraph<E> implements Graph<E> {
    private Set<E> nodes = new HashSet<>();
    private Set<Edge<E>> edges = new HashSet<>();

    @Override
    public void addEdge(E from, E to, int weight) {
        nodes.add(from);
        nodes.add(to);
        Optional<Edge<E>> o = edges.stream().filter(e -> from.equals(e.from) && to.equals(e.to)).findFirst();
        if (o.isPresent()) {
            o.get().setWeight(weight);
        } else {
            edges.add(new Edge<E>(from, to, weight));
        }
    }

    @Override
    public void removeEdge(E from, E to) {
        Optional<Edge<E>> o = edges.stream().filter(e -> from.equals(e.from) && to.equals(e.to)).findFirst();
        if (o.isPresent()) {
            edges.remove(o.get());
        }
    }

    @Override
    public boolean hasEdge(E from, E to) {
        return edges.stream().filter(e -> from.equals(e.from) && to.equals(e.to)).findFirst().isPresent();
    }

    @Override
    public int nodeCount() {
        return nodes.size();
    }

    @Override
    public int edgeCount() {
        return edges.size();
    }

    @Override
    public Set<E> getAdjacent(E value) {
        return edges
                .stream()
                .filter(e -> value.equals(e.from) || value.equals(e.to)) // is edge adjacent
                .map(e -> value.equals(e.from) ? e.to : e.from) // which part of it is adjacent
                .collect(Collectors.toSet()); // oh yeah, a set
    }
}
