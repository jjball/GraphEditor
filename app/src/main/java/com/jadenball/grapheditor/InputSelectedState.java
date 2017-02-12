package com.jadenball.grapheditor;


import android.view.GestureDetector;
import android.view.MotionEvent;

public class InputSelectedState implements InputState {


    /**
     * class gListener
     * Detects whether or not a long press happened
     */
    class gListener extends GestureDetector.SimpleOnGestureListener {
        public void onLongPress(MotionEvent event){
            super.onLongPress(event);
        }
    }


    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {

        // checking the gesture detector to see if a long press happened
        GestureDetector gDetector = new GestureDetector(c.model.view.getContext(), new gListener());
        // TODO: FIX BUG - The result is always true. The gesture detector seems to think it is always longPressed when pressed.
        boolean result = gDetector.isLongpressEnabled();

        // if it is not a long press, the user is moving their finger
        // otherwise, create the edge and move to the long press state
        if(!result) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    // change the state back to the ready state
                    c.selected = null;
                    c.notifySubscribers();
                    c.state = new InputReadyState();
                    break;

                case MotionEvent.ACTION_MOVE:
                    // change the inputstate to a move event
                    c.state = new InputMoveState();
                    break;

            }
        }
        else{
            // changing the state to the long pressed state
            c.model.createEdge(event.getX(), event.getX(), event.getY(), event.getY());
            c.state = new InputLongPressState();
            c.longSelected = c.selected;
            c.notifySubscribers();
        }

    }
}
