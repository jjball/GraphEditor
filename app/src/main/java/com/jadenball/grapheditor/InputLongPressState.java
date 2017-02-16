/*
 * Jaden Ball
 * jjb465
 * CMPT381
 */

package com.jadenball.grapheditor;


import android.view.MotionEvent;

/**
 * class InputLongPressState
 * handles the touch where the user has long pressed on a vertex on the canvas
 */
public class InputLongPressState implements InputState {

    boolean edgeAlreadyCreated = false;
    Edge e;

    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {

        //the current x position on the canvas
        float cx = c.getxPos();

        //the current y position on the canvas
        float cy = c.getyPos();


        //creates an edge if it is not already made
        if(!edgeAlreadyCreated) {
            c.model.createEdge(cx + event.getX(), cx + event.getX(), cy + event.getY(), cy + event.getY());
            c.longSelected = c.selected;
            edgeAlreadyCreated = true;
        }
        e = c.model.edges.get(c.model.edges.size() - 1);


        switch(event.getAction()) {
            case MotionEvent.ACTION_UP:
                // when user's finger is released, connects the edge to the vertex where the finger is released
                //  if there is no vertex there, we delete the edge
                if(c.model.contains(cx + event.getX(), cy + event.getY())){
                    Vertex v = c.model.findClick(cx + event.getX(), cy + event.getY());
                    e.setV2(v);
                }
                else{
                    c.model.edges.remove(e);
                }

                // change back to ready state
                c.longSelected = null;
                c.selected = null;
                c.state = new InputReadyState();
                c.notifySubscribers();
                break;

            case MotionEvent.ACTION_MOVE:
                // moves the edge with the user's finger
                c.model.moveEdge(e, cx + e.getX1(), cy + e.getY1(), cx + event.getX(), cy + event.getY());
                c.notifySubscribers();
                break;
        }
    }
}
