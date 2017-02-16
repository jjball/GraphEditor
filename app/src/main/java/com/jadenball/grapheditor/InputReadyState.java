/*
 * Jaden Ball
 * jjb465
 * CMPT381
 */

package com.jadenball.grapheditor;

import android.view.MotionEvent;


/**
 * class InputReadyState
 * handles the touch where the user is just placing their finger on the canvas
 */
public class InputReadyState implements InputState {

    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //if on a circle, select
                if(c.model.contains(c.getxPos() + event.getX(), c.getyPos() + event.getY())){
                    c.selected = c.model.findClick(c.getxPos() + event.getX(), c.getyPos() + event.getY());
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

