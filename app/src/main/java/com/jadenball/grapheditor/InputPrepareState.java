package com.jadenball.grapheditor;


import android.view.MotionEvent;

public class InputPrepareState implements InputState {

    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {

        switch(event.getAction()){
            case MotionEvent.ACTION_UP:
                c.model.createVertex(event.getX(), event.getY());
                c.notifySubscribers();
                c.state = new InputReadyState();
                break;

            case MotionEvent.ACTION_MOVE:
                // change the inputstate back to ready, don't create a circle
                c.state = new InputReadyState();
                break;


        }


    }
}
