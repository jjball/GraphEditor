package com.jadenball.grapheditor;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MiniGraphView extends View {

    Paint myPaint;

    public MiniGraphView(Context context) {
        super(context);
        myPaint = new Paint();
        myPaint.setColor(Color.BLUE);
        this.setBackgroundColor(Color.LTGRAY);
    }
}
