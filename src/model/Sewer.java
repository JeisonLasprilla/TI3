package model;

import java.util.ArrayList;
import java.util.HashSet;

class Sewer implements Comparable<Sewer>{
    private int id;
    private boolean visited;

    private double minDistance;

    private ArrayList<Sewer> path = new ArrayList<>();
    private HashSet<Integer> members = new HashSet<Integer>();; // Adjacency list

    private ArrayList<Conduit> conduits = new ArrayList<>();

    Sewer(int id) {
        this.id = id;
        this.visited = false;
        this.minDistance = 999999999; //To infinity
        this.members.add(this.id);
    }

    public boolean isVisited() {
        return visited;
    }

    public ArrayList<Conduit> getEdges() {
        return conduits;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public ArrayList<Sewer> getPath() {
        return path;
    }

    public void setPath(ArrayList<Sewer> path) {
        this.path = path;
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public HashSet<Integer> getMembers() {
        return this.members;
    }

    public void setMembers(HashSet<Integer> members) {
        this.members = members;
    }

    public boolean hasMember(Integer id) {
        return this.members.contains(id);
    }

    @Override
    public int compareTo(Sewer other){
        return Double.compare(minDistance,other.minDistance);
    }
}
