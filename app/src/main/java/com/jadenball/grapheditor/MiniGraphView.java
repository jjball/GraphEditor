/*
 * Jaden Ball
 * jjb465
 * CMPT381
 */

package com.jadenball.grapheditor;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


/**
 * A mini graph view that replicates a normal graph view
 */
public class MiniGraphView extends View {

    Paint myPaint;
    GraphModel model;
    GraphViewController controller;

    /**
     * the view that the mini view replicates
     */
    GraphView parentView;

    /**
     * the width of the mini view
     */
    private float viewWidth;

    /**
     * the height of the mini view
     */
    private float viewHeight;

    /**
     * the scale of the mini view in relation to the full size view
     */
    private float scale = 0;


    /**
     * initializes the mini graph view
     * @param context the context
     */
    public MiniGraphView(Context context) {
        super(context);
        myPaint = new Paint();
        myPaint.setColor(Color.BLUE);
        this.setBackgroundColor(Color.LTGRAY);
        setViewSize(400, 400);
    }

    /**
     * sets the model for the mini graph view
     * @param g the model
     */
    public void setModel(GraphModel g){
        model = g;
    }


    /**
     * sets the controller for the mini graph view
     * @param g the controller
     */
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

    /**
     * draws a mini representation of the full graph view
     * @param canvas the canvas to be drawn on
     */
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

    /**
     * gets the views width
     * @return the views width
     */
    public float getViewWidth() {
        return viewWidth;
    }

    /**
     * sets the views width
     * @param viewWidth the new width
     */
    public void setViewWidth(float viewWidth) {
        this.viewWidth = viewWidth;
    }

    /**
     * gets the views height
     * @return the views height
     */
    public float getViewHeight() {
        return viewHeight;
    }

    /**
     * sets the views height
     * @param viewHeight the new height
     */
    public void setViewHeight(float viewHeight) {
        this.viewHeight = viewHeight;
    }

    /**
     * sets the size of the view
     * @param width the new width
     * @param height the new height
     */
    public void setViewSize(float width, float height){
        setViewWidth(width);
        setViewHeight(height);
    }

    /**
     * manually sets the scale if needed, as this is already set when adding the main graph view
     * @param newScale the new scale of the mini view compared to the main graph view
     */
    public void setScale(float newScale){
        scale = newScale;
    }

    /**
     * sets the scale in relation the the parent graph view
     */
    private void setScale(){
        scale = viewWidth / parentView.getViewWidth();
    }

    /**
     * gets the current scale of the mini view compared to the parent graph view
     * @return the scale
     */
    public float getScale(){
        return scale;
    }
}
