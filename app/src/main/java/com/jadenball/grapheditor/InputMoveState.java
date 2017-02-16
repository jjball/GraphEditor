/*
 * Jaden Ball
 * jjb465
 * CMPT381
 */

package com.jadenball.grapheditor;

import android.view.MotionEvent;

/**
 * class InputMoveState
 * handles the touch where the user is moving a vertex
 */
public class InputMoveState implements InputState {


    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_UP:
                // changes back to the ready state, user is no longer moving the vertex
                c.state = new InputReadyState();
                c.selected = null;
                c.isMoveState = false;
                c.notifySubscribers();
                break;

            case MotionEvent.ACTION_MOVE:
                // move the vertex to the new position
                c.model.moveVertex(c.selected, event.getX() - c.xOffset, event.getY() - c.yOffset);
                c.notifySubscribers();
                break;
        }
    }
}
