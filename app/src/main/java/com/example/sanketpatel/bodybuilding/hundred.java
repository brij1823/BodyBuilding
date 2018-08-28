package com.example.sanketpatel.bodybuilding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class hundred extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hundred);
        ImageButton i1=(ImageButton) findViewById(R.id.fullbody);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(hundred.this,weightloss.class);
                startActivity(i);
            }
        });
    }
}
