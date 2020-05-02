package com.example.mobilprogramlama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Kronometre extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    int saniye=0;
    int dakika=0;
    int saat=0;
    int rastgelesayi;
    Random r=new Random();
    int Images[] = {R.drawable.cartman,R.drawable.kenny,R.drawable.kyle,R.drawable.stan,R.drawable.wendy};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kronometre);
        imageView=findViewById(R.id.imageView3);
        textView=findViewById(R.id.twsayac);


        Thread t = new Thread(){
            public void run(){
                while (!isInterrupted()){
                    try {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                saniye++;
                                if(saniye==60){
                                    dakika++;
                                    saniye=0;
                                }
                                if(dakika==60){
                                    saat++;
                                    dakika=0;
                                }
                                textView.setText(String.valueOf(saat)+":"+String.valueOf(dakika)+":"+String.valueOf(saniye));
                                if(saniye%2==0){  //2ye bölünebiliyorsa 2 saniye gecmiş demektir
                                    rastgelesayi=r.nextInt(5);
                                    if(rastgelesayi==0){
                                        imageView.setImageResource(Images[0]);
                                    }
                                    else if(rastgelesayi==1){
                                        imageView.setImageResource(Images[1]);
                                    }
                                    else if(rastgelesayi==2){
                                        imageView.setImageResource(Images[2]);
                                    }
                                    else if(rastgelesayi==3){
                                        imageView.setImageResource(Images[3]);
                                    }
                                    else if(rastgelesayi==4){
                                        imageView.setImageResource(Images[4]);
                                    }
                                }
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        };
        t.start();


    }
    public void returnBack(View view){
        Intent intent = new Intent(Kronometre.this,MainActivity.class);
        startActivity(intent);
    }
}
