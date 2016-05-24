package com.android.medisolv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewHistoryActivity extends AppCompatActivity implements View.OnClickListener {
    String patient_id="Dummy";
    Button home,back;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);

        /*setting the listener when Home button has clicked*/
        home=(Button)findViewById(R.id.homebutton);
        home.setOnClickListener(this);

        /*setting the listener when Back button has clicked*/
        back=(Button)findViewById(R.id.backbutton);
        back.setOnClickListener(this);
    }

    /*Method to Redirect to corresponding page based on which button has clicked in the page*/
    @Override
    public void onClick(View v)
    {
         /*Redirecting to Home page when Home button has clicked*/
        if(v.getId()==R.id.homebutton)
        {
            Intent intent = new Intent(this,WelcomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("PatientID", patient_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }
         /*Redirecting to Back page when Back button has clicked*/
        else if(v.getId()==R.id.backbutton)
        {
            Intent intent = new Intent(this,WelcomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("PatientID", patient_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
    /*Method to call ReportsOrScans activity when Reports / Scans button has clicked*/
    public void openReportsOrScanActivity(View view){
        Intent intent = new Intent(this,ReportsOrScansActivity.class);
        startActivity(intent);
    }

    /*Method to call Prescription Details activity when View Prescription button has clicked*/
    public void openPrescriptionActivity(View view){
        Intent intent = new Intent(this,PriscriptionActivity.class);
        startActivity(intent);
    }
}
