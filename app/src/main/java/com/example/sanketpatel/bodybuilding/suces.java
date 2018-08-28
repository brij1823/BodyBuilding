package com.example.sanketpatel.bodybuilding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class suces extends AppCompatActivity {

    private ImageSwitcher imageSwitcher;
    private ImageButton next;
    private ImageButton previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suces);
         imageSwitcher=(ImageSwitcher) findViewById(R.id.switcher);
         next=(ImageButton) findViewById(R.id.next);
         previous=(ImageButton) findViewById(R.id.previous);
         
         imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
             @Override
             public View makeView() {
                 ImageView imageView=new ImageView(getApplicationContext());
                 imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                 return imageView;
             }
         });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageSwitcher.setImageResource(R.drawable.weightloss);
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageSwitcher.setImageResource(R.drawable.lchesti);
            }
        });


    }
}
