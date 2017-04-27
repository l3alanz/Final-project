package com.example.nicha.finalproject;

import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class DewyActivity extends AppCompatActivity {

//    private ImageView egg;
    ImageView monster;
    ImageButton btnFeed;
    private ProgressBar pgExp = null;
    private int i = 0;
    private int j = 1;
    TextView tvLevel;
    ImageView ivHeart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dewy);
        pgExp = (ProgressBar)findViewById(R.id.pgExp);
        tvLevel = (TextView) findViewById(R.id.tvLevel);
        ivHeart = (ImageView) findViewById(R.id.ivHeart);
        ivHeart.setVisibility(View.GONE);
        tvLevel.setText("Lv "+j);
        pgExp.setMax(100);
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

//        highlight for feed button
        btnFeed = (ImageButton) findViewById(R.id.btnFeed);

        ((ImageButton)findViewById(R.id.btnFeed)).setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ImageButton view = (ImageButton ) v;
                        view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();

                        i += 10;
                        if ( i < pgExp.getMax() ) {
                            pgExp.setProgress(i);
                            ivHeart.setVisibility(View.GONE);
                        }else {
                            ivHeart.setVisibility(View.VISIBLE);
                            pgExp.setProgress(0);
                            i = 0;
                            j ++;
                        }

                    // for updating level of Dewy

                        tvLevel.setText("Lv "+j);
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
