package com.example.nicha.finalproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class DewyActivity extends AppCompatActivity {

//    private ImageView egg;
    ImageView monster;
    ImageButton btnFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dewy);

//        egg = (ImageView) findViewById(R.id.egg);
        monster = (ImageView) findViewById(R.id.monster);
//
//        egg.post(new Runnable() {
//
//            @Override
//            public void run() {
//                ((AnimationDrawable) egg.getBackground()).start();
//            }
//
//        });
        monster.post(new Runnable() {

            @Override
            public void run() {
                ((AnimationDrawable) monster.getBackground()).start();
            }

        });

//        highlight for button

        btnFeed = (ImageButton) findViewById(R.id.btnFeed);

        ((ImageButton)findViewById(R.id.btnFeed)).setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton ) v;
                        view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP:

                        // Your action here on button click

                    case MotionEvent.ACTION_CANCEL: {
                        ImageButton view = (ImageButton) v;
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }
                return true;
            }
        });
    }
}
