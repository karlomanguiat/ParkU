package com.example.parku;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class NotificationActivity extends Activity {
    private TextView building;
    private TextView totalSlots;
    private TextView availableSlots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_activity);

        building = (TextView) findViewById(R.id.buildingID);
        totalSlots = (TextView) findViewById(R.id.totalSpaceID);
        availableSlots = (TextView) findViewById(R.id.availableSpaceID);
    }
}