package lining20170.bawe.com.testyue;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Lenovo on 2017/3/29.
 * author ：李宁
 * 类注释：
 */

public class Myview extends View {
    private int ON_CIRCLE=1;
    private int ON_OUTCIRCLE=2;
    private Paint paint=new Paint();
    private int width;
    private int height;
    private float dowx;
    private float downy;
private ONCricleClick onCricleClick;
    public Myview(Context context) {
        super(context);
    }

    public Myview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Myview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public  void setonCricleClick(ONCricleClick onCricleClick){
        this.onCricleClick=onCricleClick;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        height = getHeight() / 2;
        width = getWidth()/2;
       paint.setAntiAlias(true);

        paint.setColor(Color.YELLOW);
        canvas.drawRect(width-80,height-80,width+80,height+80,paint);

        paint.setColor(Color.BLUE);
        canvas.drawCircle(width,height,80,paint);

        paint.setColor(Color.WHITE);
        canvas.drawCircle(width,height,40,paint);
        paint.setColor(Color.RED);
        paint.setTextSize(25);
        canvas.drawText("圆环",width-20,height+10,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                dowx = event.getX();
                downy = event.getY();

                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                float upx = event.getX();
                float upy = event.getY();
                if(upx==dowx &&upy==downy){
                    int currentloction = getCurrentloction(upx, upy);
                    if(currentloction==ON_CIRCLE){
                        if(onCricleClick!=null){
                            onCricleClick.onClickInnerCircle();
                        }
                    }else if(currentloction==ON_OUTCIRCLE){
                        if(onCricleClick!=null){
                            onCricleClick.onClickOutterCirle();
                        }
                    }
                }
                break;
        }

        return true;
    }
    public  int  getCurrentloction(float x,float y){
        float v=(x-width)*(x-width)+(y-height)*(y-height);
        double sqrt = Math.sqrt(v);//开根号    25  =5
        if(sqrt<40){
            return ON_CIRCLE;
        }else if(sqrt>40&&sqrt<80){
          return  ON_OUTCIRCLE;
        }
        return -1;
    }

    public  interface  ONCricleClick{
        public void onClickInnerCircle();
        public void onClickOutterCirle();
    }
}
