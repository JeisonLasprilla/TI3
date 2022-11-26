package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityGraphTest {
    CityGraph graph = new CityGraph();

    public void case0(int x) {
        for (int i=0; i<=x; i++){
            graph.getNodes().put(i ,new Sewer(i));
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

    @Test
    void clearVisited() {
    }

    @Test
    void BFS() {
        case1();
        assertTrue (graph.BFS(4, 0));

        case2();
        assertFalse(graph.BFS(3, 8));
        assertTrue(graph.BFS(0, 6));
        //assertTrue(graph.BFS(6, 0)); Dir

        case3();
        assertTrue(graph.BFS(0, 50));
        assertFalse(graph.BFS(2, 45));
    }

    @Test
    void getNodes() {
    }

    @Test
    void setNodes() {
    }

    @Test
    void getEdges() {
    }

    @Test
    void setEdges() {
    }
}