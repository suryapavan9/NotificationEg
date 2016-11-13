package com.example.android.notificationeg;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3;
    NotificationCompat.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //All notifications are under notification manager
        final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //we will display new notification
                builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setTicker("1 mail");
                builder.setContentTitle("Job");
                //setting large icon
                BitmapDrawable d = (BitmapDrawable) getResources().getDrawable(R.drawable.googleplus);
                builder.setLargeIcon(d.getBitmap());
                builder.setContentText("Urgent opening in intel.plz send ur resume");
                builder.setContentInfo("1 unread");
                builder.setAutoCancel(true);    //once user clicks remove notification
                //prepare intent to start same activity

                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent p = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                builder.setContentIntent(p);

                //Request notification manager to display notification
                notificationManager.notify(1,builder.build());
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //we wll display updated existing notification
                //builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setTicker("urgent");
                builder.setContentTitle("from home");
                builder.setContentText("send money immediately");
                notificationManager.notify(1,builder.build());
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //we will delete the particular notification
                notificationManager.cancel(1);  //removes 1st notification from area
            }
        });
    }
}
