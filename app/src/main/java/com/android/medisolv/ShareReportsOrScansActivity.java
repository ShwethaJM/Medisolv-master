package com.android.medisolv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShareReportsOrScansActivity extends AppCompatActivity implements View.OnClickListener {
    Button back;
    Button home;
    String patient_id="Dummy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_reports_or_scans);

        /*setting the listener when Back button has clicked*/
        back = (Button)findViewById(R.id.shareReportBackButton);
        back.setOnClickListener(this);

        /*setting the listener when Home button has clicked*/
        home= (Button)findViewById(R.id.shareReportHomeButton);
        home.setOnClickListener(this);
    }

    /*Method to Redirect to corresponding page based on which button has clicked in the page*/
    @Override
    public void onClick(View view) {
        /*Redirecting to Home page when Home button has clicked*/
        if(view.getId() == R.id.shareReportHomeButton){
            System.out.println("View Report Home button clicked");
            Intent intent = new Intent(this,WelcomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("PatientID", patient_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        /*Redirecting to Back page when Back button has clicked*/
        else if(view.getId() == R.id.shareReportBackButton){
            System.out.println("View Report Back button clicked");
            Intent intent = new Intent(this,ReportsOrScansActivity.class);
            startActivity(intent);
        }
    }
}
