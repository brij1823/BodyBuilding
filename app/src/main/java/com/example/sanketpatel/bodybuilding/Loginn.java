package com.example.sanketpatel.bodybuilding;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Loginn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginn);
        Typeface t=Typeface.createFromAsset(getAssets(),"fonts/time.ttf");
        TextView t1=(TextView) findViewById(R.id.login);
        TextInputEditText t2=(TextInputEditText) findViewById(R.id.user);
        TextInputEditText t3=(TextInputEditText) findViewById(R.id.pass);
        t1.setTypeface(t);
        t2.setTypeface(t);
        t3.setTypeface(t);
        Button b2=(Button) findViewById(R.id.butt);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Loginn.this,excercise.class);
                startActivity(i);
                finish();
                //                SharedPreferences.Editor editor=sharedPreferences.edit();
                //                editor.putBoolean("isLogin",true).apply();
                //
                //                startActivity(i);
            }
        });
    }
}
