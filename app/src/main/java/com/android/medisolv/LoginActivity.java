package com.android.medisolv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mobile;
    EditText patientid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mobile = (EditText)findViewById(R.id.mobile_no);
        patientid = (EditText)findViewById(R.id.patientid);
        Button submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        /*Code to check Login credential's*/

        String mobileno=mobile.getText().toString();
        String patient_id=patientid.getText().toString();
        if(mobileno.equals("") || patient_id.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Fill all the blocks", Toast.LENGTH_LONG).show();
        }
        else if(mobileno.length()<10)
        {
            Toast.makeText(getApplicationContext(), "Mobile Number should be 10 digits", Toast.LENGTH_LONG).show();
        }
        else
        {
            //database retrivel code comes here
            Intent intent = new Intent(this, WelcomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("PatientID", patient_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
