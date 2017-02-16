package com.jadenball.grapheditor;


import android.view.MotionEvent;

public class InputLongPressState implements InputState {

    boolean edgeAlreadyCreated = false;
    Edge e;

    @Override
    public void handleTouch(GraphViewController c, MotionEvent event) {

        float cx = c.getxPos();
        float cy = c.getyPos();

        if(!edgeAlreadyCreated) {
            c.model.createEdge(cx + event.getX(), cx + event.getX(), cy + event.getY(), cy + event.getY());
            c.longSelected = c.selected;
            edgeAlreadyCreated = true;
        }
        e = c.model.edges.get(c.model.edges.size() - 1);

        switch(event.getAction()) {
            case MotionEvent.ACTION_UP:
                if(c.model.contains(cx + event.getX(), cy + event.getY())){
                    Vertex v = c.model.findClick(cx + event.getX(), cy + event.getY());
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
                c.model.moveEdge(e, cx + e.getX1(), cy + e.getY1(), cx + event.getX(), cy + event.getY());
                c.notifySubscribers();
                break;
        }
    }
}
