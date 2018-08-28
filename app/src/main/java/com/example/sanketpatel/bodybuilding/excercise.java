package com.example.sanketpatel.bodybuilding;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.onesignal.OneSignal;

public class excercise extends AppCompatActivity {
    String country[];
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawar);
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        final TextView t = (TextView) findViewById(R.id.text0);
        FragmentManager f = getFragmentManager();
        FragmentTransaction te = f.beginTransaction();
        Fragment t23 = new BlankFragment(0, this);
        te.replace(R.id.twister, t23);
        te.commit();
        Typeface t3 = Typeface.createFromAsset(getAssets(), "fonts/time.ttf");
        t.setTypeface(t3);
        final DrawerLayout d = (DrawerLayout) findViewById(R.id.drawer);
        Toolbar t2 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t2);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, d, t2, R.string.open, R.string.close);
        d.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        ListView n = (ListView) findViewById(R.id.navigate);
        country = getResources().getStringArray(R.array.country);
        ArrayAdapter arrayAdapter = new ArrayAdapter(excercise.this, R.layout.design, R.id.write, country);
        n.setAdapter(arrayAdapter);
        final Activity a = this;
        n.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    FragmentManager f = getFragmentManager();
                    FragmentTransaction te = f.beginTransaction();
                    Fragment t2 = new BlankFragment(0,a);
                    te.replace(R.id.twister, t2);
                    te.commit();
                }
                if (i == 1) {
                    FragmentManager f = getFragmentManager();
                    FragmentTransaction te = f.beginTransaction();
                    Fragment t2 = new BlankFragment(1, a);
                    te.replace(R.id.twister, t2);
                    te.commit();
                }
                if (i == 3) {
                    FragmentManager f = getFragmentManager();
                    FragmentTransaction te = f.beginTransaction();
                    Fragment t2 = new BlankFragment(3, a);
                    te.replace(R.id.twister, t2);
                    te.commit();
                }
                if (i == 5) {
                    FragmentManager f = getFragmentManager();
                    FragmentTransaction te = f.beginTransaction();
                    Fragment t2 = new BlankFragment(5, a);
                    te.replace(R.id.twister, t2);
                    te.commit();
                }

                if(i==6){
                    FragmentManager f = getFragmentManager();
                    FragmentTransaction te = f.beginTransaction();
                    Fragment t2 = new BlankFragment(6, a);
                    te.replace(R.id.twister, t2);
                    te.commit();

                }
                if(i==7){
                    FragmentManager f = getFragmentManager();
                    FragmentTransaction te = f.beginTransaction();
                    Fragment t2 = new BlankFragment(7, a);
                    te.replace(R.id.twister, t2);
                    te.commit();

                }
                d.closeDrawer(GravityCompat.START);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.alog) {
            Intent i3 = new Intent(excercise.this, Loginn.class);
            startActivity(i3);
        }
        if(i==R.id.contact){
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:9825745666"));
            startActivity(callIntent);


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        showDialog().show();
    }

    private AlertDialog showDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(excercise.this);

        builder.setIcon(R.drawable.dumble).setMessage("Are you sure want to exit?")
                .setCancelable(false)
                .setTitle("Exit")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        return builder.create();

    }
}
