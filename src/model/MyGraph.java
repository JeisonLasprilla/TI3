package model;

import java.util.*;

public class MyGraph {
    private ArrayList<Edge> edges;
    private HashMap<Integer, Node> nodes;

    public MyGraph() {
        edges = new ArrayList<Edge>();
        nodes = new HashMap<Integer, Node>();
    }

    public void clearVisited(){
        for (Map.Entry<Integer, Node> entry: nodes.entrySet()){
            entry.getValue().setVisited(false);
        }
    }

    public boolean BFS(int origin, int goal){
        clearVisited();
        Queue queue = new LinkedList<>();
        return BFS(origin, goal, queue);
    }

    private boolean BFS(int origin, int goal, Queue<Node> queue){
        nodes.get(origin).setVisited(true);
        queue.add(nodes.get(origin));

        Node currentNode = null;

        while(!queue.isEmpty()){
            currentNode = queue.poll();
            if(currentNode== nodes.get(goal)){
                return true;
            }

            for (Integer member: currentNode.getMembers()) {
                if(nodes.get(member).getVisited() == false){
                    nodes.get(member).setVisited(true);
                    queue.add(nodes.get(member));
                }
            }
        }
        return false;
    }

    public HashMap<Integer, Node> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<Integer, Node> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }
}
