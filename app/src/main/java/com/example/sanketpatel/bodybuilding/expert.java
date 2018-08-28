package com.example.sanketpatel.bodybuilding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class expert extends AppCompatActivity {
    String name[];
    int images[]={R.drawable.jumping,R.drawable.arms,R.drawable.diamond,R.drawable.burpee,R.drawable.hindu,R.drawable.staggered,R.drawable.pushrotation,R.drawable.spider,R.drawable.staggered,R.drawable.decline,R.drawable.cobra,R.drawable.cheststretch};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert);
        name=getResources().getStringArray(R.array.echest);
        ListView l=(ListView) findViewById(R.id.listview1);
        Context context=this;
        MyAdapter myAdapter=new MyAdapter(context,name,images,0);
        l.setAdapter(myAdapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        Intent i1=new Intent(expert.this,jj.class);
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2=new Intent(expert.this,arm.class);
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3=new Intent(expert.this,diamond.class);
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4=new Intent(expert.this,burpees.class);
                        startActivity(i4);
                        break;
                    case 4:
                        Intent i5=new Intent(expert.this,ff.class);
                        startActivity(i5);
                        break;
                    case 5:
                        Intent i6=new Intent(expert.this,staggered.class);
                        startActivity(i6);
                        break;
                    case 6:
                        Intent i7=new Intent(expert.this,pushuprotation.class);
                        startActivity(i7);
                        break;
                    case 7:
                        Intent i8=new Intent(expert.this,spider.class);
                        startActivity(i8);
                        break;
                    case 8:
                        Intent i9=new Intent(expert.this,staggered.class);
                        startActivity(i9);
                        break;
                    case 9:
                        Intent i10=new Intent(expert.this,decline.class);
                        startActivity(i10);
                        break;
                    case 10:
                        Intent i11=new Intent(expert.this,gg.class);
                        startActivity(i11);
                        break;
                    case 11:
                        Intent i12=new Intent(expert.this,hh.class);
                        startActivity(i12);
                        break;
                }
                
            }
        });


        


    }
}
