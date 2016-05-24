package com.android.medisolv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReportsOrScansActivity extends AppCompatActivity implements View.OnClickListener {

    Button view1;
    Button share1;
    Button home;
    Button back;
    String patient_id="Dummy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports_or_scans);

        /*setting the listener when View button has clicked*/
        view1 = (Button)findViewById(R.id.dependentViewButton1);
        view1.setOnClickListener(this);

        /*setting the listener when Share button has clicked*/
        share1 = (Button)findViewById(R.id.dependentDelButton1) ;
        share1.setOnClickListener(this);

        /*setting the listener when Home button has clicked*/
        home= (Button)findViewById(R.id.dependentHomeButton);
        home.setOnClickListener(this);

        /*setting the listener when Back button has clicked*/
        back= (Button)findViewById(R.id.dependentBackButton);
        back.setOnClickListener(this);
    }

    /*Method to Redirect to corresponding page based on which button has clicked in the page*/
    @Override
    public void onClick(View view) {
        Intent intent;
        /*Redirecting to View ReportsOrScans page when View button has clicked*/
        if(view.getId() == R.id.dependentViewButton1){
         intent = new Intent(this,ViewReportsOrScansActivity.class);
            startActivity(intent);
        }
        /*Redirecting to share ReportsOrScans page when Share button has clicked*/
        else if(view.getId() == R.id.dependentDelButton1){
           intent = new Intent(this,ShareReportsOrScansActivity.class);
            startActivity(intent);
        }
         /*Redirecting to Home page when Home button has clicked*/
        else if(view.getId() == R.id.dependentHomeButton){
            System.out.println("Report Home button clicked");
            intent = new Intent(this,WelcomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("PatientID", patient_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        /*Redirecting to Back page when Back button has clicked*/
        else if(view.getId() == R.id.dependentBackButton){
            intent = new Intent(this,ViewHistoryActivity.class);
            startActivity(intent);
        }

    }
}
