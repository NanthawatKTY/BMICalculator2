package com.nanthawat134.bmicalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_cal = (Button)findViewById(R.id.button_cal);
        button_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calBMI();
            }
        });
    }
    private void calBMI(){
        EditText textw = (EditText)findViewById(R.id.editTextW);
        EditText texth = (EditText)findViewById(R.id.editTextH);

        double w = Double.parseDouble(textw.getText().toString());
        double h = Double.parseDouble(texth.getText().toString());

        h = h/100; // cm ---> m
        double bmi = w/(h*h);
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        String msg = "BMI Value : " + decimalFormat.format(bmi) + "\n";
        msg += "Body Appearance : ";

        if(bmi >= 40) msg += "Fattest";
        else if(bmi >= 35) msg += "Fat Lv.2";
        else if (bmi >= 28.5) msg += "Fat Lv.1";
        else if (bmi >= 23.5) msg += "Over Weight";
        else if (bmi >= 18.5) msg += "Normal Weight";
        else msg += "Lower Weight";

        Toast.makeText(getBaseContext(),msg, Toast.LENGTH_SHORT).show();


    }//calBMI method
}
