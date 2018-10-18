package com.example.dell.animator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView button;
    private Button click1;
    private Button click2;
    private Button click3;
    private Button click4;
    private ObjectAnimator objectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        button = findViewById( R.id.but_1 );
        click1 = findViewById( R.id.but_click1 );
        click2 = findViewById( R.id.but_click2 );
        click3 = findViewById( R.id.but_click3 );
        click4 = findViewById( R.id.but_click4 );
        click1.setOnClickListener( this );
        click2.setOnClickListener( this );
        click3.setOnClickListener( this );
        click4.setOnClickListener( this );
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.but_click1:
                trance();
            break;
            case R.id.but_click2:
                rotation();
                break;
            case R.id.but_click3:
                alpha();
                break;
            case R.id.but_click4:
                argb();
                break;
        }
    }
    private void argb() {
        final ValueAnimator valueAnimator = ValueAnimator.ofFloat( 0, (float) 0.5,1 );
        valueAnimator.setDuration( 3000 );
        valueAnimator.start();
        valueAnimator.addUpdateListener( new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
               button.setScaleX( (Float) valueAnimator.getAnimatedValue() );
               button.setScaleY( (Float) valueAnimator.getAnimatedValue() );
            }
        } );
    }

    private void alpha() {
        /*final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,1,1);
        valueAnimator.setDuration( 3000 );
        valueAnimator.start();
        valueAnimator.addUpdateListener( new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //button.setRotation( (Float) valueAnimator.getAnimatedValue() );
                button.setAlpha( (Float) valueAnimator.getAnimatedValue() );
            }
        } );*/
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat( button, "alpha", 0, 1 );
        objectAnimator.setDuration( 3000 );
        objectAnimator.start();
    }

    private void rotation() {
        /*final ValueAnimator valueAnimator = ValueAnimator.ofFloat( 0, 200,400,200,0 );
        valueAnimator.setDuration( 3000 );
        valueAnimator.start();
        valueAnimator.addUpdateListener( new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
               //button.setRotation( (Float) valueAnimator.getAnimatedValue() );
               button.setRotationX( (Float) valueAnimator.getAnimatedValue() );
               button.setRotationY( (Float) valueAnimator.getAnimatedValue() );
            }
        } );*/
        objectAnimator = ObjectAnimator.ofFloat( button, "rotationY", 0, 500,0 );
        objectAnimator.setDuration( 3000 );
        objectAnimator.start();
    }

    private void trance() {
       /* final ValueAnimator valueAnimator = ValueAnimator.ofFloat( 0, 200,0,400);
        valueAnimator.setDuration( 3000 );
        valueAnimator.start();
        valueAnimator.addUpdateListener( new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                button.setTranslationX( (Float) valueAnimator.getAnimatedValue() );
                button.setTranslationY( (Float) valueAnimator.getAnimatedValue() );
            }
        } );*/
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat( button, "translationX", 0, 500,0 );
        objectAnimator.setDuration( 3000 );
        objectAnimator.start();

    }
}
