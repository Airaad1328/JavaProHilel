package com.gmail.clarkin200.graph;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyGraph myGraph = new MyGraph();

        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);
        myGraph.addVertex(4);

        myGraph.addEdge(2, 1);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(3, 4);
        myGraph.addEdge(2, 4);
        myGraph.addEdge(1, 4);
        myGraph.addEdge(1, 3);
        myGraph.addEdge(4, 2);
        myGraph.addEdge(5, 6);
        myGraph.addEdge(3, 1);

        myGraph.removeEdge(3, 4);

        myGraph.removeVertex(1);

        myGraph.print();

        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter value to check edge from: ");
        Integer from = scanner.nextInt();
        System.out.println("Enter value to check edge to: ");
        Integer to = scanner.nextInt();

        if (myGraph.hasEdge(from, to)) {
            System.out.println("Edge " + from + " -> " + to + " exist");
        } else {
            System.out.println("Edge " + from + " -> " + to + " doesn't exist");
        }

        System.out.println();
        System.out.println("Enter value to check vertex: ");
        Integer vertex = scanner.nextInt();

        if (myGraph.hasVertex(vertex)) {
            System.out.println("Vertex " + vertex + " exist");
        } else {
            System.out.println("Vertex " + vertex + " doesn't exist");
        }


    }

}
