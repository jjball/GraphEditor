package com.jadenball.grapheditor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        // MVC
        MiniGraphView miniGraphView = new MiniGraphView(this);
        GraphView gView = new GraphView(this);
        GraphModel model = new GraphModel();
        GraphViewController controller = new GraphViewController();

        // connections
        controller.setModel(model);
        gView.setModel(model);
        model.setView(gView);
        gView.setController(controller);
        controller.addSubscriber(miniGraphView);
        controller.addSubscriber(gView);
        //controller.setView(gView);


        // set up event handling
        gView.setOnTouchListener(controller);
        gView.setOnLongClickListener(controller);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(miniGraphView, 400, 400);
        linearLayout.addView(gView);

        setContentView(linearLayout);


    }
}
