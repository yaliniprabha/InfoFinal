package edu.berkeley.aep;

public class Edge {

    int weight;
    Node startNode;
    Node endNode;

    public Edge(int weight, Node start, Node end) {
        this.weight = weight;
        this.startNode = start;
        this.endNode = end;
    }

}
