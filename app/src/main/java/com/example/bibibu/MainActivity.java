package com.example.bibibu;


import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<Path> paths;
    Paint p;
    Path path;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new MyDraw(this));
        path = new Path();
        paths = new ArrayList<>();
    }

    class MyDraw extends View {
        public MyDraw(Context context) {
            super(context);
            p = new Paint();
            p.setColor(Color.BLACK);
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);


        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawCircle(50, 50, 10, p);
            for (int i =0; i< paths.size(); i++){
                canvas.drawPath(paths.get(i), p);
                invalidate();
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



}