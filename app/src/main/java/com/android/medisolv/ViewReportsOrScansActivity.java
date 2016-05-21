package com.android.medisolv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewReportsOrScansActivity extends AppCompatActivity implements View.OnClickListener{

    Button back;
    Button home;
    String patient_id="Dummy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reports_or_scans);

        back = (Button)findViewById(R.id.viewReportBackButton);
        back.setOnClickListener(this);

        home= (Button)findViewById(R.id.viewReportHomeButton);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.viewReportHomeButton){
            System.out.println("View Report Home button clicked");
            Intent intent = new Intent(this,WelcomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("PatientID", patient_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else if(view.getId() == R.id.viewReportBackButton){
            System.out.println("View Report Back button clicked");
            Intent intent = new Intent(this,ReportsOrScansActivity.class);
            startActivity(intent);
        }
    }
}
