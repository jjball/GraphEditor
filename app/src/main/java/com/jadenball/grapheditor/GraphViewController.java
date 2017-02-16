/*
 * Jaden Ball
 * jjb465
 * CMPT381
 */

package com.jadenball.grapheditor;


import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * The controller for a Graph
 */
public class GraphViewController implements View.OnTouchListener, View.OnLongClickListener{
    GraphModel model;
    Vertex selected = null;
    Vertex longSelected = null;
    ArrayList<View> subscribers;
    boolean isMoveState = false;
    InputState state;

    /**
     * the x position of the view
     */
    private float xPos;

    /**
     * the y position of the view
     */
    private float yPos;


    /**
     * the maximum width that the view may go to
     */
    private float maxWidth;

    /**
     * the maximum height that the view may go to
     */
    private float maxHeight;


    /**
     * the offset of the finger on the background compared to where the view should be drawn
     */
    float viewOffsetX, viewOffsetY;

    /**
     * the offset of the finger on a vertex compared to where it should be drawn
     */
    float xOffset, yOffset;

    /**
     * initializes the controller
     */
    public GraphViewController(){
        subscribers = new ArrayList<>();
        state = new InputReadyState();
    }


    /**
     * sets the model for the controller
     * @param g the model
     */
    public void setModel(GraphModel g){
        model = g;
    }


    /**
     * adds a view that gets notified of any changes within the controller
     * @param v the view that subscribes to the controller's notifications
     */
    public void addSubscriber(View v){
        subscribers.add(v);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event){
        state.handleTouch(this, event);
        return false;
    }


    /**
     * notifies all subscribers that a change has occurred
     */
    public void notifySubscribers(){
        for(View v : subscribers){
            v.invalidate();
        }
    }


    @Override
    public boolean onLongClick(View view) {
        // changing the state to the long pressed state

        if(!isMoveState && selected != null) {
            longSelected = selected;
            state = new InputLongPressState();
        }

        notifySubscribers();
        return true;
    }

    /**
     * gets the x position of where things will be drawn
     * @return the x position
     */
    public float getxPos() {
        return xPos;
    }

    /**
     * sets the x position of where things will be drawn
     * @param xPos the x position
     */
    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    /**
     * gets the y position of where things will be drawn
     * @return the y position
     */
    public float getyPos() {
        return yPos;
    }

    /**
     * sets the y position of where things will be drawn
     * @param yPos
     */
    public void setyPos(float yPos) {
        this.yPos = yPos;
    }


    /**
     * sets the position of the controller
     * @precond the position is not less than 0, and not greater than the max width/height
     * @param x the new x position
     * @param y the new y position
     */
    public void setPos(float x, float y){
        if(x > getMaxWidth()){
            x = getMaxWidth();
        }
        else if(x < 0){
            x = 0;
        }
        if(y > getMaxHeight()){
            y = getMaxHeight();
        }
        else if(y < 0){
            y = 0;
        }

        setxPos(x);
        setyPos(y);
        notifySubscribers();
    }

    /**
     * gets the max width that the view may be at
     * @return max width
     */
    public float getMaxWidth() {
        return maxWidth;
    }

    /**
     * sets the max width at which the view may go
     * @param maxWidth the max width
     */
    public void setMaxWidth(float maxWidth) {
        this.maxWidth = maxWidth;
    }

    /**
     * gets the max height that the view may be at
     * @return
     */
    public float getMaxHeight() {
        return maxHeight;
    }

    /**
     * sets the max height at which the view may go
     * @param maxHeight the max height
     */
    public void setMaxHeight(float maxHeight) {
        this.maxHeight = maxHeight;
    }
}
