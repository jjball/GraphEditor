package com.jadenball.grapheditor;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GraphView extends View {

    Paint myPaint;
    GraphModel model;
    GraphViewController controller;
    private float viewWidth;
    private float viewHeight;
    private float viewPosX;
    private float viewPosY;

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


    public void setModel(GraphModel g){
        model = g;
    }

    public void setController(GraphViewController g){
        controller = g;
    }

    public void modelChanged(){
        invalidate();
    }

    public void drawEdge(Canvas canvas, Edge e){
        myPaint.setColor(Color.BLACK);
        canvas.drawLine(e.getX1(), e.getY1(), e.getX2(), e.getY2(), myPaint);
    }

    public void onDraw(Canvas canvas){
        for(Edge e : model.edges){
            drawEdge(canvas, e);
            //if(e.getV2() == null) model.edges.remove(e);
        }

        for(Vertex v : model.vertices){
            if(v == controller.selected){
                myPaint.setColor(Color.YELLOW);
            }
            else{
                myPaint.setColor(Color.BLUE);
            }
            canvas.drawCircle(v.x, v.y, v.getRadius(), myPaint);

            myPaint.setColor(Color.WHITE);
            myPaint.setTextSize(40);
            canvas.drawText(v.getVertexText(), v.x - 20, v.y + 10, myPaint);

            if (v == controller.longSelected){
                myPaint.setColor(Color.BLACK);
                myPaint.setStyle(Paint.Style.STROKE);
                canvas.drawCircle(v.x, v.y, v.getRadius(), myPaint);
                myPaint.setStyle(Paint.Style.FILL);
            }

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

    public float getViewPosX() {
        return viewPosX;
    }

    public void setViewPosX(float viewPosX) {
        this.viewPosX = viewPosX;
    }

    public float getViewPosY() {
        return viewPosY;
    }

    public void setViewPosY(float viewPosY) {
        this.viewPosY = viewPosY;
    }
}
