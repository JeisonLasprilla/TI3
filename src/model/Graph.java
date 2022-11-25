package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public interface Graph <E>{

    void clearVisited();

    boolean BFS(E origin, E goal);


    HashMap<E, Node> getNodes();

    ArrayList<Edge> getEdges();
}
