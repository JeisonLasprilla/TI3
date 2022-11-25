package model;

import java.util.ArrayList;

public interface Graph<E> {
    void insertVertex(E x);

    void insertArist(int vi, int vf);
    int order();
    ArrayList<E> sucesors(int position);
    String show();

    E getVertex(int position);

    boolean conexMethod();
}
