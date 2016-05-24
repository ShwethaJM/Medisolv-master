package com.android.medisolv;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DependentRegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText dob;
    DatePickerDialog fromDatePickerDialog;
    SimpleDateFormat dateFormatter;

    EditText firstName;
    EditText lastName;
    EditText mobile;

    Spinner spinner;
    Spinner genderSpinner;

    String gender;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependent_register);

         /*code to set date picker*/
        dateFormatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.UK);
        dob = (EditText) findViewById(R.id.dependentReg_dob);
        dob.setInputType(InputType.TYPE_NULL);
        dob.requestFocus();
        setDateTimeField();

          /*set spinner values*/
        spinner= (Spinner)findViewById(R.id.dependentSpinner1);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.spinner1_array,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        /*set gender spinner values*/
        genderSpinner = (Spinner)findViewById(R.id.dependentGenderSpinner);
        ArrayAdapter genderArrayAdapter = ArrayAdapter.createFromResource(this,R.array.gender_array,R.layout.support_simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderArrayAdapter);

        /*setting the listener when item selected in all spinners of the page*/
        spinner.setOnItemSelectedListener(this);
        genderSpinner.setOnItemSelectedListener(this);
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

    /*Method to get the value of the spinners*/
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId() == R.id.dependentSpinner1){
            item = adapterView.getItemAtPosition(i).toString();
        }else if (adapterView.getId() == R.id.dependentGenderSpinner) {
            gender = adapterView.getItemAtPosition(i).toString();
        }
        }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
    public void dependentRegisterOnSubmit(View view){

        /*code to get all edit text fields values*/
        firstName = (EditText)findViewById(R.id.dependentReg_fn);
        lastName = (EditText)findViewById(R.id.dependentReg_ln);
        mobile = (EditText)findViewById(R.id.dependentReg_mobile);
        dob = (EditText)findViewById(R.id.dependentReg_dob);


        String fn = firstName.getText().toString();
        String ln = lastName.getText().toString();
        String phone = mobile.getText().toString();
        String birth = dob.getText().toString();


        /*code to check all mandatory fields are containing values or not and mobile no length is 10 or not*/

        if (fn.equals("") || ln.equals("") || phone.equals("") || birth.equals("")) {

            Toast.makeText(getApplicationContext(), "Fill all Mandatory fields", Toast.LENGTH_LONG).show();
        }

        else if(phone.length()<10)
        {
            Toast.makeText(getApplicationContext(), "Mobile Number should be 10 digits", Toast.LENGTH_LONG).show();
        }


    }
}
