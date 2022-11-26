package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyGraphTest {
    MyGraph graph = new MyGraph();

    public void case0(int x) {
        for (int i=0; i<=x; i++){
            graph.getNodes().put(i ,new Node(i, false));
        }
    }

    public void case1(){
        //Nodes
        case0(4);

        //Add adjacency list()
        graph.getNodes().get(0).getMembers().add(graph.getNodes().get(1).getId());
        graph.getNodes().get(1).getMembers().add(graph.getNodes().get(2).getId());
        graph.getNodes().get(2).getMembers().add(graph.getNodes().get(3).getId());
        graph.getNodes().get(3).getMembers().add(graph.getNodes().get(2).getId());
        graph.getNodes().get(4).getMembers().add(graph.getNodes().get(0).getId());
        graph.getNodes().get(2).getMembers().add(graph.getNodes().get(4).getId());
    }

    public void case2(){
        //Nodes
        case0(10);

        //Add adjacency list()
        graph.getNodes().get(0).getMembers().add(graph.getNodes().get(1).getId());
        graph.getNodes().get(0).getMembers().add(graph.getNodes().get(2).getId());
        graph.getNodes().get(0).getMembers().add(graph.getNodes().get(3).getId());
        graph.getNodes().get(3).getMembers().add(graph.getNodes().get(4).getId());
        graph.getNodes().get(4).getMembers().add(graph.getNodes().get(5).getId());
        graph.getNodes().get(5).getMembers().add(graph.getNodes().get(1).getId());
        graph.getNodes().get(1).getMembers().add(graph.getNodes().get(6).getId());
        graph.getNodes().get(5).getMembers().add(graph.getNodes().get(6).getId());

        graph.getNodes().get(7).getMembers().add(graph.getNodes().get(8).getId());
        graph.getNodes().get(9).getMembers().add(graph.getNodes().get(8).getId());
        graph.getNodes().get(10).getMembers().add(graph.getNodes().get(9).getId());
    }

    public void case3(){
        case0(50);

        //Add adjacency list()
        //graph.getNodes().get(0).getMembers().add(graph.getNodes().get(1).getId());
        //graph.getNodes().get(1).getMembers().add(graph.getNodes().get(3).getId());
        //graph.getNodes().get(1).getMembers().add(graph.getNodes().get(4).getId());
        //graph.getNodes().get(0).getMembers().add(graph.getNodes().get(2).getId());

        for(int i = 0; i <= 45; i= i+5){
            graph.getNodes().get(i).getMembers().add(graph.getNodes().get(i+1).getId());
            graph.getNodes().get(i+1).getMembers().add(graph.getNodes().get(i+3).getId());
            graph.getNodes().get(i+1).getMembers().add(graph.getNodes().get(i+4).getId());
            graph.getNodes().get(i).getMembers().add(graph.getNodes().get(i+2).getId());
        }
        for (int x = 4; x <=49; x = x+5){
            graph.getNodes().get(x).getMembers().add(graph.getNodes().get(x+1).getId());
        }
    }

    public void case4(){
        case0(7);
        //Add Edges
        graph.getEdges().add(new Edge(graph.getNodes().get(1).getId(), graph.getNodes().get(2).getId(), 5));
        graph.getEdges().add(new Edge(graph.getNodes().get(1).getId(), graph.getNodes().get(3).getId(), 1));
        graph.getEdges().add(new Edge(graph.getNodes().get(1).getId(), graph.getNodes().get(4).getId(), 3));
        graph.getEdges().add(new Edge(graph.getNodes().get(1).getId(), graph.getNodes().get(6).getId(), 5));

        graph.getEdges().add(new Edge(graph.getNodes().get(2).getId(), graph.getNodes().get(7).getId(), 4));

        graph.getEdges().add(new Edge(graph.getNodes().get(3).getId(), graph.getNodes().get(5).getId(), 4));
        graph.getEdges().add(new Edge(graph.getNodes().get(3).getId(), graph.getNodes().get(7).getId(), 8));

        graph.getEdges().add(new Edge(graph.getNodes().get(4).getId(), graph.getNodes().get(6).getId(), 9));

        graph.getEdges().add(new Edge(graph.getNodes().get(5).getId(), graph.getNodes().get(6).getId(), 6));
        graph.getEdges().add(new Edge(graph.getNodes().get(5).getId(), graph.getNodes().get(7).getId(), 2));

        graph.getEdges().add(new Edge(graph.getNodes().get(6).getId(), graph.getNodes().get(7).getId(), 7));
    }

    @Test
    void clearVisited() {
        case1();
        assertFalse(graph.getNodes().get(0).getVisited());
        graph.BFS(0, 4);
        assertTrue(graph.getNodes().get(0).getVisited());

        graph.clearVisited();
        assertFalse(graph.getNodes().get(0).getVisited());

        //
        case2();
        assertFalse(graph.getNodes().get(6).getVisited());
        graph.BFS(1, 6);
        assertTrue(graph.getNodes().get(6).getVisited());

        graph.clearVisited();
        assertFalse(graph.getNodes().get(6).getVisited());

        //
        case2();
        assertFalse(graph.getNodes().get(2).getVisited());
        graph.BFS(1, 6);
        assertFalse(graph.getNodes().get(2).getVisited());

        graph.clearVisited(); //Still being false
        assertFalse(graph.getNodes().get(2).getVisited());
    }

    @Test
    void BFS() {
        case1();
        assertTrue (graph.BFS(4, 0));

        case2();
        assertFalse(graph.BFS(3, 8));
        assertTrue(graph.BFS(0, 6));

        case3();
        assertTrue(graph.BFS(0, 50));
        assertFalse(graph.BFS(2, 45));
    }

    @Test
    void kruskal() {
        case4();

        assertTrue(graph.getEdges().get(0).get_weight() == 5);
        assertTrue(graph.getEdges().get(0).get_origin() == 1);
        assertTrue(graph.getEdges().get(0).get_destination() == 2);

        graph.kruskal();
        assertTrue(graph.getEdges().get(0).get_weight() == 1);
        assertTrue(graph.getEdges().get(0).get_origin() == 1);
        assertTrue(graph.getEdges().get(0).get_destination() == 3);

        assertTrue(graph.kruskal().endsWith("\nTotal weight: 19\n"));
    }

    @Test
    void getNodes() {
        // Test by members
        case1();
        assertTrue(graph.getNodes().get(1).getMembers().toString().equals("[1, 2]"));

        case2();
        assertTrue(graph.getNodes().get(0).getMembers().toString().equals("[0, 1, 2, 3]"));

        case3();
        assertTrue(graph.getNodes().get(49).getMembers().toString().equals("[49, 50]"));
    }

    @Test
    void getEdges() {
        case4();
        assertFalse(graph.getEdges().isEmpty());

        assertTrue(graph.getEdges().get(0).get_weight() == 5);
        assertTrue(graph.getEdges().get(0).get_origin() == 1);
        assertTrue(graph.getEdges().get(0).get_destination() == 2);
    }

}