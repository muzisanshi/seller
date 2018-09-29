package com.fmj.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Button;
import android.view.WindowManager;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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



    }
}
