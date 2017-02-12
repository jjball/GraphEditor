package com.jadenball.grapheditor;



public class Edge {

    private float x1;
    private float x2;
    private float y1;
    private float y2;
    private Vertex v1;
    private Vertex v2;

    public Edge(float x1, float x2, float y1, float y2){
        setX1(x1);
        setX2(x2);
        setY1(y1);
        setY2(y2);
    }

    public float getX1() {
        if(v1 != null) setX1(v1.getX());
        return x1;
    }

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

    public float getY1() {
        if(v1 != null) setY1(v1.getY());
        return y1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public float getY2() {
        if(v2 != null) setY2(v2.getY());
        return y2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }

    public void setV1(Vertex v){
        v1 = v;
    }

    public void setV2(Vertex v){
        v2 = v;
    }

    public Vertex getV2(){
        return v2;
    }

}
