package com.jadenball.grapheditor;


import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class GraphViewController implements View.OnTouchListener{
    GraphModel model;
    Vertex selected = null;
    Vertex longSelected = null;
    //Edge selectedEdge = null;
    ArrayList<View> subscribers;
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
        return true;
    }


    public void notifySubscribers(){
        for(View v : subscribers){
            v.invalidate();
        }
    }


}
