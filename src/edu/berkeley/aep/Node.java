package edu.berkeley.aep;

import java.util.ArrayList;

public class Node {

    String location;
    ArrayList<Edge> connections;

    public Node(String name) {
        location = name;
        connections = new ArrayList<Edge>();
    }

    public void addConnection(Node other, int edgeWeight) {
        var edge = new Edge(edgeWeight, this, other);
        this.connections.add(edge);
    }

    public boolean canReach(Node other) {
        if (this.countHops(other).equals(Path.UNREACHABLE)) {
            return false;
        }
        return true;
    }

    public Path countHops(Node other) {
        return pathCost(other, 1);
    }

    public Path pathCost(Node other, int functionType) {
        ArrayList<Node> visited = new ArrayList<>();
        return pathCostHelper(other, visited,0, functionType);
    }

    private Path pathCostHelper(Node other, ArrayList<Node> visited, int totalCost, int functionType) {
        Path minPath = Path.UNREACHABLE;
        if (visited.contains(this)) {
            return minPath;
        } else {
            visited.add(this);
        }
        if (this.equals(other)) return new Path(totalCost);
        for (Edge connection: this.connections) {
            Path path;
            if (functionType == 1) {
                path = connection.endNode.pathCostHelper(other, new ArrayList<>(visited),totalCost + 1, functionType);
            } else {
                path = connection.endNode.pathCostHelper(other, new ArrayList<>(visited),totalCost + connection.weight, functionType);
            }
            if (path.value >= 0 && (path.compareTo(minPath) < 0 || minPath == Path.UNREACHABLE)) {
                minPath = path;
            }
        }
        return minPath;
    }
}
