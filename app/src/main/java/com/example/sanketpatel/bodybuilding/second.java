package com.example.sanketpatel.bodybuilding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class second extends AppCompatActivity {
    Button i1;
    ImageButton z;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        i1=(Button) findViewById(R.id.loss);
        Button i2=(Button) findViewById(R.id.gain);
        Button i3=(Button) findViewById(R.id.built);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(second.this,loss.class);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(second.this,gain.class);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(second.this,built.class);
            }
        });

    }
}
