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
        home=(Button)findViewById(R.id.homebutton);
        back=(Button)findViewById(R.id.backbutton);
        home.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.homebutton)
        {
            Intent intent = new Intent(this,WelcomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("PatientID", patient_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else if(v.getId()==R.id.backbutton)
        {
            Intent intent = new Intent(this,WelcomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("PatientID", patient_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    public void openReportsOrScanActivity(View view){
        Intent intent = new Intent(this,ReportsOrScansActivity.class);
        startActivity(intent);
    }
}