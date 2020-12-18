package com.muneiah.example.covid19reports;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView active_tv,deaths_tv,recovered_tv,country_tv,date_tv,confirmed_tv;
ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        active_tv=findViewById(R.id.active);
        deaths_tv=findViewById(R.id.deaths);
        recovered_tv=findViewById(R.id.recovered);
        confirmed_tv=findViewById(R.id.confirmed);
        country_tv=findViewById(R.id.country);
        date_tv=findViewById(R.id.date);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Fetching data from Internet");
        dialog.setMessage("Please wait for loading result..");
        dialog.show();
        EndpointInterface service=Covid19Instance.getInstance().create(EndpointInterface.class);
        Call<String> call=service.getInstance();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                dialog.dismiss();
                /*Toast.makeText(MainActivity.this, ""+response.body(), Toast.LENGTH_SHORT).show();
                Log.i("ding",response.body());*/
                try {
                    JSONArray rootAry=new JSONArray(response.body());
                    JSONObject obj=rootAry.getJSONObject(rootAry.length()-1);
                    String date=obj.getString("Date");
                    String Active=obj.getString("Active");
                    String Recovered=obj.getString("Recovered");
                    String Deaths=obj.getString("Deaths");
                    String Confirmed=obj.getString("Confirmed");
                    String Country=obj.getString("Country");

                    date_tv.setText("Date: "+date);
                    country_tv.setText("Country: "+Country);
                    active_tv.setText("Active Cases: "+Active);
                    recovered_tv.setText("Recovered cases: "+Recovered);
                    deaths_tv.setText("Deaths: "+Deaths);
                    confirmed_tv.setText("Confirmed cases: "+Confirmed);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error fetching data,somthing webt wrong..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}