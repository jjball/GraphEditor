package com.jadenball.grapheditor;


import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class InputSelectedState implements InputState {


    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {



        // if it is not a long press, the user is moving their finger
        // otherwise, create the edge and move to the long press state

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
