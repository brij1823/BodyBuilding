package com.example.sanketpatel.bodybuilding;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class loss extends AppCompatActivity {
     private static int splash=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loss);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(loss.this,dloss.class);
                startActivity(i);
            }
        },splash);
    }
}
