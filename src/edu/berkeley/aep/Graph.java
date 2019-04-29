package edu.berkeley.aep;

import java.util.ArrayList;

public class Graph {
    ArrayList<Node> Nodes;

    public Graph(ArrayList<Node> nodes) {
        Nodes = nodes;
    }

    public boolean canReach(Node node1, Node node2) {
        if (node1.equals(node2)) {
            return true;
        } else {
            return false;
        }

    }
}
