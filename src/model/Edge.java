package model;

class Edge implements Comparable<Edge> {
    private int _origin;
    private int _destination;

    private double _weight;

    public Edge(int origin, int destination, double weight) {
        this._origin = origin;
        this._destination = destination;
        this._weight = weight;
    }

    public int get_origin() {
        return _origin;
    }

    public int get_destination() {
        return _destination;
    }

    public double get_weight() {
        return _weight;
    }

    public int compareTo(Edge b) {
        if (this._weight < b._weight) {
            return -1;
        } else if (this._weight > b._weight) {
            return 1;
        } else {
            if (this._origin + this._destination + this._weight < b._origin + b._destination + b._weight) {
                return -1;
            } else if (this._origin + this._destination + this._weight > b._origin + b._destination + b._weight) {
                return 1;
            }
        }
        return 0;
    }

}

