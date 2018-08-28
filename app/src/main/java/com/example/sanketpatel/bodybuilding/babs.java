package com.example.sanketpatel.bodybuilding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class babs extends AppCompatActivity {
             String name[];
             int img[]={R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_babs);
        name=getResources().getStringArray(R.array.abs);
        ListView l=(ListView) findViewById(R.id.listview);
        Context context=this;
        MyAdapter myAdapter=new MyAdapter(context,name,img,0);
        l.setAdapter(myAdapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        Intent i1=new Intent(babs.this,timer.class);
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2=new Intent(babs.this,aa.class);
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3=new Intent(babs.this,cc.class);
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4=new Intent(babs.this,dd.class);
                        startActivity(i4);
                        break;
                    case 4:
                        Intent i5=new Intent(babs.this,ff.class);
                        startActivity(i5);
                        break;
                    case 5:
                        Intent i6=new Intent(babs.this,staggered.class);
                        startActivity(i6);
                        break;
                    case 6:
                        Intent i7=new Intent(babs.this,pushuprotation.class);
                        startActivity(i7);
                        break;
                    case 7:
                        Intent i8=new Intent(babs.this,cc.class);
                        startActivity(i8);
                        break;
                }
            }
        });
    }
}
