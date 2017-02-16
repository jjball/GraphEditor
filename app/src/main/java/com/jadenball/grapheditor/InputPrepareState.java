/*
 * Jaden Ball
 * jjb465
 * CMPT381
 */

package com.jadenball.grapheditor;


import android.view.MotionEvent;

/**
 * class InputPrepareState
 * handles the touch where the user has touched an empty background
 */
public class InputPrepareState implements InputState {

    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {

        switch(event.getAction()){
            // released touch on the empty background
            case MotionEvent.ACTION_UP:
                c.model.createVertex(c.getxPos() + event.getX(), c.getyPos() + event.getY());
                c.notifySubscribers();
                c.state = new InputReadyState();
                break;

            case MotionEvent.ACTION_MOVE:
                // user is navigating/dragging the canvas
                c.viewOffsetX = event.getX();
                c.viewOffsetY = event.getY();
                c.state = new InputScreenDragState();
                break;


        }


    }
}
