package com.example.mobilprogramlama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SonucActivity extends AppCompatActivity {
    ImageView imageviewsonuc;
    TextView twsonuc;
    boolean sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        imageviewsonuc=findViewById(R.id.imageviewsonuc);
        twsonuc=findViewById(R.id.twsonuc);
        sonuc = getIntent().getBooleanExtra("sonuc",false);
        if(sonuc){
            imageviewsonuc.setImageResource(R.drawable.smile);
            twsonuc.setText("Kazandınız");
            twsonuc.setTextColor(Color.GREEN);
        }else{
            imageviewsonuc.setImageResource(R.drawable.sad);
            twsonuc.setText("Kaybettiniz");
            twsonuc.setTextColor(Color.RED);
        }
    }
    public void playAgain(View view){
        Intent intent = new Intent(SonucActivity.this,TahminActivity.class);
        startActivity(intent);
        finish();
    }
}
