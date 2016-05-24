package com.android.medisolv;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class RegistrationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText dob;
    DatePickerDialog fromDatePickerDialog;
    SimpleDateFormat dateFormatter;

    EditText firstName;
    EditText lastName;
    EditText mobile;
    EditText specialisation;
    EditText license;

    Spinner spinner;
    Spinner genderSpinner;
    Spinner regTypeSpinner;

    String registrationType;
    String gender;
    String item;

    Boolean doctorFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        /*code to set date picker*/
        dateFormatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.UK);
        dob = (EditText) findViewById(R.id.reg_dob);
        dob.setInputType(InputType.TYPE_NULL);
        dob.requestFocus();
        setDateTimeField();

        /*code to set custom title bar*/
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        /*set spinner values*/
        spinner= (Spinner)findViewById(R.id.Spinner1);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.spinner1_array,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        /*set gender spinner values*/
        genderSpinner = (Spinner)findViewById(R.id.genderSpinner);
        ArrayAdapter genderArrayAdapter = ArrayAdapter.createFromResource(this,R.array.gender_array,R.layout.support_simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderArrayAdapter);

        /* set Registration Type spinner values*/
        regTypeSpinner = (Spinner)findViewById(R.id.regTypeSpinner);
        ArrayAdapter regTypeArrayAdapter = ArrayAdapter.createFromResource(this,R.array.regType_array,R.layout.support_simple_spinner_dropdown_item);
        regTypeSpinner.setAdapter(regTypeArrayAdapter);

        /*setting the listener when item selected in all spinners of the page*/
        spinner.setOnItemSelectedListener(this);
        genderSpinner.setOnItemSelectedListener(this);
        regTypeSpinner.setOnItemSelectedListener(this);


    }

    /*Method to display selected date from the date picker*/
    private void setDateTimeField()
    {
        dob.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                dob.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    /*method to un hide the specialisation and license edit text and to popup message
    to select the registration type when it is not selected*/
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(adapterView.getId() == R.id.Spinner1){
            item = adapterView.getItemAtPosition(i).toString();
        }else if (adapterView.getId() == R.id.genderSpinner){
            gender = adapterView.getItemAtPosition(i).toString();
        }if (adapterView.getId() == R.id.regTypeSpinner) {
            if (i > 0) {
            /*code to un hide the specialisation and license edit text*/
                registrationType = adapterView.getItemAtPosition(i).toString();
                specialisation = (EditText) findViewById(R.id.reg_spl);
                license = (EditText) findViewById(R.id.reg_license);
                if (registrationType.equals(new String("Doctor"))) {
                    doctorFlag=true;
                    specialisation.setVisibility(View.VISIBLE);
                    license.setVisibility(View.VISIBLE);
                } else {
                    doctorFlag=false;
                    specialisation.setVisibility(View.INVISIBLE);
                    license.setVisibility(View.INVISIBLE);
                }

            } else {
            /*code to popup message to select the registration type when it is not selected*/
               // Toast.makeText(getApplicationContext(), "Please select the Registration type", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Please select the Registration type", Toast.LENGTH_LONG).show();
    }

    /*Method to show date picker to select the date*/
    @Override
    public void onClick(View v)
    {
        if(v == dob) {
            fromDatePickerDialog.show();
        }

    }

    /*code to get the values form the view and check all mandatory fields are containing values or not*/
    public void registerOnSubmit(View view){

        /*code to get all edit text fields values*/
        firstName = (EditText)findViewById(R.id.reg_fn);
        lastName = (EditText)findViewById(R.id.reg_ln);
        mobile = (EditText)findViewById(R.id.reg_mobile);
        dob = (EditText)findViewById(R.id.reg_dob);
        specialisation = (EditText)findViewById(R.id.reg_spl);
        license = (EditText)findViewById(R.id.reg_license);

        String fn = firstName.getText().toString();
        String ln = lastName.getText().toString();
        String phone = mobile.getText().toString();
        String birth = dob.getText().toString();
        String spl = specialisation.getText().toString();
        String licenceNo = license.getText().toString();

        /*code to check all mandatory fields are containing values or not and mobile no length is 10 or not*/

        if (fn.equals("") || ln.equals("") || phone.equals("") || birth.equals("")||registrationType.equals("Registration type")) {

                Toast.makeText(getApplicationContext(), "Fill all Mandatory fields", Toast.LENGTH_LONG).show();
            }
        else if(doctorFlag == true){

                if (spl.equals("")||licenceNo.equals("")) {

                    Toast.makeText(getApplicationContext(), "Fill all Mandatory fields", Toast.LENGTH_LONG).show();
                }
        }
        else if(phone.length()<10)
        {
            Toast.makeText(getApplicationContext(), "Mobile Number should be 10 digits", Toast.LENGTH_LONG).show();
        }


    }
}
