package com.example.sanketpatel.bodybuilding;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class timer extends AppCompatActivity {
     private int sec;
     private boolean running,wasrunning;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        if(savedInstanceState!=null){
               sec=savedInstanceState.getInt("sec");
               running=savedInstanceState.getBoolean("running");
        }
        runtimer();
        Button b1=(Button) findViewById(R.id.start);
        Button b2=(Button) findViewById(R.id.pause);
        Button b3=(Button) findViewById(R.id.reset);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer(view);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTimer(view);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer(view);
            }
        });
    }
    public void startTimer(View view)
    {
         running=true;
    }
    public void stopTimer(View view)
    {
        running=false;
    }
    public void resetTimer(View view)
    {
        running=false;
        sec=0;
    }
    public void runtimer()
    {
        int min,hrs;

        final TextView  t=(TextView) findViewById(R.id.write);
        final Handler hand=new Handler();
        hand.post(new Runnable() {
            @Override
            public void run() {
                 int mili,second,min,hrs;
                 mili=sec%100;
                 second=(sec%3600)/60;
                 min=sec/3600;
                 hrs=min/60;
                 if(min==1){

                     MediaPlayer m=MediaPlayer.create(context,R.raw.ting);
                     m.start();
                     


                 }
                 if(min<1) {
                     String time = String.format("%d :%d :%d :%d", hrs, min, second, mili);
                     t.setText(time);
                 }
                 if(running)sec++;
                 hand.postDelayed(this,1);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Sec :", sec);
        outState.putBoolean("Running :", running);
        outState.putBoolean("wasRunning :", wasrunning);

    }
    public void onStop()
    {
        super.onStop();
        wasrunning=running;
        running=false;
    }

    public void onStart()
    {
        super.onStart();
        if(wasrunning)
            running=false;
    }
}
