package com.example.lenovo.xweek1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Lenovo on 2017/3/10.
 * author ：李宁
 * 类注释：
 */

public class Cricle extends View {
    private Paint paint=new Paint();
    private Context mcontext;
    private float wai;
    private float nei;
    private int color;
    private float dimension;
    private String string;
    private int measuredWidth;
    private int measuredHeight;
    private Rect mrect;

    public Cricle(Context context) {
        this(context,null);
    }

    public Cricle(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Cricle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mcontext = context;
        //取出你自定义的属性
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CIRCLE);
        wai = ta.getDimension(R.styleable.CIRCLE_waiban, 40);
        nei = ta.getDimension(R.styleable.CIRCLE_neiban, 80);
        color = ta.getColor(R.styleable.CIRCLE_yuancolor, Color.RED);
        dimension = ta.getDimension(R.styleable.CIRCLE_textsize, 30);
        string = ta.getString(R.styleable.CIRCLE_te);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measuredHeight = getMeasuredHeight();
        measuredWidth = getMeasuredWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawRect(0,0,measuredWidth,measuredHeight,paint);
        paint.setColor(Color.RED);
        paint.setColor(Color.RED);
        canvas.drawCircle(measuredHeight/2,measuredWidth/2,nei,paint);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(measuredHeight/2,measuredWidth/2,wai,paint);
          paint.setTextSize(dimension);
        mrect = new Rect();
       paint.getTextBounds(string,0,string.length(),mrect);
        paint.setColor(Color.YELLOW);
      canvas.drawText(string,getWidth()/2 -mrect.width()/2,getHeight()/2+mrect.height()/2,paint);

        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                int a=(int) (y-measuredHeight/2);
               int b=(int) (x-measuredWidth/2);
                int c=a*a+b*b;
                //Math.sqrt 求开方
                if(Math.sqrt(c)>measuredWidth/2){
                    Toast.makeText(mcontext, "点击了正方形", Toast.LENGTH_SHORT).show();
                }else if(Math.sqrt(c)>measuredWidth/4){
                    Toast.makeText(mcontext, "点击了外圆", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(mcontext, "点击了內元", Toast.LENGTH_SHORT).show();

                }


                break;
        }

        return super.onTouchEvent(event);
    }
}
