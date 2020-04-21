package com.example.mobilprogramlama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class KitleEndeks extends AppCompatActivity {
    RadioButton rb, rb2;
    TextView twendeks, twidealkilo, twsonuc;
    EditText editkilo, editboy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitle_endeks);
        rb = findViewById(R.id.rberkek);
        rb2 = findViewById(R.id.rbkadin);
        editkilo = (EditText) findViewById(R.id.kilo);
        editboy = (EditText) findViewById(R.id.boy);
        twendeks = (TextView) findViewById(R.id.tbendeks);
        twidealkilo = (TextView) findViewById(R.id.tbideal);
        twsonuc = (TextView) findViewById(R.id.tbsonuc);
    }

    public void calculate(View view) {
        //Vucut Kitle Endeks Hesabı
        double boy = Double.parseDouble(editboy.getText().toString()) / 100;
        double boykare = boy * boy;
        double kilo = Double.parseDouble(editkilo.getText().toString());
        double endex = kilo / boykare;
        twendeks.setText(String.valueOf(endex));
       /*
        //-İdeal Kilo Hesabı
        if (rb.isChecked()) {
            double idealkilo = 50 + (2.3 * ((boy / 2.54) - 60));
            twidealkilo.setText(String.valueOf(idealkilo));
        } else if (rb2.isChecked()) {
            double idealkilokadin = 45.5 + (2.3 * ((boy / 2.54) - 60));
            twidealkilo.setText(String.valueOf(idealkilokadin));
        }
        */

    }


}
