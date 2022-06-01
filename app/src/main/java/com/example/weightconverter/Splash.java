package com.example.weightconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class Splash extends AppCompatActivity {

    private static int SPLASH_TIMER = 3500;

    //variables
    ImageView Image;
    TextView logoName, logoDesc;

    //Animation
    Animation sideAnim, bottomAnim;

    //shared prefrences
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //hooks
        Image = findViewById(R.id.imageView);
        logoName = findViewById(R.id.textView);
        logoDesc = findViewById(R.id.textView2);

        //Animation hooks
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //set animations to elements
        Image.setAnimation(sideAnim);
        logoName.setAnimation(bottomAnim);
        logoDesc.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMER);

    }
}