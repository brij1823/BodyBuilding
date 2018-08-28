package com.example.sanketpatel.bodybuilding;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class gallery extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
     ImageButton photoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        imageView = (ImageView) findViewById(R.id.imageView1);
        photoButton = (ImageButton) findViewById(R.id.button1);
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(gallery.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(gallery.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                    requestCameraPermission();
                }
                else{
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);}
            }
        });
    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(this,new String []{Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE},2);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==2){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED){
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);

            }
            else{
                Toast.makeText(gallery.this,"This request is necessary to go ahead",Toast.LENGTH_LONG).show();
            }

        }
        if(requestCode==1){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                try {
                    getImage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                Toast.makeText(gallery.this,"This request is necessary to go ahead",Toast.LENGTH_LONG).show();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            Toast.makeText(gallery.this,"Image Saved",Toast.LENGTH_SHORT).show();
            imageView.setImageBitmap(photo);
            try {
                getImage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(this,new String []{Manifest.permission.READ_EXTERNAL_STORAGE},1);

    }

    public void getImage() throws IOException {
        BitmapDrawable draw = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = draw.getBitmap();

        FileOutputStream outStream = null;
        File sdCard = Environment.getExternalStorageDirectory();
        File dir = new File(sdCard.getAbsolutePath() + "/BodyBuilding");
        dir.mkdirs();
        String fileName = String.format("%d.png", System.currentTimeMillis());
        File outFile = new File(dir, fileName);
        outStream = new FileOutputStream(outFile);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
        outStream.flush();
       outStream.close();
//        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//        intent.setData(Uri.fromFile(file));
//        sendBroadcast(intent);
    }
}
