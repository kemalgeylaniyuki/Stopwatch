package com.kemalgeylaniyuki.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Runnable runnable;  // işlemi belirttiğimiz periyotta yapmamıza olanak sağlayan arayüz
    Handler handler; // runnable yi ele almak, yönetmek olanağı sağlayan arayüz
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        number = 0;

        button = findViewById(R.id.button);

    }

    public void start(View view){

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {  // bu run metodundaki her şey, belirnenen periyot içinde gerçekleşir.
                textView.setText("Time : " + number);
                number++;
                textView.setText("Timer : " + number);
                handler.postDelayed(runnable, 1000);
            }
        };

        handler.post(runnable);
        button.setEnabled(false);  // butona daha fazla basmayı engeller.



    }

    public void stop(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable); // runnable yi kapat
        number = 0;
        textView.setText("Time : " + number);
    }




}