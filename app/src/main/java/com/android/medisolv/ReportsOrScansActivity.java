package com.android.medisolv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReportsOrScansActivity extends AppCompatActivity implements View.OnClickListener {

    Button view1;
    Button home;
    String patient_id="Dummy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports_or_scans);

        view1 = (Button)findViewById(R.id.viewButton1);
        view1.setOnClickListener(this);

        home= (Button)findViewById(R.id.reportHomeButton);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.viewButton1){
        Intent intent = new Intent(this,ViewReportsOrScansActivity.class);
        startActivity(intent);
        }
        else if(view.getId() == R.id.reportHomeButton){
            System.out.println("Report Home button clicked");
            Intent intent = new Intent(this,WelcomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("PatientID", patient_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
