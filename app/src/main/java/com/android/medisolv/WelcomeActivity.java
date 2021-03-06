package com.android.medisolv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    String patient_id;
    Button viewhistory;
    Button viewPrescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        // Retrieve data from previous activity
        Bundle bundle = getIntent().getExtras();
        patient_id = bundle.getString("PatientID");
        TextView patientID=(TextView)findViewById(R.id.patientid);
        patientID.setText(patient_id.trim());

        /*setting the listener when viewHistory button has clicked*/
        viewhistory=(Button)findViewById(R.id.viewhistory);
        viewhistory.setOnClickListener(this);

        /*setting the listener when viewPrescription button has clicked*/
        viewPrescription=(Button)findViewById(R.id.viewprescription);
        viewPrescription.setOnClickListener(this);

    }

    /*Method to Redirect to corresponding page based on which button has clicked in the page*/
    @Override
    public void onClick(View v) {
        Intent intent;
        /*Redirecting to ViewHistory page when View History button has clicked*/
        if (v.getId() == R.id.viewhistory) {
            intent = new Intent(this, ViewHistoryActivity.class);
            startActivity(intent);
        }
         /*Redirecting to ViewPrescription page when ViewPrescription button has clicked*/
        else if (v.getId() == R.id.viewprescription) {
            intent = new Intent(this, PrescriptionDetailActivity.class);
            startActivity(intent);
        }
    }
}
