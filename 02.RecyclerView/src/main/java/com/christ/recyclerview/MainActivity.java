package com.christ.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.christ.recyclerview.module.ItemBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mMainRv;
    private ArrayList<ItemBean> mItemBeen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        mMainRv = (RecyclerView) findViewById(R.id.main_rv);
        //1.创建数据来显示
        mItemBeen = createBean();
        //2.创建适配器
        ItemAdapter itemAdapter = new ItemAdapter(this, mItemBeen);
        //3.设置布局管理器
        mMainRv.setLayoutManager(new LinearLayoutManager(this));
        //4.设置rv设置适配器，显示数据
        mMainRv.setAdapter(itemAdapter);
    }

    private ArrayList<ItemBean> createBean() {
        ArrayList<ItemBean> itemBeen = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            ItemBean bean = new ItemBean();
            bean.setName("选项" + i);
            bean.setImageRes(R.drawable.p1 + i); //图片有规律的话，图片的id是递增的
            itemBeen.add(bean);
        }
        return itemBeen;
    }
}
