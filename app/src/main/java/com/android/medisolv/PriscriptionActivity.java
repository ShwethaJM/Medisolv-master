package com.android.medisolv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PriscriptionActivity extends AppCompatActivity implements View.OnClickListener {

    Button home;

    String patient_id="Dummy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priscription);

        /*setting the listener when Home button has clicked*/
        home= (Button)findViewById(R.id.prescriptionHomeButton);
        home.setOnClickListener(this);
    }

    /*Method to Redirect to corresponding page based on which button has clicked in the page*/
    @Override
    public void onClick(View view) {
        Intent intent;
        /*Redirecting to Home page when Home button has clicked*/
        if(view.getId() == R.id.prescriptionHomeButton){
            intent = new Intent(this,WelcomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("PatientID", patient_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}
