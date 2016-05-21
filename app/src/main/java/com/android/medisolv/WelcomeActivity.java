package com.android.medisolv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    String patient_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        // Retrieve data from previous activity
        Bundle bundle = getIntent().getExtras();
        patient_id = bundle.getString("PatientID");
        TextView patientID=(TextView)findViewById(R.id.patientid);
        patientID.setText(patient_id.trim());
        Button viewhistory=(Button)findViewById(R.id.viewhistory);
        viewhistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent(this,ViewHistoryActivity.class);
        startActivity(intent);
    }
}
