package com.example.gibo.assingment2_2;

import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FrameLayout fl1;
    Switch s1;
    TimePicker tp1;
    DatePicker dp1;
    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    EditText et1,et2,et3;
    Button b1,b2;
    GridLayout gl1,gl2;
    Chronometer cm1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1 = (Switch)findViewById(R.id.s1);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(s1.isChecked()) {
                   start();
               }
                else if(!(s1.isChecked())){
                   reset();
               }
            }
        });

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }


    public void onClick(View v){

        switch (v.getId()){
            case R.id.b1 :
                back();
                break;
            case R.id.b2 :
                next();
                break;
        }
    }

    private void start(){

        fl1 = (FrameLayout)findViewById(R.id.fl1);
        dp1 = (DatePicker)findViewById(R.id.dp1);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        cm1 = (Chronometer)findViewById(R.id.chronometer2);
        tv1 = (TextView)findViewById(R.id.tv1);

        tv1.setVisibility(View.VISIBLE);
        cm1.setVisibility(View.VISIBLE);
        cm1.start();
        fl1.setVisibility(View.VISIBLE);
        dp1.setVisibility(View.VISIBLE);
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b1.setEnabled(false);
        b2.setEnabled(true);
    }

    private void reset(){
        fl1 = (FrameLayout)findViewById(R.id.fl1);
        tp1 = (TimePicker)findViewById(R.id.tp1);
        dp1 = (DatePicker)findViewById(R.id.dp1);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);
        tv6 = (TextView)findViewById(R.id.tv6);
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        et3 = (EditText)findViewById(R.id.et3);
        gl1 = (GridLayout)findViewById(R.id.gl1);
        gl2 = (GridLayout)findViewById(R.id.gl2);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        cm1 = (Chronometer)findViewById(R.id.chronometer2);
        tv1 = (TextView)findViewById(R.id.tv1);

        tv1.setVisibility(View.INVISIBLE);
        cm1.setVisibility(View.INVISIBLE);
        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        fl1.setVisibility(View.INVISIBLE);
        tp1.setVisibility(View.INVISIBLE);
        dp1.setVisibility(View.INVISIBLE);
        gl1.setVisibility(View.INVISIBLE);
        gl2.setVisibility(View.INVISIBLE);
        tv4.setText("");
        tv5.setText("");
        tv6.setText("");
        et1.setText("");
        et2.setText("");
        et3.setText("");
        cm1.setBase(SystemClock.elapsedRealtime());
    }

    private void back(){

        tp1 = (TimePicker)findViewById(R.id.tp1);
        dp1 = (DatePicker)findViewById(R.id.dp1);
        gl1 = (GridLayout)findViewById(R.id.gl1);
        gl2 = (GridLayout)findViewById(R.id.gl2);


        if(tp1.getVisibility() == View.VISIBLE){
            b1.setEnabled(false);
            dp1.setVisibility(View.VISIBLE);
            tp1.setVisibility(View.INVISIBLE);
        }
        else if(gl1.getVisibility() == View.VISIBLE){
            tp1.setVisibility(View.VISIBLE);
            gl1.setVisibility(View.INVISIBLE);
        }
        else if(gl2.getVisibility() == View.VISIBLE){
            b2.setEnabled(true);
            gl1.setVisibility(View.VISIBLE);
            gl2.setVisibility(View.INVISIBLE);
        }
    }

    private void next(){

        tp1 = (TimePicker)findViewById(R.id.tp1);
        dp1 = (DatePicker)findViewById(R.id.dp1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);
        tv6 = (TextView)findViewById(R.id.tv6);
        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        et3 = (EditText)findViewById(R.id.et3);
        gl1 = (GridLayout)findViewById(R.id.gl1);
        gl2 = (GridLayout)findViewById(R.id.gl2);


        if(dp1.getVisibility() == View.VISIBLE){
            b1.setEnabled(true);
            tv2.setText(dp1.getYear()+"년"+dp1.getMonth()+"월"+dp1.getDayOfMonth()+"일");
            dp1.setVisibility(View.INVISIBLE);
            tp1.setVisibility(View.VISIBLE);
        }
        else if(tp1.getVisibility() == View.VISIBLE){
            tp1.setVisibility(View.INVISIBLE);
            tv3.setText(tp1.getCurrentHour()+"시"+tp1.getCurrentMinute()+"분");
            gl1.setVisibility(View.VISIBLE);
        }
        else if(gl1.getVisibility() == View.VISIBLE){


            b2.setEnabled(false);
            gl1.setVisibility(View.INVISIBLE);
            tv4.setText(et1.getText()+"명");
            tv5.setText(et2.getText()+"명");
            tv6.setText(et3.getText()+"명");
            gl2.setVisibility(View.VISIBLE);
        }
    }

    private void time(){

    }

}
