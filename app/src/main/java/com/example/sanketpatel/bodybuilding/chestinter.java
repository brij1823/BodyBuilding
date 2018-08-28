package com.example.sanketpatel.bodybuilding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class chestinter extends AppCompatActivity {
     String name[];
     int imag[]={R.drawable.jumping,R.drawable.push,R.drawable.knee,R.drawable.wide,R.drawable.hindu,R.drawable.staggered,R.drawable.pushrotation,R.drawable.knee,R.drawable.decline,R.drawable.staggered,R.drawable.cobra,R.drawable.cheststretch};
     private AdView adView;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chestinter);
        MobileAds.initialize(this, "ca-app-pub-6688416996043939~5524133545");
        name=getResources().getStringArray(R.array.ichest);
        ListView l=(ListView) findViewById(R.id.listview);
        Context context=this;
         adView=(AdView) findViewById(R.id.adView);
         AdRequest adRequest=new AdRequest.Builder().build();
         adView.loadAd(adRequest);

         MyAdapter myAdapter=new MyAdapter(context,name,imag,0);
        l.setAdapter(myAdapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        Intent i1=new Intent(chestinter.this,jj.class);
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2=new Intent(chestinter.this,aa.class);
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3=new Intent(chestinter.this,cc.class);
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4=new Intent(chestinter.this,dd.class);
                        startActivity(i4);
                        break;
                    case 4:
                        Intent i5=new Intent(chestinter.this,ff.class);
                        startActivity(i5);
                        break;
                    case 5:
                        Intent i6=new Intent(chestinter.this,staggered.class);
                        startActivity(i6);
                        break;
                    case 6:
                        Intent i7=new Intent(chestinter.this,pushuprotation.class);
                        startActivity(i7);
                        break;
                    case 7:
                        Intent i8=new Intent(chestinter.this,cc.class);
                        startActivity(i8);
                        break;
                    case 8:
                        Intent i9=new Intent(chestinter.this,decline.class);
                        startActivity(i9);
                        break;
                    case 9:
                        Intent i10=new Intent(chestinter.this,staggered.class);
                        startActivity(i10);
                        break;
                    case 10:
                        Intent i11=new Intent(chestinter.this,gg.class);
                        startActivity(i11);
                        break;
                    case 11:
                        Intent i12=new Intent(chestinter.this,hh.class);
                        startActivity(i12);
                        break;
                }
            }
        });
    }


}
