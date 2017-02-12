package com.jadenball.grapheditor;


import android.view.GestureDetector;
import android.view.MotionEvent;

public class InputSelectedState implements InputState {



    class gListener extends GestureDetector.SimpleOnGestureListener {
        public void onLongPress(MotionEvent event){
            super.onLongPress(event);
        }
    }


    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {

        GestureDetector gDetector = new GestureDetector(c.model.view.getContext(), new gListener());
        boolean result = gDetector.isLongpressEnabled();


        if(!result) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
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
            c.model.createEdge(event.getX(), event.getX(), event.getY(), event.getY());
            c.state = new InputLongPressState();
            c.longSelected = c.selected;
            c.notifySubscribers();
        }

    }
}
