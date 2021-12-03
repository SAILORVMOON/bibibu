package com.example.bibibu;


import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity implements View.OnTouchListener {

    float x, y;
    Path path;
    Paint p;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new MyDraw(this));
    }

    class MyDraw extends View{
        public MyDraw(Context context) {
            super(context);
            p = new Paint();
            p.setStrokeWidth(3);
            p.setStyle(Paint.Style.STROKE);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x = motionEvent.getX(), y = motionEvent.getX());
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x = motionEvent.getX(), y = motionEvent.getX());
                break;
            default:
                break;
        }
        return false;
    }
}
