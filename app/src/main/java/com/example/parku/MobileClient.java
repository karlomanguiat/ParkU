package com.example.parku;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class MobileClient extends AsyncTask<Void, Void, String> {

    String parkingLot;
    // you may separate this or combined to caller class.
    public interface AsyncResponse {
        void processFinish(String output);
    }

    public AsyncResponse delegate;

    public MobileClient (AsyncResponse delegate, String lot){
        this.delegate = delegate;
        this.parkingLot = lot;
    }

    @Override
    protected void onPostExecute(String result) {
        delegate.processFinish(result);
    }

//    private TextView availableSlots;
    String response;

//
//    MobileClient(String lot, String res) {
//        this.response = res;
//    }

    @Override
    protected String doInBackground(Void... voids) {
        Socket soc = null;
        try{

            soc = new Socket("ec2-35-170-67-94.compute-1.amazonaws.com",54145);
            DataOutputStream dout=new DataOutputStream(soc.getOutputStream());
            dout.writeUTF(parkingLot);
            int check;
            // dout.flush();
            // dout.close();
            // soc.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br1 = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            System.out.println("Client connected..");
            while(true){
                while((check = br1.read()) != 10) {
                    response = Character.toString((char) check);
                    System.out.println("FROM SERVER: " + response);
                    return response;
//                    return response;
                }
            }


        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "UnknownHostException: " + e.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "IOException: " + e.toString();
        } finally {
            if (soc != null) {
                try {
                    soc.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

}
