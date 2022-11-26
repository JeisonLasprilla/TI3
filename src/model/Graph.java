package model;

import java.util.ArrayList;
import java.util.HashMap;

public interface Graph <E>{

    void clearVisited();

    String dijsktra(int startingPoint);

    String kruskal();

    boolean BFS(E origin, E goal);


    HashMap<E, Sewer> getNodes();

    ArrayList<Conduit> getEdges();
}
