package model;

import java.util.ArrayList;

public class Control {

    private MyGraph graph;

    public Control() {
        graph = new MyGraph();
    }

    public String createGraph(){
        graph = new MyGraph();

//        //Add vertices
//        graph.getNodes().put(1 ,new Node(1, false)); //u
//        graph.getNodes().put(2, new Node(2, false)); //v
//        graph.getNodes().put(3, new Node(3, false)); //y
//        graph.getNodes().put(4, new Node(4, false)); //z
//        graph.getNodes().put(5, new Node(5, false)); //v
//
//        //Add Edges
//        graph.getEdges().add(new Edge(graph.getNodes().get(1).getId(), graph.getNodes().get(2).getId(), 8));
//        graph.getEdges().add(new Edge(graph.getNodes().get(2).getId(), graph.getNodes().get(3).getId(), 2));
//        graph.getEdges().add(new Edge(graph.getNodes().get(3).getId(), graph.getNodes().get(4).getId(), 5));
//        graph.getEdges().add(new Edge(graph.getNodes().get(4).getId(), graph.getNodes().get(5).getId(), 10));
//
//        //Add adajacency list()
//        graph.getNodes().get(1).getMembers().add(graph.getNodes().get(2).getId());
//        graph.getNodes().get(2).getMembers().add(graph.getNodes().get(3).getId());
//        graph.getNodes().get(3).getMembers().add(graph.getNodes().get(4).getId());
//        graph.getNodes().get(4).getMembers().add(graph.getNodes().get(5).getId());

        //Add vertices
        graph.getNodes().put(1 ,new Node(1, false));
        graph.getNodes().put(2, new Node(2, false));
        graph.getNodes().put(3, new Node(3, false));
        graph.getNodes().put(4, new Node(4, false));
        graph.getNodes().put(5, new Node(5, false));
        graph.getNodes().put(6, new Node(6, false));
        graph.getNodes().put(7, new Node(7, false));

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

        return "\nSuccessfully created graph";
    }

    public String addVertex(int id){

        if(graph.getNodes().containsKey(id)){
            return "\nThe vertex already exists";
        }else{
            graph.getNodes().put(id, new Node(id, false));
            return "\nVertex added";
        }
    }

    public String verifyVertex(int from, int to){

        String out = "";
        if(!graph.getNodes().containsKey(to) && !graph.getNodes().containsKey(from)){
            out =  "\nOrigin and destination vertex doesnt exist";
        }else if(!graph.getNodes().containsKey(to)){
            out = "\nDestination vertex doesnt exist";
        }else if(!graph.getNodes().containsKey(from)){
            out =  "\nOrigin vertex doesnt exist";
        }

        return out;
    }

    public String addEdge(int from, int to, double weight){

        String out = "";
        if(verifyVertex(from, to).equals("")){
            //Add to edges array
            graph.getEdges().add(new Edge(graph.getNodes().get(from).getId(), graph.getNodes().get(to).getId(), weight));

            //Add to adjacency list
            graph.getNodes().get(from).getMembers().add(to);
            graph.getNodes().get(to).getMembers().add(from);

            out = "\nSuccessfully created Edge";
        }
        return out;
    }

    public String BFS(int origin, int goal){

        String out = "";
        out = verifyVertex(origin, goal);
        if(out.equals("")){
            out = "\nPoint "+origin+" is connected to "+goal+": "+graph.BFS(origin, goal);
        }
        return out;
    }

    public String Kruskal(){
        return String.valueOf(graph.kruskal());
    }

}
