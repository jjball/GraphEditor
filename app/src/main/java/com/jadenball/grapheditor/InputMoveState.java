package com.jadenball.grapheditor;

import android.view.GestureDetector;
import android.view.MotionEvent;


public class InputMoveState implements InputState {


    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_UP:
                c.state = new InputReadyState();
                c.selected = null;
                c.isMoveState = false;
                c.notifySubscribers();
                break;

            case MotionEvent.ACTION_MOVE:
                c.model.moveVertex(c.selected, event.getX(), event.getY());
                c.notifySubscribers();
                break;
        }
    }
}
