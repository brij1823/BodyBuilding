package com.example.sanketpatel.bodybuilding;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class circuitchallenge extends AppCompatActivity {
        String names[];
        String names2[];
        int img[]={R.drawable.golf,R.drawable.silver,R.drawable.bronze};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuitchallenge);
        ListView l=(ListView) findViewById(R.id.view);
        ListView l2=(ListView) findViewById(R.id.view2);
        names=getResources().getStringArray(R.array.toppers);
        names2=getResources().getStringArray(R.array.top);
        Context context=this;
        MyAdapter myAdapter=new MyAdapter(context,names,img,1);
        l.setAdapter(myAdapter);
       // ArrayAdapter arrayAdapter=new ArrayAdapter(circuitchallenge.this,R.layout.activity_medalist,R.id.head1,R.array.top);
        ArrayAdapter arrayAdapter = new ArrayAdapter(circuitchallenge.this, R.layout.design, R.id.write, names2);
        l2.setAdapter(arrayAdapter);



    }
}
