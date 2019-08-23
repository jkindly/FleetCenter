package com.fleetcenter.activities;

import android.os.Bundle;
import com.fleetcenter.R;
import androidx.appcompat.app.AppCompatActivity;

public class FleetManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet_management);



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
