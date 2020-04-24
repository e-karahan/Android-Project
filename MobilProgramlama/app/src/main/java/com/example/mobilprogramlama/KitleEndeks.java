package com.example.mobilprogramlama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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
        //Sonuç textview yazdırma


        //-İdeal Kilo Hesabı
        //  50 + (2.3 * ((boy / 2.54) - 60))

        if (rb.isChecked()) { //Erkek
            double boymetre = boy * 100;
            double boybolme = boymetre / 2.54;
            boybolme-=60;
            boybolme*=2.3;
            double idealkilo;
            idealkilo=50+boybolme;
            twidealkilo.setText(String.valueOf(idealkilo));
            if(endex<18.49){
                twsonuc.setText("İdeal Kilonun Altındasınız");
            }
            else if(endex>18.5 && endex<24.99){
                twsonuc.setText("İdeal Kilodasınız");
            }
            else if(endex>25 && endex<29.99){
                twsonuc.setText("İdeal Kilonun Üzerindesiniz");
            }
            else if(endex>30) {
                twsonuc.setText("İdeal Kilonun Çok Üzerindesiniz");
            }


        } else if (rb2.isChecked()) { //Kadın
            double boymetre = boy * 100;
            double boybolme = boymetre / 2.54;
            boybolme-=60;
            boybolme*=2.3;
            double idealkilo;
            idealkilo=45.5+boybolme;
            twidealkilo.setText(String.valueOf(idealkilo));
            if(endex<18.49){
                twsonuc.setText("İdeal Kilonun Altındasınız");
            }
            else if(endex>18.5 && endex<24.99){
                twsonuc.setText("İdeal Kilodasınız");
            }
            else if(endex>25 && endex<29.99){
                twsonuc.setText("İdeal Kilonun Üzerindesiniz");
            }
            else if(endex>30) {
                twsonuc.setText("İdeal Kilonun Çok Üzerindesiniz");
            }
        }
        else{
            Toast.makeText(KitleEndeks.this,"Lütfen Cinsiyet Seçiniz",Toast.LENGTH_LONG).show();
        }


    }


}
