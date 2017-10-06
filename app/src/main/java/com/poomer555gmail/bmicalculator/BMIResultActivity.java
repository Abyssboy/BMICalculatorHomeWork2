package com.poomer555gmail.bmicalculator;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BMIResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);
        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("bmi_value",0);
        String BMIText = intent.getStringExtra("bmi_text");

        String much = String.valueOf(String.format("%.2f", bmi));

        TextView t = (TextView) findViewById(R.id.BMICal);
        TextView t2 = (TextView) findViewById(R.id.BMIAns);

        t.setText("ค่าฺBMIที่ได้คือ "+much);
        t2.setText("อยู่ในเกณฑ์ "+BMIText);
        /*textView.
        setContentView(textview);*/




    }
}
