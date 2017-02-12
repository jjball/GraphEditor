package com.jadenball.grapheditor;


public class Vertex {

    float x, y;
    String vertexText;
    boolean longPressed = false;

    public Vertex(float x, float y){
        this.x = x;
        this.y = y;
    }


    public boolean contains(float xcoord, float ycoord){
        return xcoord >= this.x - 50 && xcoord <= this.x + 50 && ycoord >= this.y - 50 && ycoord <= this.y + 50;
    }


    public void setVertexText(String newText){
        vertexText = newText;
    }

    public String getVertexText(){
        return vertexText;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
