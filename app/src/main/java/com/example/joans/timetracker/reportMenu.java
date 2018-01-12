package com.example.joans.timetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class reportMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reportmenu);

        Button cancel = (Button) findViewById(R.id.cancelButton);
        Button accept = (Button) findViewById(R.id.acceptButton);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(reportMenu.this, LlistaActivitatsActivity.class);
                startActivity(intent);
            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(reportMenu.this, LlistaActivitatsActivity.class);
                startActivity(intent);
            }
        });
    }
}
