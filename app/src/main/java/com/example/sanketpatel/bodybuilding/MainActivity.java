package com.example.sanketpatel.bodybuilding;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
      private  static int splash=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // final SharedPreferences sharedPreferences=getSharedPreferences("today",MODE_PRIVATE);
        //final boolean b = sharedPreferences.getBoolean("isLogin", false);
        //if(!b){
        new Handler().postDelayed(new Runnable() {
            @Override

            public void run() {
                Intent i=new Intent(MainActivity.this,Loginn.class);
                startActivity(i);
                finish();
            }
        },splash);
    //}
        //else{
//            new Handler().postDelayed(new Runnable() {
//                @Override
//
//                public void run() {
//                    Intent i=new Intent(MainActivity.this,excercise.class);
//                    startActivity(i);
//                    finish();
//                }
//            },splash);
//    //}

    }

    }

