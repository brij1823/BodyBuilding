package com.example.sanketpatel.bodybuilding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class chest extends AppCompatActivity {
         String name[];
         int images[]={R.drawable.jumping,R.drawable.incline,R.drawable.push,R.drawable.knee,R.drawable.wide,R.drawable.push,R.drawable.hindu,R.drawable.cobra,R.drawable.cheststretch};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activi  ty_chest);
        name=getResources().getStringArray(R.array.bchest);
        ListView l=(ListView) findViewById(R.id.listview);
        Context context=this;
        MyAdapter myAdapter=new MyAdapter(context,name,images,0);
        l.setAdapter(myAdapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    switch(i){
                        case 0:
                            Intent i1=new Intent(chest.this,jj.class);
                            startActivity(i1);
                            break;
                        case 1:
                            Intent i2=new Intent(chest.this,aa.class);
                            startActivity(i2);
                            break;
                        case 2:
                            Intent i3=new Intent(chest.this,bb.class);
                            startActivity(i3);
                            break;
                        case 3:
                            Intent i4=new Intent(chest.this,cc.class);
                            startActivity(i4);
                            break;
                        case 4:
                            Intent i5=new Intent(chest.this,dd.class);
                            startActivity(i5);
                            break;
                        case 5:
                            Intent i6=new Intent(chest.this,ee.class);
                            startActivity(i6);
                            break;
                        case 6:
                            Intent i7=new Intent(chest.this,ff.class);
                            startActivity(i7);
                            break;
                        case 7:
                            Intent i8=new Intent(chest.this,gg.class);
                            startActivity(i8);
                            break;
                        case 8:
                            Intent i9=new Intent(chest.this,hh.class);
                            startActivity(i9);
                            break;
                    }

            }
        });
    }
}
