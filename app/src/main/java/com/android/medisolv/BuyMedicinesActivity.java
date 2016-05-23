package com.android.medisolv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuyMedicinesActivity extends AppCompatActivity implements View.OnClickListener{
    Button back;
    Button home;

    String patient_id="Dummy";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicines);

        back = (Button)findViewById(R.id.buyMedicinesBackButton);
        back.setOnClickListener(this);

        home= (Button)findViewById(R.id.buyMedicinesHomeButton);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        if(view.getId() == R.id.buyMedicinesHomeButton){
            System.out.print("");
            intent = new Intent(this,WelcomeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("PatientID", patient_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }else  if(view.getId() == R.id.buyMedicinesBackButton){
            intent = new Intent(this,PrescriptionDetailActivity.class);
            startActivity(intent);
        }
    }
}
