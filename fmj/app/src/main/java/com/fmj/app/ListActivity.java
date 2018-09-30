package com.fmj.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.fmj.adapter.*;

import java.util.HashMap;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView goodsList = this.findViewById(R.id.goods_list);
        ArrayList<HashMap> data = new ArrayList();

        for(int i=0;i<5;i++){
            HashMap item = new HashMap();
            item.put("img",R.drawable.fruit);
            item.put("name","苹果");
            item.put("num",1);
            item.put("money",6.00);
            data.add(i,item);
        }

        GoodsListAdapter adapter = new GoodsListAdapter(this,data);
        goodsList.setAdapter(adapter);

        Button calcu = (Button)findViewById(R.id.to_pay);
        calcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListActivity.this, QrcodeActivity.class);
                startActivity(intent);
            }
        });
    }
}
