package com.jadenball.grapheditor;


import android.view.MotionEvent;

public class InputLongPressState implements InputState {

    boolean edgeAlreadyCreated = false;
    Edge e;

    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {

        if(!edgeAlreadyCreated) {
            c.model.createEdge(event.getX(), event.getX(), event.getY(), event.getY());
            c.longSelected = c.selected;
            edgeAlreadyCreated = true;
        }
        e = c.model.edges.get(c.model.edges.size() - 1);

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
                c.state = new InputReadyState();
                c.notifySubscribers();
                break;

            case MotionEvent.ACTION_MOVE:
                c.model.moveEdge(e, e.getX1(), e.getY1(), event.getX(), event.getY());
                c.notifySubscribers();
                break;
        }
    }
}
