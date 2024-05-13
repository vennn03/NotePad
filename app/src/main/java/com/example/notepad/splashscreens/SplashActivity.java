package com.example.notepad.splashscreens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.notepad.MainActivity;
import com.example.notepad.R;

public class SplashActivity extends AppCompatActivity {

    // delay time for the splash screen in milliseconds (3.1 seconds)
    private static final int SPLASH_DELAY = 3100;

    // 'Handler' instance variable to manage delayed execution
    private Handler mHandler;

    // 'Runnable' instance variable; task to be executed after the delay
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // initialize Handler
        mHandler = new Handler();

        // initialize Runnable
        mRunnable = new Runnable() {
            @Override
            public void run() {

                // go to MainActivity page
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                // close this activity
                finish();

            }// end 'run' method

        };// end 'mRunnable' method

        // use the 'Handler' object to delay navigation to 'MainActivity.java' page
        mHandler.postDelayed(mRunnable, SPLASH_DELAY);

    }// end 'onCreate' method

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // remove pending callbacks to prevent memory leaks
        mHandler.removeCallbacks(mRunnable);

    }// end 'onDestroy' method

}// end 'SplashActivity' class