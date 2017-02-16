package com.jadenball.grapheditor;


import android.view.MotionEvent;

public class InputPrepareState implements InputState {

    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {

        switch(event.getAction()){
            case MotionEvent.ACTION_UP:
                c.model.createVertex(c.getxPos() + event.getX(), c.getyPos() + event.getY());
                c.notifySubscribers();
                c.state = new InputReadyState();
                break;

            case MotionEvent.ACTION_MOVE:
                // user is navigating the canvas
                c.viewOffsetX = event.getX();
                c.viewOffsetY = event.getY();
                c.state = new InputScreenDragState();
                break;


        }


    }
}
