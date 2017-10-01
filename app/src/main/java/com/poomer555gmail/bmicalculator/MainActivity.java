package com.poomer555gmail.bmicalculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText HeightInput;
    private  EditText WeightInput;
    private Button CalButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HeightInput =(EditText) findViewById(R.id.height_edittext);
        WeightInput = (EditText) findViewById(R.id.weight_edittext);
        CalButton =(Button) findViewById(R.id.cal_button);
        CalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  String HeightText = HeightInput.getText().toString();
                    double Height =Double.valueOf(HeightText);//ทำให้โชว์ค่าที่ต้องการ

                  Double Weight = Double.valueOf(WeightInput.getText().toString());//อีกวิธี
                    Double BMI = Weight / ((Height/100) * (Height/100));
                   String BMIText = getBMItext(BMI);
                    String result = String.format("ค่า BMI ที่ได้คือ %.1f\n\nอยู่ในเกณฑ์ : %S",BMI,BMIText);
                   /* String result = "ค่าBMIที่่ได้คือ "+String.valueOf(BMI);
                    result+="\n\n อยู่ในเกณฑ์ : "+BMIText;*/
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("BMI Result");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // โค้ดที่ต้องการทำงานเมื่อกดปุ่มOK ถูกคลิก

                        HeightInput.setText("");
                        WeightInput.setText("");
                        HeightInput.requestFocus();

                    }
                });
                dialog.show();
               /* Toast T =Toast.makeText(MainActivity.this,"ค่าBMIที่่ได้คือ "+String.valueOf(BMI),Toast.LENGTH_LONG);
                T.show();*/
            }
        });
            }

    private String getBMItext(Double bmi) {
        String BMIText = "" ;
        if(bmi<18.5){
            BMIText = "น้ำหนักน้อยกว่าปกติ";
        }
        else if (bmi<25){
            BMIText = "น้ำหนักปกติ";
        }
        else if (bmi<30){
            BMIText = "น้ำหนักมากกว่าปกติ";
        }
        else {
            BMIText = "อ้วน!!!";
        }
        return BMIText;
    }

}
