package com.jadenball.grapheditor;

import android.view.MotionEvent;



public class InputReadyState implements InputState {

    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //if on a circle, select
                if(c.model.contains(event.getX(), event.getY())){
                    c.selected = c.model.findClick(event.getX(), event.getY());
                    c.notifySubscribers();
                    c.state = new InputSelectedState();
                }
                else{
                    // event is on the background, prepare for creating a circle
                    c.state = new InputPrepareState();
                }
                break;
        }
    }
}

