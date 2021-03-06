package com.example.nicha.finalproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import com.example.nicha.finalproject.Model.Dewy;
import com.example.nicha.finalproject.Service.DewyService;


public class DewyActivity extends AppCompatActivity {

//    private ImageView egg;
    ImageView monster;
    ImageButton btnFeed;
    private ProgressBar pgExp = null;
    private int i = 0;
    private int j = 1;
    public int k = 5;
    TextView tvLevel;
    ImageView ivHeart;
    TextView tvFoodDewy;
    DewyService voDewyService;
    Dewy voDewy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dewy);
        pgExp = (ProgressBar)findViewById(R.id.pgExp);
        tvLevel = (TextView) findViewById(R.id.tvLevel);
        ivHeart = (ImageView) findViewById(R.id.ivHeart);
        tvFoodDewy = (TextView) findViewById(R.id.tvFoodDewy);
        voDewyService = new DewyService(this);
        voDewy = voDewyService.getDewy();
        i = voDewy.getDewyEXP();
        j = voDewy.getDewyLevel();
        k = voDewy.getDewyFood();
        ivHeart.setVisibility(View.GONE);
        tvFoodDewy.setText("x"+k);
        tvLevel.setText("Lv "+j);
        pgExp.setMax(100);
        pgExp.setProgress(i);
        monster = (ImageView) findViewById(R.id.monster);
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

                if(k>0)
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

                        if(j > 4){
                            monster.setBackgroundResource(R.drawable.mons);
                            monster.post(new Runnable() {

                                @Override
                                public void run() {
                                    ((AnimationDrawable) monster.getBackground()).start();
                                }

                            });
                        }
                        k--;
                        tvFoodDewy.setText("x"+k);




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

    @Override
    protected void onStop(){
        super.onStop();
        voDewy.setDewyLevel(j);
        voDewy.setDewyFood(k);
        voDewy.setDewyEXP(i);
        voDewyService.updateDewy(voDewy);

    }
}
