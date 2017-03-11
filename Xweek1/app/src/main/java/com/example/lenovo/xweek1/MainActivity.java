package com.example.lenovo.xweek1;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ArrayList mList;
    private TextView mTv;
  private Random random=new Random();
    private int count =0;

    private boolean flag = false;
    Handler  handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
                 if(msg.what==0){
                     mTv.setText(mList.get(count)+"");
                     mTv.setBackgroundColor(Color.parseColor(mList.get(count)+""));
                     if(count<mList.size()-1)
                         count++;
                 else
                         count=0;
                         handler.sendEmptyMessageDelayed(0,3000);

                 }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.main_tv);
        mTv.setTextSize(30);
        //初始化数据
        mList = new ArrayList<String>();
        /*mList.add("#6187c5");
        mList.add("#FFFFFF");
        mList.add("#BFBFBF");
        mList.add("#6699FF");
        mList.add("#FF9900");
        mList.add("#CC0000");*/
        for (int i = 0; i < 10; i++) {
            int a = random.nextInt(10);
            int b = random.nextInt(10);
            int c = random.nextInt(10);
            int d = random.nextInt(10);
            int e = random.nextInt(10);
            int f = random.nextInt(10);
            String ss="#"+a+b+c+d+e+f;
            mList.add(ss);
        }
        mTv.setText(mList.get(count)+"");
        mTv.setBackgroundColor(Color.parseColor(mList.get(count)+""));
          handler.sendEmptyMessageDelayed(0,3000);
               flag=true;
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if(flag){
                 flag=false;
                 Toast.makeText(MainActivity.this,"三秒事件关闭",Toast.LENGTH_SHORT).show();
                 handler.removeMessages(0);
             }else{
                 flag = true;
                 Toast.makeText(MainActivity.this,"三秒事件开启",Toast.LENGTH_SHORT).show();
                 //发送延迟消息
                 handler.sendEmptyMessageDelayed(0,3000);
             }

            }
        });

    }

}
