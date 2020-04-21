package com.example.mobilprogramlama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton rb,rb2,rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void changeActivity(View view){
        rb=findViewById(R.id.rbendeks);
        rb2=findViewById(R.id.rbkronometre);
        rb3=findViewById(R.id.rboyun);
        if(rb.isChecked()){
            Intent intent=new Intent(MainActivity.this,KitleEndeks.class);
            startActivity(intent);
        }
        else if(rb2.isChecked()){
            Intent intent2=new Intent(MainActivity.this,Kronometre.class);
            startActivity(intent2);
        }
        else if(rb3.isChecked()){
            Intent intent3=new Intent(MainActivity.this,SayiTahmin.class);
            startActivity(intent3);
        }
    }
}
