package com.android.medisolv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrescriptionDetailActivity extends AppCompatActivity implements View.OnClickListener{

    Button back;
    Button home;
    Button buy;
    String patient_id="Dummy";

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_detail);

         /*setting the listener when Back button has clicked*/
        back = (Button)findViewById(R.id.prescriptionDetailBackButton);
        back.setOnClickListener(this);

         /*setting the listener when Home button has clicked*/
        home= (Button)findViewById(R.id.prescriptionDetailHomeButton);
        home.setOnClickListener(this);

         /*setting the listener when Buy button has clicked*/
        buy = (Button)findViewById(R.id.prescriptionDetailBuyButton);
        buy.setOnClickListener(this);
    }

    /*Method to Redirect to corresponding page based on which button has clicked in the page*/
    @Override
    public void onClick(View view) {
        Intent intent;
        /*Redirecting to Home page when Home button has clicked*/
        if(view.getId() == R.id.prescriptionDetailHomeButton){
            System.out.println("View Report Home button clicked");
            intent = new Intent(this,WelcomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("PatientID", patient_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        /*Redirecting to Buy medicine page when Buy button has clicked*/
        else  if(view.getId() == R.id.prescriptionDetailBuyButton){
            intent = new Intent(this,BuyMedicinesActivity.class);
            startActivity(intent);
        }
        /*Redirecting to Back page when Back button has clicked*/
        else if(view.getId() == R.id.prescriptionDetailBackButton){
            System.out.println("View Report Back button clicked");
            intent = new Intent(this,WelcomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("PatientID", patient_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}
