package com.example.sanketpatel.bodybuilding;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * Created by Sanket Patel on 17-12-2017.
 */

public class BlankFragment extends Fragment  {
    int var;
    public Button button;
    Activity a;
    @SuppressLint("ValidFragment")
    public BlankFragment(int i, Activity excercise){
        var=i; a = excercise;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(var==0) {
            final View view = inflater.inflate(R.layout.activity_hundred, container, false);

            ImageButton button = (ImageButton) view.findViewById(R.id.fullbody);
            ImageButton button1 = (ImageButton) view.findViewById(R.id.chesty);
            ImageButton button2 = (ImageButton) view.findViewById(R.id.chesti);
            ImageButton button3 = (ImageButton) view.findViewById(R.id.echest);
            ImageButton button4 = (ImageButton) view.findViewById(R.id.abs);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {

                        case R.id.fullbody:
                            Intent intent1 = new Intent(a, Full.class);
                            startActivity(intent1);//Edited here
                            break;

                    }
                }
            });

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.chesty:
                            Intent intent2 = new Intent(a, chest.class);
                            startActivity(intent2);//Edited here
                            break;

                    }
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.chesti:
                            Intent intent2 = new Intent(a, chestinter.class);
                            startActivity(intent2);//Edited here
                            break;

                    }
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.echest:
                            Intent i=new Intent(a,expert.class);
                            startActivity(i);
                            break;
                    }
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.abs:
                            Intent i=new Intent(a,babs.class);
                            startActivity(i);
                            break;
                    }
                }
            });



            return view;
        }

        else if(var==1){
            View view = inflater.inflate(R.layout.activity_second, container, false);

            Button button = (Button) view.findViewById(R.id.loss);
            Button button1 = (Button) view.findViewById(R.id.gain);
            Button button2 = (Button) view.findViewById(R.id.built);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {

                        case R.id.loss:
                            Intent intent1 = new Intent(a, loss.class);
                            startActivity(intent1);//Edited here
                            break;

                    }
                }
            });

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.gain:
                            Intent intent2 = new Intent(a, gain.class);
                            startActivity(intent2);//Edited here
                            break;

                    }
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.built:
                            Intent intent2 = new Intent(a, built.class);
                            startActivity(intent2);//Edited here
                            break;

                    }
                }
            });


            return view;}
        else if(var==5){
            //return inflater.inflate(R.layout.activity_delete, container, false);
            Intent i=new Intent(getActivity(),gallery.class);
            startActivity(i);
        }

        else if(var==3){
            final View view = inflater.inflate(R.layout.activity_suces, container, false);
            final ImageSwitcher imageSwitcher;
            ImageButton next;
            ImageButton previous;

            imageSwitcher=(ImageSwitcher) view.findViewById(R.id.switcher);
            next=(ImageButton) view.findViewById(R.id.next);
            previous=(ImageButton) view.findViewById(R.id.previous);

            imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
                @Override
                public View makeView() {
                    ImageView imageView=new ImageView(getActivity().getApplicationContext());
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
            return view;

        }

        else if(var==6){
            final View view = inflater.inflate(R.layout.activity_leaderboard, container, false);
            Typeface t=Typeface.createFromAsset(getActivity().getAssets(),"fonts/pord.ttf");
            TextView t1=(TextView) view.findViewById(R.id.wrote);
            t1.setTypeface(t);
            Button b1=(Button) view.findViewById(R.id.bu1);
            b1.setTypeface(t);
            Button b2=(Button) view.findViewById(R.id.bu2);
            b2.setTypeface(t);
            Button b3=(Button) view.findViewById(R.id.bu3);
            b3.setTypeface(t);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(getActivity(),circuitchallenge.class);
                    startActivity(i);
                }
            });

            return view;
        }
        else if(var==7){
            //final View view = inflater.inflate(R.layout.activity_forms, container, false);
            //return view;
            Intent i=new Intent(getActivity(),Forms.class);
            startActivity(i);

        }

        return null;
         }




}



