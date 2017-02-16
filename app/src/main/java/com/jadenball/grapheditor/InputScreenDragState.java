package com.jadenball.grapheditor;

import android.view.MotionEvent;

public class InputScreenDragState implements InputState{

    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {
        //System.out.println("ScreenDragState");
        switch(event.getAction()){
            case MotionEvent.ACTION_UP:
                c.state = new InputReadyState();
                break;

            case MotionEvent.ACTION_MOVE:
//               System.out.println("Starting pos: " + c.getxPos() + ", " + c.getyPos());
//                System.out.println("Moving to: " + event.getX() + ", " + event.getY());
                System.out.println((event.getX() - c.viewOffsetX) + ", " + (event.getY() - c.viewOffsetY));
                c.setPos(c.getxPos() - event.getX() + c.viewOffsetX,
                        c.getyPos() - event.getY() + c.viewOffsetY);
                c.viewOffsetX = event.getX();
                c.viewOffsetY = event.getY();
//                System.out.println("Ending pos: " + c.getxPos() + ", " + c.getyPos());
//                c.setPos(c.model.getViewWidth() - event.getX() - c.viewOffsetX, c.model.getViewHeight() - event.getY() - c.viewOffsetY);
                break;


        }
    }
}
