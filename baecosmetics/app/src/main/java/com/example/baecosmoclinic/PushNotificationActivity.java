package com.example.baecosmoclinic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.baecosmoclinic.AppChannel.CHANNEL_1_ID;

public class PushNotificationActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;
    private EditText title;
    private EditText desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notification);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        title = findViewById(R.id.notificationTitle);
        desc = findViewById(R.id.notificationDesc);

    }


    public void sendNotication(View view) {

        String eTitle = title.getText().toString();
        String eDesc = desc.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                .setContentTitle(eTitle)
                .setContentText(eDesc)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1, notification);
    }

    public void saveToDatabase(String title, String desc) {

    }
}
