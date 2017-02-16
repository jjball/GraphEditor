package com.jadenball.grapheditor;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MiniGraphView extends View {

    Paint myPaint;
    GraphModel model;
    GraphViewController controller;
    GraphView parentView;
    private float viewWidth;
    private float viewHeight;

    /**
     * the scale of the mini view in relation to the full size view
     */
    private float scale = 0;

    public MiniGraphView(Context context) {
        super(context);
        myPaint = new Paint();
        myPaint.setColor(Color.BLUE);
        this.setBackgroundColor(Color.LTGRAY);
        setViewSize(400, 400);
    }

    public void modelChanged(){
        invalidate();
    }

    public void setModel(GraphModel g){
        model = g;
    }

    public void setController(GraphViewController g){
        controller = g;
    }

    /**
     * Sets the view that this view will replicate a mini version of
     * @param g the graph view we want a mini view of
     */
    public void setParentView(GraphView g){
        parentView = g;
        setScale();
    }

    public void onDraw(Canvas canvas){
        // Creating rectangle to show where the view is situated in relation to the entire view
        myPaint.setColor(Color.GRAY);
        canvas.drawRect(parentView.getViewPosX() * scale,
                parentView.getViewPosY() * scale,
                (parentView.getWidth() + parentView.getViewPosX()) * scale,
                (parentView.getHeight() + parentView.getViewPosY()) * scale,
                myPaint);


        // Creating all of the edges that are connecting vertices
        for(Edge e : model.edges){
            if(e.getV2() != null) {
                myPaint.setColor(Color.BLACK);
                canvas.drawLine(e.getX1() * scale, e.getY1() * scale, e.getX2() * scale, e.getY2() * scale, myPaint);
            }
        }

        // creating all the vertices
        for(Vertex v : model.vertices){
            myPaint.setColor(Color.BLUE);
            canvas.drawCircle(v.x * scale, v.y * scale, v.getRadius() * scale, myPaint);

        }
    }

    public float getViewWidth() {
        return viewWidth;
    }

    public void setViewWidth(float viewWidth) {
        this.viewWidth = viewWidth;
    }

    public float getViewHeight() {
        return viewHeight;
    }

    public void setViewHeight(float viewHeight) {
        this.viewHeight = viewHeight;
    }

    public void setViewSize(float width, float height){
        setViewWidth(width);
        setViewHeight(height);
    }

    public void setScale(float newScale){
        scale = newScale;
    }

    private void setScale(){
        scale = viewWidth / parentView.getViewWidth();
    }

    public float getScale(){
        return scale;
    }
}
