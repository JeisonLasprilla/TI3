package model;

import java.util.HashSet;

class Node {
    private int id;
    private boolean visited;
    private HashSet<Integer> members = new HashSet<Integer>();; // Adjacency list

    Node(int id, boolean visited) {
        this.id = id;
        this.visited = visited;
        this.members.add(this.id);
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
}
