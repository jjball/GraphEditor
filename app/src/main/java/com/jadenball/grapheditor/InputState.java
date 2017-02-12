package com.jadenball.grapheditor;


import android.view.MotionEvent;


public interface InputState {
    public void handleTouch(GraphViewController c, MotionEvent event);
}
