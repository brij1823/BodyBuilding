package com.example.sanketpatel.bodybuilding;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class dloss extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    TextView e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dloss);
        CheckBox c=(CheckBox) findViewById(R.id.checkBox);
        CheckBox c1=(CheckBox) findViewById(R.id.checkBox1);
         e=(TextView) findViewById(R.id.budget);
        SeekBar s1=(SeekBar) findViewById(R.id.seekBar);
        s1.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        final Toast toast = Toast.makeText(getApplicationContext()," "+i, Toast.LENGTH_SHORT);
        toast.show();
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        },500);
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
