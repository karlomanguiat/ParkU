package com.example.parku;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

public class ParkingDetailsActivity extends AppCompatActivity {

    private static final String TAG = ParkingDetailsActivity.class.getName();
    private String url="http://localhost/try.php";
    private RequestQueue rq;
    private StringRequest stringGET, stringPOST;
    private TextView building;
    private TextView totalSlots;
    private TextView availableSlots;
    String id;
    private MobileClient client;
    public String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_details);

        building = (TextView) findViewById(R.id.buildingID);
        totalSlots = (TextView) findViewById(R.id.totalSpaceID);
        availableSlots = (TextView) findViewById(R.id.availableSpaceID);
        id = getIntent().getExtras().getString("id");


        client = (MobileClient) new MobileClient(new MobileClient.AsyncResponse() {
            @Override
            public void processFinish(String output) {
                response = output;
                availableSlots.setText(response);
            }
        }, id).execute();
        setup();
    }

    private void setup() {
        if (id.equals("1")) {
            building.setText("Department of Computer Science (Faculty)");
            totalSlots.setText("14");
            availableSlots.setText("0");
        }
        if (id.equals("2")) {
            building.setText("Department of Computer Science (Students)");
            totalSlots.setText("18");
            availableSlots.setText("0");
        }
        else if (id.equals("3")) {
            building.setText("National Institue of Geological Sciences");
            totalSlots.setText("30");
            availableSlots.setText("0");
        }
        else if (id.equals("4")) {
            building.setText("Institute of Mathematics");
            totalSlots.setText("48");
            availableSlots.setText("0");
        }
        else {

        }
    }
}
