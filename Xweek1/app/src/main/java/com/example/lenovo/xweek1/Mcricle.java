package com.example.lenovo.xweek1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Lenovo on 2017/3/10.
 * author ：李宁
 * 类注释：
 */

public class Mcricle extends TextView {
    private Paint paint=new Paint();

    public Mcricle(Context context) {
        super(context);
    }

    public Mcricle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Mcricle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //测量布局的宽高给固定的值
        setMeasuredDimension(200,220);
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
}
