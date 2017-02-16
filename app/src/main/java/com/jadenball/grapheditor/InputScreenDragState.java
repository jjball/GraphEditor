/*
 * Jaden Ball
 * jjb465
 * CMPT381
 */

package com.jadenball.grapheditor;

import android.view.MotionEvent;

/**
 * class InputScreenDragState
 * handles the touch where the user is dragging their finger on the canvas, moving the canvas
 */
public class InputScreenDragState implements InputState{

    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_UP:
                // user has stopped dragging the canvas
                c.state = new InputReadyState();
                break;

            case MotionEvent.ACTION_MOVE:
                // moving the screen in the opposite direction the user's finger is moving simulating a drag motion
                c.setPos(c.getxPos() - event.getX() + c.viewOffsetX,
                        c.getyPos() - event.getY() + c.viewOffsetY);
                c.viewOffsetX = event.getX();
                c.viewOffsetY = event.getY();
                break;


        }
    }
}
