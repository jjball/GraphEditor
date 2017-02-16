package com.jadenball.grapheditor;


import java.util.ArrayList;

/**
 * A model for a graph
 */
public class GraphModel {

    ArrayList<Vertex> vertices;
    ArrayList<Edge> edges;
    GraphView view;

    public GraphModel(){
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    /**
     * creates a vertex
     * @param x the x position of the vertex
     * @param y the y position of the vertex
     */
    public void createVertex(float x, float y){
        Vertex v = new Vertex(x, y);
        v.setVertexText("V" + vertices.size());
        vertices.add(v);
        view.modelChanged();
    }

    /**
     * creates an edge
     * @param x1 starting x position
     * @param x2 ending x position
     * @param y1 starting y position
     * @param y2 ending y position
     */
    public void createEdge(float x1, float x2, float y1, float y2){
        Edge e = new Edge(x1, x2, y1, y2);
        e.setV1(findClick(x1, y1));
        edges.add(e);
        view.modelChanged();
    }

    /**
     * sets the model's view
     * @param gv the model's view
     */
    public void setView(GraphView gv){
        view = gv;
    }


    /**
     * checks if there is a vertex at the specified coordinates
     * @param x x coordinates
     * @param y y coordinates
     * @return true if there is a vertex at the x, y coordinates, false otherwise
     */
    public boolean contains(float x, float y){
        boolean found = false;
        for(Vertex v : vertices){
            if(v.contains(x, y)){
                found = true;
            }
        }
        return found;
    }


    /**
     * returns the vertex at the specified x, y coordinates
     * @param x x coordinates of the vertex
     * @param y y coordinates of the vertex
     * @return the vertex at the coordinates, null if none exists
     */
    public Vertex findClick(float x, float y){
        Vertex foundVertex = null;

        for(Vertex v : vertices){
            if(v.contains(x, y)){
                foundVertex = v;
            }
        }

        return foundVertex;
    }


    /**
     * moves the vertex to a new position
     * @param v the vertex to be moved
     * @param newX the new x position of the vertex
     * @param newY the new y position of the vertex
     */
    public void moveVertex(Vertex v, float newX, float newY){
        v.x = newX;
        v.y = newY;
        view.modelChanged();
    }

    /**
     * Moves an edge
     * @param e the edge to be moved
     * @param newX1 new starting x coordinates
     * @param newY1 new starting y coordinates
     * @param newX2 new ending x coordinates
     * @param newY2 new ending y coordinates
     */
    public void moveEdge(Edge e, float newX1, float newY1, float newX2, float newY2){
        e.setX1(newX1);
        e.setY1(newY1);
        e.setX2(newX2);
        e.setY2(newY2);
        view.modelChanged();
    }


}
