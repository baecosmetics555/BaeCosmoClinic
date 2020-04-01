package com.example.baecosmoclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

public class PostScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_schedule);


        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_monday1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner_monday2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner_tue1);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner_tue2);
        Spinner spinner5 = (Spinner) findViewById(R.id.spinner_wed1);
        Spinner spinner6 = (Spinner) findViewById(R.id.spinner_wed2);
        Spinner spinner7 = (Spinner) findViewById(R.id.spinner_thur1);
        Spinner spinner8 = (Spinner) findViewById(R.id.spinner_thur2);
        Spinner spinner9 = (Spinner) findViewById(R.id.spinner_fri1);
        Spinner spinner10 = (Spinner) findViewById(R.id.spinner_fri2);


        // get spinner data
        int mon1 = Integer.parseInt(spinner1.getSelectedItem().toString());
        int mon2 = Integer.parseInt(spinner2.getSelectedItem().toString());
        int tue1 = Integer.parseInt(spinner3.getSelectedItem().toString());
        int tue2 = Integer.parseInt(spinner4.getSelectedItem().toString());
        int wed1 = Integer.parseInt(spinner5.getSelectedItem().toString());
        int wed2 = Integer.parseInt(spinner6.getSelectedItem().toString());
        int thur1 = Integer.parseInt(spinner7.getSelectedItem().toString());
        int thur2 = Integer.parseInt(spinner8.getSelectedItem().toString());
        int fri1 = Integer.parseInt(spinner9.getSelectedItem().toString());
        int fri2 = Integer.parseInt(spinner10.getSelectedItem().toString());

    }
}
