/*
 * Jaden Ball
 * jjb465
 * CMPT381
 */

package com.jadenball.grapheditor;


import android.view.MotionEvent;

/**
 * class InputSelectedState
 * handles the touch where the user has selected a vertex on the canvas
 */
public class InputSelectedState implements InputState {


    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    // change the state back to the ready state
                    c.selected = null;
                    c.notifySubscribers();
                    c.state = new InputReadyState();
                    break;

                case MotionEvent.ACTION_MOVE:
                    // change the inputstate to a move event
                    c.xOffset = event.getX() - c.selected.getX();
                    c.yOffset = event.getY() - c.selected.getY();
                    c.isMoveState = true;
                    c.state = new InputMoveState();
                    break;
            }

    }
}
