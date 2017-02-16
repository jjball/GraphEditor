package com.jadenball.grapheditor;

import android.view.MotionEvent;

public class InputScreenDragState implements InputState{

    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_UP:
                c.state = new InputReadyState();
                break;

            case MotionEvent.ACTION_MOVE:
                // moving the screen in the opposite direction the user's finger is moving
                c.setPos(c.getxPos() - event.getX() + c.viewOffsetX,
                        c.getyPos() - event.getY() + c.viewOffsetY);
                c.viewOffsetX = event.getX();
                c.viewOffsetY = event.getY();
                break;


        }
    }
}
