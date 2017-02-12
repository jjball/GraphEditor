package com.jadenball.grapheditor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        // MVC
        GraphView gView = new GraphView(this);
        GraphModel model = new GraphModel();
        GraphViewController controller = new GraphViewController();

        // connections
        controller.setModel(model);
        gView.setModel(model);
        model.setView(gView);
        gView.setController(controller);
        controller.addSubscriber(gView);
        //controller.setView(gView);


        // set up event handling
        gView.setOnTouchListener(controller);

        setContentView(gView);


    }
}
