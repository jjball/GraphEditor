package com.jadenball.grapheditor;


import java.util.ArrayList;

public class GraphModel {

    ArrayList<Vertex> vertices;
    ArrayList<Edge> edges;
    GraphView view;

    public GraphModel(){
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void createVertex(float x, float y){
        Vertex v = new Vertex(x, y);
        v.setVertexText("V" + vertices.size());
        vertices.add(v);
        view.modelChanged();
    }

    public void createEdge(float x1, float x2, float y1, float y2){
        Edge e = new Edge(x1, x2, y1, y2);
        e.setV1(findClick(x1, y1));
        edges.add(e);
        view.modelChanged();
    }

    public void setView(GraphView gv){
        view = gv;
    }


    public boolean contains(float x, float y){
        boolean found = false;
        for(Vertex v : vertices){
            if(v.contains(x, y)){
                found = true;
            }
        }
        return found;
    }


    public Vertex findClick(float x, float y){
        Vertex foundVertex = null;

        for(Vertex v : vertices){
            if(v.contains(x, y)){
                foundVertex = v;
            }
        }

        return foundVertex;
    }



    public void moveVertex(Vertex v, float newX, float newY){
        v.x = newX;
        v.y = newY;
        view.modelChanged();
    }

    public void moveEdge(Edge e, float newX1, float newY1, float newX2, float newY2){
        e.setX1(newX1);
        e.setY1(newY1);
        e.setX2(newX2);
        e.setY2(newY2);
        view.modelChanged();
    }

}
