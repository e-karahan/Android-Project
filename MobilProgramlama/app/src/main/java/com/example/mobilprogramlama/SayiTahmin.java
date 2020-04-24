package com.example.mobilprogramlama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SayiTahmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayi_tahmin);
    }
    public void gameStart(View view){
        Intent intent = new Intent(SayiTahmin.this,TahminActivity.class);
        startActivity(intent);
    }
    public void returnMain(View view){
        Intent intent = new Intent(SayiTahmin.this,MainActivity.class);
        startActivity(intent);
    }
}
