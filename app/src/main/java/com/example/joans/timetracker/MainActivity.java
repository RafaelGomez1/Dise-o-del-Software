package com.example.joans.timetracker;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private int selectedColor;
    private int defaultColor;
    private boolean projectSelected = true;
    private boolean taskSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button butoPerComensar = (Button) findViewById(R.id.buttonStart);
        final Button projectbutton = (Button) findViewById(R.id.projectbutton);
        final Button taskbutton = (Button) findViewById(R.id.taskbutton);
        final ImageButton createButton = (ImageButton) findViewById(R.id.createbutton);

        assert butoPerComensar != null;
        butoPerComensar.setOnClickListener(butoStartListener);

        assert createButton != null;
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, newAction.class);
                startActivity(intent);
            }
        });

        selectedColor = getResources().getColor(R.color.colorPrimaryDark);
        defaultColor = getResources().getColor(R.color.colorPrimary);

        assert projectbutton != null;
        projectbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!projectSelected && taskSelected){
                    projectbutton.setBackgroundColor(selectedColor);
                    assert taskbutton != null;
                    taskbutton.setBackgroundColor(defaultColor);
                    projectSelected = true;
                    taskSelected = false;
                }

            }
        });

        assert taskbutton != null;
        taskbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (projectSelected && !taskSelected){
                    projectbutton.setBackgroundColor(defaultColor);
                    taskbutton.setBackgroundColor(selectedColor);
                    projectSelected = false;
                    taskSelected = true;
                }
            }
        });
    }

    private View.OnClickListener butoStartListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, LlistaActivitatsActivity.class);
            startActivity(intent);
        }
    };

}
