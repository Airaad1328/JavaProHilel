package com.gmail.clarkin200.graph;

import java.util.*;

public class MyGraph {
    private Map<Integer, List<Integer>> graph;

    public MyGraph() {
        graph = new HashMap<>();
    }

    public void addVertex(Integer vertex) {
        graph.putIfAbsent(vertex, new ArrayList<>());

    }

    public void addEdge(Integer from, Integer to) {
        try {
            if (!hasEdge(from, to)) {
                graph.get(from).add(to);
            } else {
                System.out.println("Edge already exist");
            }
        } catch (NullPointerException e) {
            System.out.println("Error creating edge " + from + "," + to + " vertex doesn't exist");
        }

    }

    public void removeVertex(Integer vertex) {
        graph.remove(vertex);

        graph.forEach((key, value) -> value.remove(vertex));
    }

    public void removeEdge(Integer from, Integer to) {
        try {
            if (hasEdge(from, to)) {
                graph.get(from).remove(to);
            }
        } catch (NullPointerException e) {
            System.out.println("Error removing edge " + from + "," + to + " vertex doesn't exist");
        }
    }

    public boolean hasVertex(Integer vertex) {
        return graph.containsKey(vertex);
    }

    public boolean hasEdge(Integer from, Integer to) {
        return graph.containsKey(from) && graph.get(from).contains(to);
    }

    public void print() {
        graph.forEach((key, value) -> System.out.println("Vertex " + key + " has edges --> " + value));

    }


}
