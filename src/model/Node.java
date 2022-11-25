package model;

import java.util.HashSet;

class Node {
    private int id;
    private boolean visited;
    private HashSet<Integer> members; // Adjacency list

    Node(int id, boolean visited) {
        members = new HashSet<Integer>();
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
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMembers(HashSet<Integer> m) {
        this.members = m;
    }

    public HashSet<Integer> getMembers() {
        return this.members;
    }

    public boolean hasMember(Integer id) {
        return this.members.contains(id);
    }
}
