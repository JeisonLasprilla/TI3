package model;

import java.util.*;

public class MyGraph implements Graph {
    private ArrayList<Edge> edges;
    private HashMap<Integer, Node> nodes;

    public MyGraph() {
        edges = new ArrayList<Edge>();
        nodes = new HashMap<Integer, Node>();
    }

    @Override
    public void clearVisited(){
        for (Map.Entry<Integer, Node> entry: nodes.entrySet()){
            entry.getValue().setVisited(false);
        }
    }

    public StringBuilder kruskal(){

        clearVisited();

        for (Map.Entry<Integer, Node> entry : nodes.entrySet()) {
            entry.getValue().getMembers().clear();
            entry.getValue().getMembers().add(entry.getValue().getId());


//            for (Integer member : entry.getValue().getMembers()) {
//                    nodes.get(member).setVisited(false);
//            }
        }

        ArrayList<Edge> out = new ArrayList<Edge>();

        Collections.sort(edges);

        for (Edge edge: edges) {

            Edge tmp = edge;

            int keyX = tmp.get_origin();
            int keyY = tmp.get_destination();

            Node x = nodes.get(keyX);
            Node y = nodes.get(keyY);

            if (!x.hasMember(y.getId())) { // Verificar que no esté repetido

                out.add(tmp);

                HashSet<Integer> m = x.getMembers();
                m.addAll(y.getMembers());  //m = Todos los hijos de X y Y(Sin repetir)

                Iterator<Integer> iterator = m.iterator();
                while (iterator.hasNext()) {
                    Integer current = iterator.next();
                    nodes.get(current).setMembers(m);  //Para cada uno de los hijos de X y Y se les asigna a los demás como hijos(para evitar ciclos)
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < out.size(); i++) {
            sum += out.get(i).get_weight();
        }

        StringBuilder print = new StringBuilder();
        print.append("\nEDGES:");

        for (Edge edge: out) {
            print.append("\n * From: "+edge.get_origin()+" To: "+edge.get_destination()+" Weight: "+edge.get_weight());
        }

        print.append("\nTotal weight: "+sum+"\n");

        return print;
    }

    @Override
    public boolean BFS(Object origin, Object goal) {
        clearVisited();
        Queue queue = new LinkedList<>();
        return BFS((int)origin, (int)goal, queue);
    }

    private boolean BFS(int origin, int goal, Queue<Node> queue) {
        nodes.get(origin).setVisited(true);
        queue.add(nodes.get(origin));

        Node currentNode = null;

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (currentNode == nodes.get(goal)) {
                return true;
            }

            for (Integer member : currentNode.getMembers()) {
                if (nodes.get(member).getVisited() == false) {
                    nodes.get(member).setVisited(true);
                    queue.add(nodes.get(member));
                }
            }
        }
        return false;
    }

    @Override
    public HashMap<Integer, Node> getNodes() {
        return nodes;
    }

    @Override
    public ArrayList<Edge> getEdges() {
        return edges;
    }
}
