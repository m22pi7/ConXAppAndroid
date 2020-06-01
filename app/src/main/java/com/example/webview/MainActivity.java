package com.example.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.app.NotificationManager;
import android.app.NotificationChannel;

import android.app.Notification;

import android.app.PendingIntent;

import android.content.Intent;

import android.graphics.BitmapFactory;

import android.os.Build;

import android.os.Bundle;

import android.util.Log;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.RelativeLayout;

import android.widget.Spinner;

import android.widget.TextView;



import com.google.android.material.snackbar.Snackbar;



import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.NotificationCompat;

import androidx.core.app.NotificationCompat.Action;

import androidx.core.app.NotificationCompat.BigPictureStyle;

import androidx.core.app.NotificationCompat.BigTextStyle;

import androidx.core.app.NotificationCompat.InboxStyle;

import androidx.core.app.NotificationCompat.MessagingStyle;

import androidx.core.app.NotificationManagerCompat;

import androidx.core.app.Person;

import androidx.core.app.RemoteInput;

import androidx.core.app.TaskStackBuilder;

import androidx.core.content.ContextCompat;


import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;

        import com.example.webview.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {
    private final String CHANNEL_ID = "personal_notifications";
    private final int NOTIFICATION_ID = 001;

    private Button button;

    public void onCreate(Bundle savedInstanceState) {
        final Context context = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        button = (Button) findViewById(R.id.buttonUrl);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, WebViewActivity.class);
                startActivity(intent);
                displayNotification(arg0);
            }
        });
    }

    public void displayNotification(View view) {

        createNotificationChannel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_sms_notification);
        builder.setContentTitle("Con-X");
        builder.setContentText("There is a potential hotspot in your area!");
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }


    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Personal Notifications";
            String description = "Con-X notification system";
            int importance = NotificationManager.IMPORTANCE_HIGH;


            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);


            notificationChannel.setDescription(description);


            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            notificationManager.createNotificationChannel(notificationChannel);

        }
    }
}