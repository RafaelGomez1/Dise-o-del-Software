package com.example.joans.timetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class newAction extends AppCompatActivity {

    private boolean l = false, m= false, x=false, j= false, v= false, s= false ,d = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_action);

        final int selectedColor = getResources().getColor(R.color.colorPrimaryDark);
        final int defaultColor = getResources().getColor(R.color.colorBackground);

        RadioGroup radioButtonGroup = (RadioGroup) findViewById(R.id.radioGroup);
        assert radioButtonGroup != null;
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();

        Button cancelButt = (Button) findViewById(R.id.cancelButton);
        RadioButton projectButton = (RadioButton) findViewById(R.id.projectButt);
        RadioButton taskButton = (RadioButton) findViewById(R.id.taskButton);
        final LinearLayout maxDurLay = (LinearLayout) findViewById(R.id.maxDurLay);
        final LinearLayout repeatLayout = (LinearLayout) findViewById(R.id.repeatLayout);
        final LinearLayout from = (LinearLayout) findViewById(R.id.from);
        final LinearLayout to = (LinearLayout) findViewById(R.id.to);
        final Switch repeat = (Switch) findViewById(R.id.repeatSwitch);
        final LinearLayout dias = (LinearLayout) findViewById(R.id.dias);

        final Button lunes = (Button) findViewById(R.id.lunes);
        final Button martes = (Button) findViewById(R.id.martes);
        final Button miercoles = (Button) findViewById(R.id.miercoles);
        final Button jueves = (Button) findViewById(R.id.jueves);
        final Button viernes = (Button) findViewById(R.id.viernes);
        final Button sabado = (Button) findViewById(R.id.sabado);
        final Button domingo = (Button) findViewById(R.id.domingo);

        cancelButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(newAction.this, LlistaActivitatsActivity.class);
                startActivity(intent);
            }
        });

        assert projectButton != null;
        projectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert maxDurLay != null;
                maxDurLay.setVisibility(View.GONE);
                assert repeatLayout != null;
                repeatLayout.setVisibility(View.GONE);
                assert from != null;
                from.setVisibility(View.GONE);
                assert to != null;
                to.setVisibility(View.GONE);
            }
        });

        assert taskButton != null;
        taskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert maxDurLay != null;
                maxDurLay.setVisibility(View.VISIBLE);
                assert repeatLayout != null;
                repeatLayout.setVisibility(View.VISIBLE);
                assert from != null;
                from.setVisibility(View.VISIBLE);
                assert to != null;
                to.setVisibility(View.VISIBLE);
            }
        });

        assert repeat != null;
        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (repeat.isChecked()){
                    assert dias != null;
                    dias.setVisibility(View.VISIBLE);
                }else{
                    assert dias != null;
                    dias.setVisibility(View.GONE);
                }
            }
        });


        //FUNCIONES PARA CAMBIAR COLOR DE LOS DIAS

        assert lunes != null;
        lunes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!l){
                    lunes.setBackgroundColor(selectedColor);
                    l = true;
                }else{
                    lunes.setBackgroundColor(defaultColor);
                    l = false;
                }
            }
        });

        assert martes != null;
        martes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!m){
                    martes.setBackgroundColor(selectedColor);
                    m = true;
                }else{
                    martes.setBackgroundColor(defaultColor);
                    m = false;
                }
            }
        });

        assert miercoles != null;
        miercoles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!x){
                    miercoles.setBackgroundColor(selectedColor);
                    x = true;
                }else{
                    miercoles.setBackgroundColor(defaultColor);
                    x = false;
                }
            }
        });

        assert jueves != null;
        jueves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!j){
                    jueves.setBackgroundColor(selectedColor);
                    j = true;
                }else{
                    jueves.setBackgroundColor(defaultColor);
                    j = false;
                }
            }
        });

        assert viernes != null;
        viernes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!v){
                    viernes.setBackgroundColor(selectedColor);
                    v = true;
                }else{
                    viernes.setBackgroundColor(defaultColor);
                    v = false;
                }
            }
        });

        assert sabado != null;
        sabado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!s){
                    sabado.setBackgroundColor(selectedColor);
                    s = true;
                }else{
                    sabado.setBackgroundColor(defaultColor);
                    s = false;
                }
            }
        });

        assert domingo != null;
        domingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!d){
                    domingo.setBackgroundColor(selectedColor);
                    d = true;
                }else{
                    domingo.setBackgroundColor(defaultColor);
                    d = false;
                }
            }
        });





    }
}
