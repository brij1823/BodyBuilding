package com.example.sanketpatel.bodybuilding;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Forms extends AppCompatActivity {
    private ImageButton img;
    EditText name,address,city,state,phone,email,membership,year1,detail1,year2,detail2,year3,detail3,cond1,rest1,cond2,rest2,cond3,rest3;
    private static final int gallery=1;
    private Uri uri=null;
    private StorageReference storageReference=null;
    private DatabaseReference mRef;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);
         name=(EditText) findViewById(R.id.name);
        address=(EditText) findViewById(R.id.address);
        city=(EditText) findViewById(R.id.city);
        state=(EditText) findViewById(R.id.state);
        phone=(EditText) findViewById(R.id.phone);
        email=(EditText) findViewById(R.id.email);
        membership=(EditText) findViewById(R.id.membership);
        year1=(EditText) findViewById(R.id.year1);
        detail1=(EditText) findViewById(R.id.detail1);
        year2=(EditText) findViewById(R.id.year2);
        year3=(EditText) findViewById(R.id.year3);
        detail3=(EditText) findViewById(R.id.detail3);
        cond1=(EditText) findViewById(R.id.cond1);
        rest1=(EditText) findViewById(R.id.rest1);
        cond2=(EditText) findViewById(R.id.cond2);
        rest2=(EditText) findViewById(R.id.rest2);
        cond3=(EditText) findViewById(R.id.cond3);
        rest3=(EditText) findViewById(R.id.rest3);
        detail2=(EditText) findViewById(R.id.detail2);
        storageReference= FirebaseStorage.getInstance().getReference("pics");
        mRef=FirebaseDatabase.getInstance().getReference("item");


    }

    public void clickhere(View view)
    {
//        Intent i=new Intent(Intent.ACTION_GET_CONTENT);
//        i.setType("Image/*");
//        startActivityForResult(i,gallery);
        Intent i = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i,1);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==gallery && resultCode==RESULT_OK)
        {
            
            uri=data.getData();
            img=(ImageButton) findViewById(R.id.images);
            img.setImageURI(uri);
        }
    }
    public void add(View view)
    {
        final String Name=name.getText().toString().trim();
        final String description=address.getText().toString().trim();
        final String City=city.getText().toString().trim();
        final String State=state.getText().toString().trim();
        final String Phone=phone.getText().toString().trim();
        final String Email=email.getText().toString().trim();
        final String Membership=membership.getText().toString().trim();
        StorageReference filepath=storageReference.child(uri.getLastPathSegment());
        filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                final Uri downloadurl =taskSnapshot.getDownloadUrl();
                Toast.makeText(Forms.this,"Form submitted",Toast.LENGTH_LONG).show();
                final DatabaseReference newPost=mRef.push();
                newPost.child("name").setValue(Name);
                newPost.child("desc").setValue(description);
                newPost.child("value").setValue(City);
                newPost.child("value").setValue(State);
                newPost.child("value").setValue(Phone);
                newPost.child("value").setValue(Email);
                newPost.child("value").setValue(Membership);
                newPost.child("image").setValue(downloadurl.toString());
          sendNotification();



            }
        });
    }
    private void sendNotification()
    {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                int SDK_INT = android.os.Build.VERSION.SDK_INT;
                if (SDK_INT > 8) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    String send_email;

                    //This is a Simple Logic to Send Notification different Device Programmatically....
                    send_email="1";

                    try {
                        String jsonResponse;

                        URL url = new URL("https://onesignal.com/api/v1/notifications");
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setUseCaches(false);
                        con.setDoOutput(true);
                        con.setDoInput(true);

                        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                        con.setRequestProperty("Authorization", "Basic NTg1NTUxZWEtN2FmOS00YzhiLWJlNTYtODU4OWMzNWI1NzQ3");
                        con.setRequestMethod("POST");

                        String strJsonBody = "{"
                                + "\"app_id\": \"d46906f6-bddc-4832-9d36-7c838f703a0b\","

                                + "\"filters\": [{\"field\": \"tag\", \"key\": \"user_id\", \"relation\": \"=\", \"value\": \"" + send_email + "\"}],"

                                + "\"data\": {\"foo\": \"bar\"},"
                                + "\"contents\": {\"en\": \"English Message\"}"
                                + "}";


                        System.out.println("strJsonBody:\n" + strJsonBody);

                        byte[] sendBytes = strJsonBody.getBytes("UTF-8");
                        con.setFixedLengthStreamingMode(sendBytes.length);

                        OutputStream outputStream = con.getOutputStream();
                        outputStream.write(sendBytes);

                        int httpResponse = con.getResponseCode();
                        System.out.println("httpResponse: " + httpResponse);

                        if (httpResponse >= HttpURLConnection.HTTP_OK
                                && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
                            Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                            scanner.close();
                        } else {
                            Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                            scanner.close();
                        }
                        System.out.println("jsonResponse:\n" + jsonResponse);

                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }
        });
    }
}
