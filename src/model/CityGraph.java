package model;

import java.util.*;

public class CityGraph implements Graph {

    private ArrayList<Conduit> conduits;
    private HashMap<Integer, Sewer> nodes;

    public CityGraph() {
        conduits = new ArrayList<>();
        nodes = new HashMap<Integer, Sewer>();
    }

    @Override
    public void clearVisited(){
        for (Map.Entry<Integer, Sewer> entry: nodes.entrySet()){
            entry.getValue().setVisited(false);
        }
    }

    @Override
    public String dijsktra(int startingPoint){
        nodes.get(startingPoint).setMinDistance(0);
        PriorityQueue<Sewer> queue = new PriorityQueue<Sewer>();
        queue.add(nodes.get(startingPoint));

        while(!queue.isEmpty()){
            Sewer current = queue.poll();
            for(Conduit neighbour: current.getEdges()){
                int newDist = (int) (current.getMinDistance()+neighbour.get_weight());

                if(nodes.get(neighbour.get_destination()).getMinDistance() > newDist){
                    // Remove the node from the queue to update the distance value.
                    queue.remove(neighbour.get_destination());
                    nodes.get(neighbour.get_destination()).setMinDistance(newDist);

                    // Take the path visited till now and add the new node.s
                    nodes.get(neighbour.get_destination()).setPath(current.getPath());
                    nodes.get(neighbour.get_destination()).getPath().add(current);

                    //Reenter the node with new distance.
                    queue.add(nodes.get(neighbour.get_destination()));
                }
            }
        }
        StringBuilder out = new StringBuilder();
        for (Map.Entry<Integer, Sewer> entry : nodes.entrySet()) {
            out.append("\n"+entry.getValue().getPath().toString());
        }
        return String.valueOf(out);
    }

    @Override
    public String kruskal(){

        HashMap<Integer, Sewer> hashTemp = new HashMap<>();

        for (Map.Entry<Integer, Sewer> entry : nodes.entrySet()) {

            hashTemp.put(entry.getKey(), new Sewer(entry.getKey()));

            entry.getValue().getMembers().clear();
            entry.getValue().getMembers().add(entry.getValue().getId());
        }

        ArrayList<Conduit> out = new ArrayList<Conduit>();

        Collections.sort(conduits);

        for (Conduit conduit : conduits) {

            Conduit tmp = conduit;

            int keyX = tmp.get_origin();
            int keyY = tmp.get_destination();

            Sewer x = hashTemp.get(keyX);
            Sewer y = hashTemp.get(keyY);

            if (!x.hasMember(y.getId())) { // Verificar que no esté repetido

                out.add(tmp);

                HashSet<Integer> m = x.getMembers();
                m.addAll(y.getMembers());  //m = Todos los hijos de X y Y(Sin repetir)

                Iterator<Integer> iterator = m.iterator();
                while (iterator.hasNext()) {
                    Integer current = iterator.next();
                    hashTemp.get(current).setMembers(m);  //Para cada uno de los hijos de X y Y se les asigna a los demás como hijos(para evitar ciclos)
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < out.size(); i++) {
            sum += out.get(i).get_weight();
        }

        StringBuilder print = new StringBuilder();
        print.append("\nEDGES:");

        for (Conduit conduit : out) {
            print.append("\n * From: "+ conduit.get_origin()+" To: "+ conduit.get_destination()+" Weight: "+ conduit.get_weight());
        }

        print.append("\nTotal weight: "+sum+"\n");

        return String.valueOf(print);
    }

    @Override
    public boolean BFS(Object origin, Object goal) {
        clearVisited();
        Queue queue = new LinkedList<>();
        return BFS((int)origin, (int)goal, queue);
    }

    private boolean BFS(int origin, int goal, Queue<Sewer> queue) {
        nodes.get(origin).setVisited(true);
        queue.add(nodes.get(origin));

        Sewer currentSewer = null;

        while (!queue.isEmpty()) {
            currentSewer = queue.poll();
            if (currentSewer == nodes.get(goal)) {
                return true;
            }

            for (Integer member : currentSewer.getMembers()) {
                if (nodes.get(member).getVisited() == false) {
                    nodes.get(member).setVisited(true);
                    queue.add(nodes.get(member));
                }
            }
        }
        return false;
    }

    @Override
    public HashMap<Integer, Sewer> getNodes() {
        return nodes;
    }

    @Override
    public ArrayList<Conduit> getEdges() {
        return conduits;
    }
}
