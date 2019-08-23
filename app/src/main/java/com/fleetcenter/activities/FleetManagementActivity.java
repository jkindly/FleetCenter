package com.fleetcenter.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.fleetcenter.R;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FleetManagementActivity extends AppCompatActivity {

    String jsonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet_management);

        new BackgroundTask().execute();
    }

    public void addCarToContainer(String brand, String model, String registrationNumber) {

    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String jsonURL;

        @Override
        protected void onPreExecute() {
            jsonURL = "https://fleetcenter.000webhostapp.com/car.php";
        }

        @Override
        protected void onPostExecute(String result) {
            TextView segmentTitleB = findViewById(R.id.segmentTitleB);
            try {
                JSONArray cars = new JSONArray(result);
                for(int i = 0; i<cars.length(); i++) {
                    JSONObject car = cars.getJSONObject(i);
                    String brand = car.getString("brand");
                    String model = car.getString("model");
                    String registrationNumber = car.getString("registration_number");
                    addCarToContainer(brand, model, registrationNumber);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {
                URL url = new URL(jsonURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder = new StringBuilder();

                while ((jsonString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(jsonString+"\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }


    public class Car {
        String brand;
        String model;
        String registerNumber;

        Car(String brand, String model, String registerNumber) {
            this.brand = brand;
            this.model = model;
            this.registerNumber = registerNumber;
        }

        String getBrand() {
            return brand;
        }

        String getModel() {
            return model;
        }

        String getRegisterNumber() {
            return registerNumber;
        }
    }

}
