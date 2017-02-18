package com.ankit.paint;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;

public class MainActivity extends AppCompatActivity
{
    int hr=0,min=0,sec=0,mi=0,flag=0;
    public Timer t = new Timer();
    private void update()
    {
        mi++;
        if(mi>=10)
        {
            mi = 0;
            sec++;
        }
        if(sec>=60)
        {
            sec=0;
            min++;
        }
        if(min>=60)
        {
            min=0;
            hr++;
        }
    }
    private void reset()
    {
        hr=0;
        min=0;
        sec=0;
        mi=0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Paint paint = new Paint();
        final Bitmap bg = Bitmap.createBitmap(720, 1020, Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bg);
        //final Random rand = new Random();
        final LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
        final Handler mHandler = new Handler() {
            public void handleMessage(Message msg) {
                ll.setBackgroundDrawable(new BitmapDrawable(bg));
            }
        };
        View v = findViewById(R.id.rect);
        paint.setColor(Color.RED);
        canvas.drawCircle(720 / 2, 1020 / 2, 250, paint);
        paint.setColor(Color.parseColor("#ffffff"));
        canvas.drawCircle(720 / 2, 1020 / 2, 200, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
        canvas.drawText("0 : 00 : 00 : 0", 720 / 4 + 50, 1020 / 2, paint);
        ll.setBackgroundDrawable(new BitmapDrawable(bg));
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                //Log.i("ANKIT", Double.toString((double)x) + " " + Double.toString((double)y));
                if((x-720/2)*(x-720/2)+(y-1020/2)*(y-1020/2)<=40000)
                {
                    if(flag==0)
                    {
                        t=new Timer();
                        t.scheduleAtFixedRate(new TimerTask() {
                            @Override
                            public void run() {
                /*int a = rand.nextInt(256);
                int b = rand.nextInt(256);
                int c = rand.nextInt(256);
                int d = rand.nextInt(520);
                int e = rand.nextInt(820);
                f=d;
                g=e;
                //Log.i("ANKIT", Integer.toString(d) + " " + Integer.toString(e));
                paint.setColor(Color.rgb(a, b, c));
                canvas.drawRect(d, e, d + 200, e + 200, paint);
                paint.setColor(Color.parseColor("#ffffff"));
                canvas.drawArc(new RectF(d,e,d+200,e+200),90f,360f,true,paint);
                Path path = new Path();
                paint.setColor(Color.rgb(c, b, a));
                path.moveTo(d+100,e);
                path.lineTo(d+200,e+150);
                path.lineTo(d,e+150);
                path.moveTo(d,e+150);
                path.lineTo(d+200,e+150);
                path.close();
                canvas.drawPath(path,paint);
                mHandler.obtainMessage(1).sendToTarget();*/
                                paint.setColor(Color.RED);
                                canvas.drawCircle(720 / 2, 1020 / 2, 250, paint);
                                paint.setColor(Color.parseColor("#ffffff"));
                                canvas.drawCircle(720 / 2, 1020 / 2, 200, paint);
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(50);
                                canvas.drawText(String.format("%d : %02d : %02d : %d", hr, min, sec, mi), 720 / 4 + 50, 1020 / 2, paint);
                                update();
                                mHandler.obtainMessage(1).sendToTarget();
                            }
                        }, 0, 100);
                        flag = 1;
                    }
                    else
                    {
                        t.cancel();
                        flag = 0;
                    }
                }
                else if((x-720/2)*(x-720/2)+(y-1020/2)*(y-1020/2)<=62500)
                {
                    reset();
                    t.cancel();
                    flag = 0;
                    paint.setColor(Color.RED);
                    canvas.drawCircle(720 / 2, 1020 / 2, 250, paint);
                    paint.setColor(Color.parseColor("#ffffff"));
                    canvas.drawCircle(720 / 2, 1020 / 2, 200, paint);
                    paint.setColor(Color.BLACK);
                    paint.setTextSize(50);
                    canvas.drawText("0 : 00 : 00 : 0", 720 / 4 + 50, 1020 / 2, paint);
                    mHandler.obtainMessage(1).sendToTarget();
                }

                /*if(x>=f&&x<=f+200&&y>=g&&y<=g+200)
                {
                    paint.setColor(Color.parseColor("#ffffff"));
                    canvas.drawRect(0, 0, 720, 1020, paint);
                }*/
                return false;
            }
        });

    }
        // Example of a call to a native method
        /*TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        tv.append(stringFromAnkit());*/
}

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    /*public native String stringFromJNI();
    public native String stringFromAnkit();
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }*/

