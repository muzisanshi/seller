package com.fmj.app;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.view.WindowManager;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private boolean isCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isCover = false;

        WindowManager wm = this.getWindowManager();
        int ww = wm.getDefaultDisplay().getWidth();
        int wh = wm.getDefaultDisplay().getHeight();


        ImageView ad = (ImageView)this.findViewById(R.id.imageView);
        Button order = (Button)this.findViewById(R.id.order);

        // 设置图片等比缩放
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = 1;
        opts.inJustDecodeBounds = false;
        Bitmap mBitmap =BitmapFactory.decodeResource(getResources(), R.drawable.ad, opts);
        int width=opts.outWidth;
        int height=opts.outHeight;
//        Log.d("--------尺寸_w--------",String.format("%d",width));
//        Log.d("--------尺寸_h--------",String.format("%d",height));
        float rate = height/(float)width;
//        Log.d("--------比例--------",String.format("%.2f",rate));

//        order.setText(""+width+","+height+","+rate);

        ViewGroup.LayoutParams lp = ad.getLayoutParams();
        lp.width = ww;
        lp.height = (int)(ww*rate);

        ad.setLayoutParams(lp);

        // 设置遮罩层下面的视图不响应点击
        final LinearLayout cover = (LinearLayout)findViewById(R.id.cover);
        cover.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isCover){
                    cover.setVisibility(View.VISIBLE);
                    isCover = true;

                    // 定时打开扫描结果
                    CountDownTimer timer = new CountDownTimer(10000,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            Log.d("--------onTick--------","onTick");
                        }

                        @Override
                        public void onFinish() {
                            Log.d("--------onFinish--------","onFinish");
                            // 跳转到列表页面
                            cover.setVisibility(View.GONE);
                            isCover = false;
                            Intent intent=new Intent(MainActivity.this, ListActivity.class);
                            startActivity(intent);
                        }
                    };
                    timer.start();

                }
            }
        });

    }
}
