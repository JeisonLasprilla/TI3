package model;

class Edge implements Comparable<Edge> {
    private Node origin;
    private Node destination;
    private double weight;

    public Edge(Node origin, Node destination, double weight) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    public Node getX() {
        return this.origin;
    }

    public Node getY() {
        return this.destination;
    }

    public double getW() {
        return this.weight;
    }

    public int compareTo(Edge b) {
        if (this.weight < b.weight) {
            return -1;
        } else if (this.weight > b.weight) {
            return 1;
        } else {
            if (this.origin.getId() + this.destination.getId() + this.weight < b.origin.getId() + b.destination.getId() + b.weight) {
                return -1;
            } else if (this.origin.getId() + this.destination.getId() + this.weight > b.origin.getId() + b.destination.getId() + b.weight) {
                return 1;
            }
        }
        return 0;
    }
}

