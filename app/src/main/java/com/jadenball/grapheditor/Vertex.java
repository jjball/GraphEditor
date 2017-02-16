/*
 * Jaden Ball
 * jjb465
 * CMPT381
 */

package com.jadenball.grapheditor;

/**
 * An entity that resembles a vertex
 */
public class Vertex {

    /**
     * x and y positions of the vertex
     */
    float x, y;

    /**
     * text to be displayed in the middle of the vertex when drawn
     */
    String vertexText;

    /**
     * the radius of the vertex
     */
    float radius = 65;

    /**
     * creates a new vertex with the x and y coordinates specified
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Vertex(float x, float y){
        this.x = x;
        this.y = y;
    }


    /**
     * calculates whether or not the vertex is within the given coordinates
     * @param xcoord the given x coordinate
     * @param ycoord the given y coordinate
     * @return true if the vertex is within the given x, y coordinates, false otherwise
     */
    public boolean contains(float xcoord, float ycoord){
        return xcoord >= this.x - radius && xcoord <= this.x + radius && ycoord >= this.y - radius && ycoord <= this.y + radius;
    }


    /**
     * sets the text to be displayed inside the vertex
     * @param newText the text
     */
    public void setVertexText(String newText){
        vertexText = newText;
    }

    /**
     * gets the vertex text
     * @return the text
     */
    public String getVertexText(){
        return vertexText;
    }

    /**
     * gets the x coordinate of the vertex
     * @return the x coordinate
     */
    public float getX() {
        return x;
    }

    /**
     * gets the y coordinate of the vertex
     * @return the y coordinate
     */
    public float getY() {
        return y;
    }

    /**
     * sets the x coordinate of the vertex
     * @param x the new x coordinate
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * sets the y coordinate of the vertex
     * @param y the new y coordinate
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * gets the radius of the vertex
     * @return the radius
     */
    public float getRadius(){
        return radius;
    }

    /**
     * sets the radius of the vertex
     * @param newRadius the new radius
     */
    public void setRadius(float newRadius){
        radius = newRadius;
    }
}
