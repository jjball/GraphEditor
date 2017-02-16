package com.jadenball.grapheditor;


import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class GraphViewController implements View.OnTouchListener, View.OnLongClickListener{
    GraphModel model;
    Vertex selected = null;
    Vertex longSelected = null;
    //Edge selectedEdge = null;
    ArrayList<View> subscribers;
    boolean isMoveState = false;
    InputState state;

    private float xPos;
    private float yPos;

    private float maxWidth;
    private float maxHeight;

    float viewOffsetX, viewOffsetY;
    float xOffset, yOffset;

    public GraphViewController(){
        subscribers = new ArrayList<>();
        state = new InputReadyState();
    }

    public void setModel(GraphModel g){
        model = g;
    }

    public void addSubscriber(View v){
        subscribers.add(v);
    }

    public boolean onTouch(View v, MotionEvent event){
        state.handleTouch(this, event);
        return false;
    }


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

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

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

    public float getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(float maxWidth) {
        this.maxWidth = maxWidth;
    }

    public float getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(float maxHeight) {
        this.maxHeight = maxHeight;
    }
}
