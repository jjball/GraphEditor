/*
 * Jaden Ball
 * CMPT381
 */

package com.jadenball.grapheditor;


import android.view.MotionEvent;

/**
 * An interface for the state of input on the screen.
 * Is used for making a state machine
 */
public interface InputState {

    /**
     * handles the touch motion event on the graph view controller c
     * @param c the GraphViewController
     * @param event the MotionEvent
     */
    public void handleTouch(GraphViewController c, MotionEvent event);
}
