package com.jadenball.grapheditor;


import android.view.MotionEvent;

public class InputLongPressState implements InputState {

    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {
        Edge e = c.model.edges.get(c.model.edges.size() - 1);
        //e.getV2().setX(42);

        switch(event.getAction()) {
            case MotionEvent.ACTION_UP:
                if(c.model.contains(event.getX(), event.getY())){
                    Vertex v = c.model.findClick(event.getX(), event.getY());
                    e.setV2(v);
                }
                else{
                    c.model.edges.remove(e);
                }
                c.longSelected = null;
                c.selected = null;
                c.notifySubscribers();
                break;

            default:
                c.model.moveEdge(e, e.getX1(), e.getY1(), event.getX(), event.getY());
                c.notifySubscribers();
                break;
        }
    }
}
