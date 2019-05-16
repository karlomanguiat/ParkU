package com.example.parku;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private CardView dcsView, nigsView, mathView, enggView;
    private Intent i ;
    private PendingIntent broadcast;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //FloatingActionButton fab = findViewById(R.id.fab);

        final Intent notificationIntent = new Intent(MainActivity.this, AlarmReceiver.class);

        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        final Calendar cal = Calendar.getInstance();

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent notificationIntent = new Intent(this, AlarmReceiver.class);
                broadcast = PendingIntent.getBroadcast(MainActivity.this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                //Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 240);
                //alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), (AlarmManager.INTERVAL_FIFTEEN_MINUTES / 5) + 1, broadcast);
            }
        });

        dcsView = (CardView) findViewById(R.id.dcsID);
        dcsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(MainActivity.this, ParkingDetailsActivity.class);
                k.putExtra("id","1");
                startActivity(k);
            }
        });

        enggView = (CardView) findViewById(R.id.enggID);
        enggView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(MainActivity.this, ParkingDetailsActivity.class);
                k.putExtra("id","2");
                startActivity(k);
            }
        });

        nigsView = (CardView) findViewById(R.id.nigsID);
        nigsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(MainActivity.this, ParkingDetailsActivity.class);
                k.putExtra("id","3");
                startActivity(k);
            }
        });

        mathView = (CardView) findViewById(R.id.mathID);
        mathView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(MainActivity.this, ParkingDetailsActivity.class);
                k.putExtra("id","4");
                startActivity(k);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
