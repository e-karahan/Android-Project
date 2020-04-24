package com.example.mobilprogramlama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {
    TextView twkalanhak,twyardim;
    EditText tbsayi;
    int rastgelesayi;
    int sayac=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);
        twkalanhak = findViewById(R.id.twkalanhak);
        twyardim = findViewById(R.id.twyardim);
        tbsayi = findViewById(R.id.tbsayi);
        Random r=new Random();
        rastgelesayi=r.nextInt(101); //0 ile 100 arasinda
        Log.e("Rastgele sayi",String.valueOf(rastgelesayi));

    }
    public void guess(View view){
        if(TextUtils.isEmpty(tbsayi.getText().toString())){
            Toast.makeText(this,"Lütfen Sayı Giriniz",Toast.LENGTH_SHORT).show();

        }else{
            sayac = sayac -1;
            int tahmin = Integer.parseInt(tbsayi.getText().toString());
            if(sayac!=0){
                if(tahmin==rastgelesayi){
                    Intent intent = new Intent(TahminActivity.this,SonucActivity.class);
                    intent.putExtra("sonuc",true);
                    startActivity(intent);
                    finish();
                }
                if(tahmin>rastgelesayi){
                    twyardim.setText("Azalt");
                }
                if(tahmin<rastgelesayi){
                    twyardim.setText("Arttır");
                }
                twkalanhak.setText("Kalan Hak : "+sayac);

            }else{
                //Oyun kaybedildi
                Intent intent = new Intent(TahminActivity.this,SonucActivity.class);
                intent.putExtra("sonuc",false);
                startActivity(intent);
                finish();
            }

            tbsayi.setText("");
        }

    }


}
