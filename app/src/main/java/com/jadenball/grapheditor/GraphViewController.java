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
        //state = new InputReadyState();
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

        if(!isMoveState) {
            state = new InputLongPressState();
        }
        
        notifySubscribers();
        return true;
    }
}
