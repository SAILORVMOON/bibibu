package com.example.bibibu;


import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends Activity {

    static ArrayList<Path> paths;
    static Paint p;
    static Path path;
    public ImageButton clear, plus, minus;
    Button white, black, red, green, blue, yellow;
    static int size = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        path = new Path();
        paths = new ArrayList<>();
        p = new Paint();
        p.setColor(Color.BLACK);
        p.setStrokeWidth(size);
        p.setStyle(Paint.Style.STROKE);
    }

    public static class MyDraw extends View {

        public MyDraw(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            for (int i =0; i< paths.size(); i++){
                canvas.drawPath(paths.get(i), p);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent motionEvent) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(x, y);
                    paths.add(path);
                    invalidate();
                    return true;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(x, y);
                    paths.add(path);
                    invalidate();
                    return true;
                default:
                    return false;
            }
        }
    }

    public void clear (View v){
        paths.clear();
    }
    public void minus(View v){
        if(size != 1){
            size--;
            p.setStrokeWidth(size);
        }
    }
    public void plus(View v){
        size++;
        p.setStrokeWidth(size);
    }
    public void black(View v){
        p.setColor(Color.BLACK);
    }
    public void white(View v){
        p.setColor(Color.WHITE);
    }
    public void red(View v){
        p.setColor(Color.RED);
    }
    public void blue(View v){
        p.setColor(Color.BLUE);
    }
    public void green(View v){
        p.setColor(Color.GREEN);
    }
    public void yellow(View v){
        p.setColor(Color.YELLOW);
    }

}