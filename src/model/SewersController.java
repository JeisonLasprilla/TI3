package model;

public class SewersController {

    private CityGraph graph;

    public SewersController() {
        graph = new CityGraph();
    }

    public String createGraph(){
        graph = new CityGraph();

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

        //Add vertices
        graph.getNodes().put(1 ,new Sewer(1));
        graph.getNodes().put(2, new Sewer(2));
        graph.getNodes().put(3, new Sewer(3));
        graph.getNodes().put(4, new Sewer(4));
        graph.getNodes().put(5, new Sewer(5));
        graph.getNodes().put(6, new Sewer(6));
        graph.getNodes().put(7, new Sewer(7));


        //Add Edges
        addEdge(1,2,5);
        addEdge(1,3,1);
        addEdge(1,4,3);
        addEdge(1,6,5);


        addEdge(2,7,4);


        addEdge(3,5,4);
        addEdge(3,7,8);

        addEdge(4,6,9);

        addEdge(5,6,6);
        addEdge(5,7,2);

        addEdge(6,7,7);

        //Add adajacency list()
        /*graph.getNodes().get(1).getMembers().add(graph.getNodes().get(2).getId());
        graph.getNodes().get(1).getMembers().add(graph.getNodes().get(3).getId());
        graph.getNodes().get(1).getMembers().add(graph.getNodes().get(4).getId());
        graph.getNodes().get(1).getMembers().add(graph.getNodes().get(6).getId());

        graph.getNodes().get(2).getMembers().add(graph.getNodes().get(1).getId());
        graph.getNodes().get(2).getMembers().add(graph.getNodes().get(7).getId());

        graph.getNodes().get(3).getMembers().add(graph.getNodes().get(1).getId());
        graph.getNodes().get(3).getMembers().add(graph.getNodes().get(5).getId());
        graph.getNodes().get(3).getMembers().add(graph.getNodes().get(7).getId());

        graph.getNodes().get(4).getMembers().add(graph.getNodes().get(1).getId());
        graph.getNodes().get(4).getMembers().add(graph.getNodes().get(6).getId());

        graph.getNodes().get(5).getMembers().add(graph.getNodes().get(3).getId());
        graph.getNodes().get(5).getMembers().add(graph.getNodes().get(6).getId());
        graph.getNodes().get(5).getMembers().add(graph.getNodes().get(7).getId());


        graph.getNodes().get(6).getMembers().add(graph.getNodes().get(1).getId());
        graph.getNodes().get(6).getMembers().add(graph.getNodes().get(4).getId());
        graph.getNodes().get(6).getMembers().add(graph.getNodes().get(5).getId());
        graph.getNodes().get(6).getMembers().add(graph.getNodes().get(7).getId());*/
        return "\nSuccessfully created graph";
    }

    public String dijsktra(int start){
        return graph.dijsktra(start);
    }

    public String addVertex(int id){

        if(graph.getNodes().containsKey(id)){
            return "\nThe vertex already exists";
        }else{
            graph.getNodes().put(id, new Sewer(id));
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
            //Add to edges arr
            Conduit temp = new Conduit(graph.getNodes().get(from).getId(), graph.getNodes().get(to).getId(), weight);
            graph.getEdges().add(temp);

            //Add to adjacency list
            graph.getNodes().get(from).getMembers().add(to);
            graph.getNodes().get(to).getMembers().add(from);

            //Add to edges
            graph.getNodes().get(from).getEdges().add(temp);
            graph.getNodes().get(to).getEdges().add(temp);

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
        return graph.kruskal();
    }

}
