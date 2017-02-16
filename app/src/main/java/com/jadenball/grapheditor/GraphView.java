package com.jadenball.grapheditor;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * A graph view where vertices and edges can be drawn
 */
public class GraphView extends View {

    Paint myPaint;
    GraphModel model;
    GraphViewController controller;

    /**
     * the width that the user may scroll to if their screen is not large enough
     */
    private float viewWidth;

    /**
     * the height that the user may scroll to if their screen is not large enough
     */
    private float viewHeight;

    /**
     * the current x position within the entire view
     */
    private float viewPosX;

    /**
     * the current y position within the entire view
     */
    private float viewPosY;

    /**
     * used to tell the controller the necessary width/height after the canvas is laid out
     */
    private boolean firstTimeDrawing = true;

    /**
     * initializes the canvas and initial positions within the view
     * @param c the context
     */
    public GraphView(Context c) {
        super(c);
        myPaint = new Paint();
        myPaint.setColor(Color.BLUE);
        myPaint.setStrokeWidth(5);
        this.setBackgroundColor(Color.GRAY);

        setViewPosX(0);
        setViewPosY(0);
        setViewHeight(3000);
        setViewWidth(3000);
    }

    /**
     * sets the model for the view
     * @param g the model
     */
    public void setModel(GraphModel g){
        model = g;
    }

    /**
     * sets the controller for the view
     * @param g
     */
    public void setController(GraphViewController g){
        controller = g;
    }

    /**
     * updates the view information to be consistent with the model
     */
    public void modelChanged(){
        invalidate();
    }

    /**
     * draws the vertices and edges on the canvas
     * @param canvas the canvas to draw on
     */
    public void onDraw(Canvas canvas){
        // grabs the position the controller is currently at
        calculatePosition();

        // cx and cy are the coordinates of the current graph position,
        //  so that we draw at the correct position on the canvas
        float cx = controller.getxPos();
        float cy = controller.getyPos();


        for(Edge e : model.edges){
            myPaint.setColor(Color.BLACK);
            canvas.drawLine(e.getX1() - cx, e.getY1() - cy, e.getX2() - cx, e.getY2() - cy, myPaint);
        }


        for(Vertex v : model.vertices){
            if(v == controller.selected){
                myPaint.setColor(Color.YELLOW);
            }
            else{
                myPaint.setColor(Color.BLUE);
            }
            canvas.drawCircle(v.x - cx, v.y - cy, v.getRadius(), myPaint);

            myPaint.setColor(Color.WHITE);
            myPaint.setTextSize(40);
            canvas.drawText(v.getVertexText(), v.x - 20 - cx, v.y + 10 - cy, myPaint);

            if (v == controller.longSelected){
                myPaint.setColor(Color.BLACK);
                myPaint.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(v.x - cx, v.y - cy, v.getRadius(), myPaint);
                myPaint.setStyle(Paint.Style.FILL);
            }

        }
    }

    /**
     * calculates the current position of the graph and gives the controller the width/height
     *  of the visible GraphView the first time we calculate
     */
    private void calculatePosition(){
        if(firstTimeDrawing && controller != null){
            controller.setMaxHeight(viewHeight - getMeasuredHeight());
            controller.setMaxWidth(viewWidth - getMeasuredWidth());
            firstTimeDrawing = false;
        }
        setViewPosX(controller.getxPos());
        setViewPosY(controller.getyPos());
    }


    /**
     * gets the scrollable width of the view
     * @return the views specified width
     */
    public float getViewWidth() {
        return viewWidth;
    }

    /**
     * sets the scrollable width of the view
     * @param viewWidth the new width
     */
    public void setViewWidth(float viewWidth) {
        this.viewWidth = viewWidth;
    }

    /**
     * gets the scrollable height of the view
     * @return the views height that is scrollable
     */
    public float getViewHeight() {
        return viewHeight;
    }

    /**
     * sets the views scrollable height
     * @param viewHeight the new height
     */
    public void setViewHeight(float viewHeight) {
        this.viewHeight = viewHeight;
    }

    /**
     * sets the view size that is scrollable
     * @param width the width
     * @param height the height
     */
    public void setViewSize(float width, float height){
        setViewWidth(width);
        setViewHeight(height);
    }

    /**
     * gets the current x position of the view within it's scrollable area
     * @return the x position
     */
    public float getViewPosX() {
        return viewPosX;
    }

    /**
     * sets the current x position the view is at
     * @param viewPosX the new x position
     */
    public void setViewPosX(float viewPosX) {
        this.viewPosX = viewPosX;
    }

    /**
     * gets the current y position of the view within it's scrollable area
     * @return the y position
     */
    public float getViewPosY() {
        return viewPosY;
    }

    /**
     * sets the current y position the view is at
     * @param viewPosY the new y position
     */
    public void setViewPosY(float viewPosY) {
        this.viewPosY = viewPosY;
    }
}
