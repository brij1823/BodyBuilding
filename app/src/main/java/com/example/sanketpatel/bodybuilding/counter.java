package com.example.sanketpatel.bodybuilding;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class counter extends AppCompatActivity implements SensorEventListener {
    private Sensor mysensor;
    private SensorManager sm;
    static int count=0;
    TextView t;
    MediaPlayer m;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        t=(TextView) findViewById(R.id.write);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        mysensor=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        context=this;
        m=MediaPlayer.create(context,R.raw.ting);

    }
    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,mysensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(mysensor.getType()==Sensor.TYPE_PROXIMITY){
            t.setText(" " +count);
            if(sensorEvent.values[0]==100){
                count++;
               m.start();

            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
