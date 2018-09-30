package com.fmj.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fmj.app.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.text.DecimalFormat;


public class GoodsListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<HashMap> mdata;

    public GoodsListAdapter(Context context, ArrayList<HashMap> data) {

        inflater = LayoutInflater.from(context);

        mdata = data;

        Log.d("------data_length-----",String.valueOf(mdata.size()));

    }

    @Override
    public Object getItem(int position) {
        return mdata.get(position);
    }

    @Override
    public int getCount() {
        return mdata.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 获取布局
        convertView = inflater.inflate(R.layout.list_item,null);
        HashMap item = mdata.get(position);

        ImageView img = convertView.findViewById(R.id.img);
        // 设置图片
        img.setImageResource((int)item.get("img"));

        TextView name = convertView.findViewById(R.id.name);
        name.setText(String.valueOf(item.get("name")));

        TextView num = convertView.findViewById(R.id.num);
        num.setText("x"+String.valueOf(item.get("num")));

        TextView money = convertView.findViewById(R.id.money);
        DecimalFormat df = new DecimalFormat("#.00");
        money.setText("￥"+String.valueOf(df.format(item.get("money"))));

        return convertView;
    }

}
