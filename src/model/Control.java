package model;

import java.util.ArrayList;

public class Control {

    private MyGraph graph;

    public Control() {
        graph = new MyGraph();
    }

    public String createGraph(){
        graph = new MyGraph();

        //Add vertices
        graph.getNodes().put(0 ,new Node(0, false)); //0
        graph.getNodes().put(1, new Node(1, false)); //1
        graph.getNodes().put(2, new Node(2, false)); //2
        graph.getNodes().put(3, new Node(3, false)); //3
        graph.getNodes().put(4, new Node(4, false)); //4

        //Add adajacency list()
        graph.getNodes().get(0).getMembers().add(graph.getNodes().get(1).getId());
        graph.getNodes().get(1).getMembers().add(graph.getNodes().get(2).getId());
        graph.getNodes().get(2).getMembers().add(graph.getNodes().get(3).getId());
        graph.getNodes().get(3).getMembers().add(graph.getNodes().get(2).getId());
        graph.getNodes().get(4).getMembers().add(graph.getNodes().get(0).getId());
        graph.getNodes().get(2).getMembers().add(graph.getNodes().get(4).getId());

        return "Successfully created graph";
    }

    public String addVertex(int id){

        if(graph.getNodes().containsKey(id)){
            return "The vertex already exists";
        }else{
            graph.getNodes().put(id, new Node(id, false));
            return "Vertex added";
        }
    }

    public String verifyVertex(int from, int to){

        String out = "";
        if(!graph.getNodes().containsKey(to) && !graph.getNodes().containsKey(from)){
            out =  "Origin and destination vertex doesnt exist";
        }else if(!graph.getNodes().containsKey(to)){
            out = "Destination vertex doesnt exist";
        }else if(!graph.getNodes().containsKey(from)){
            out =  "Origin vertex doesnt exist";
        }

        return out;
    }

    public String addEdge(int from, int to, double weight){

        String out = "";
        if(verifyVertex(from, to).equals("")){
            //Add to edges array
            graph.getEdges().add(new Edge(graph.getNodes().get(from), graph.getNodes().get(to), weight));

            //Add to adjacency list
            graph.getNodes().get(from).getMembers().add(to);
            graph.getNodes().get(to).getMembers().add(from);

            out = "Successfully created Edge";
        }
        return out;
    }

    public String BFS(int origin, int goal){

        String out = "";
        if(verifyVertex(origin, goal).equals("")){
            out = "All points of the city are connected: "+graph.BFS(origin, goal);
        }
        return out;
    }

}
