package com.example.sanketpatel.bodybuilding;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
        TextView t=(TextView) findViewById(R.id.text0);
        Typeface t3=Typeface.createFromAsset(getAssets(),"fonts/time.ttf");
        t.setTypeface(t3);

    }
}
