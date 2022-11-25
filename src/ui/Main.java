package ui;

import model.Control;

import java.util.Scanner;

public class Main {

    private static Scanner sc;
    private Control control;

    public Main() {
        sc = new Scanner(System.in);
        control = new Control();
    }

    public static void main(String[] args) {
        Main main = new Main();
        String select = "";
        do{
            select = String.valueOf(main.menu());
            main.select(select);
        }while(!select.equals("0"));
    }

    public int menu(){
        System.out.println("\n::::::::::::::::::::::::::::::::::\n\tPIPES MENU\n::::::::::::::::::::::::::::::::::\n(1) Create new graph \n(2) Add vertex \n(3) Add Edge\n(4) BFS algorithm\n(5) Kruskals algorithm\n(6) Dijkstra algorithm \n(0) Exit\n::::::::::::::::::::::::::::::::::");

        int select = sc.nextInt();
        sc.nextLine();

        return select;
    }

    public void select(String number){
        switch (number) {
            case "1":

                System.out.println(control.createGraph());
                break;

            case "2":

                System.out.println("Vertex ID");
                int key = sc.nextInt();

                System.out.println(control.addVertex(key));

                break;

            case "3":

                System.out.println("Origin vertex");
                int from = sc.nextInt();

                System.out.println("Destination vertex");
                int to = sc.nextInt();

                System.out.println("Edge weight");
                double weight = sc.nextInt();

                System.out.println(control.addEdge(from, to, weight));

                break;

            case "4":

                System.out.println("Origin vertex");
                int origin = sc.nextInt();

                System.out.println("Destination vertex");
                int destination = sc.nextInt();

                System.out.println(control.BFS(origin, destination));

                break;

            case "5":
                break;

            case "6":
                break;

            case "0":
                System.out.println("Bye!");
                break;

            default:
                System.out.println("\tTypo\nEnter a valid value");
                break;
        }
    }

}
