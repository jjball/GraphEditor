/*
 * Jaden Ball
 * jjb465
 * CMPT381
 */

package com.jadenball.grapheditor;


/**
 * Entity that is an edge meant to connect two vertices
 */
public class Edge {

    /**
     * starting x position
     */
    private float x1;

    /**
     * ending x position
     */
    private float x2;

    /**
     * starting y position
     */
    private float y1;

    /**
     * ending y position
     */
    private float y2;

    /**
     * the vertex the edge originates from
     */
    private Vertex v1;

    /**
     * the vertex the edge connects to
     */
    private Vertex v2;

    /**
     * creates a new edge with the specified coordinates
     * @param x1 starting x coordinate
     * @param x2 ending x coordinate
     * @param y1 starting y coordinate
     * @param y2 ending y coordinate
     */
    public Edge(float x1, float x2, float y1, float y2){
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
    }

    /**
     * Gets the starting x position
     * @return the starting x position
     */
    public float getX1() {
        if(v1 != null) setX1(v1.getX());
        return x1;
    }

    /**
     * sets the starting x position
     * @param x1 the new x position
     */
    public void setX1(float x1) {
        this.x1 = x1;
    }

    public float getX2() {
        if(v2 != null) setX2(v2.getX());
        return x2;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    /**
     * Gets the starting y position
     * @return the starting y position
     */
    public float getY1() {
        if(v1 != null) setY1(v1.getY());
        return y1;
    }

    /**
     * sets the starting y position
     * @param y1 the new y position
     */
    public void setY1(float y1) {
        this.y1 = y1;
    }

    /**
     * Gets the ending y position
     * @return the ending y position
     */
    public float getY2() {
        if(v2 != null) setY2(v2.getY());
        return y2;
    }

    /**
     * sets the ending y position
     * @param y2 the new y position
     */
    public void setY2(float y2) {
        this.y2 = y2;
    }

    /**
     * sets the vertex the edge originates from
     * @param v the vertex
     */
    public void setV1(Vertex v){
        v1 = v;
    }

    /**
     * sets the vertex the edge connects to
     * @param v the vertex
     */
    public void setV2(Vertex v){
        v2 = v;
    }

    /**
     * gets the vertex the edge connects to
     * @return the vertex
     */
    public Vertex getV2(){
        return v2;
    }

}
