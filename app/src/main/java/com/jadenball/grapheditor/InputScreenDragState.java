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

                break;


        }
    }
}
