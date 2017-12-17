package com.christ.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.christ.recyclerview.module.ItemBean;

import java.util.ArrayList;

/**
 * Created by Christ on 2017/12/17.
 */

public class ItemAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<ItemBean> mList;

    /**
     * 创建构造器的时候，传递两个数据
     *
     * @param context
     * @param list
     */
    public ItemAdapter(Context context, ArrayList<ItemBean> list) {
        mContext = context;
        mList = list;
    }

    /**
     * 当RecyclerView需要一个ViewHolder时会回调该方法，如果有可复用的View则该方法不会得到调用
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建itemView
        //false:表示item布局不添加到parent(RecyclerView)中
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_view, parent, false);
        //创建viewholder并返回
        return new MyViewHolder(itemView);
    }

    /**
     * 当一个View需要出现在屏幕上时，该方法会被回调，你需要在该方法中根据数据来更改视图
     * 显示item的子控件
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //获取到holder对象
        MyViewHolder viewHolder = (MyViewHolder) holder;

        //获取position位置对应的实体数据
        final ItemBean itemBean = mList.get(position);

        //显示item中的子控件
        viewHolder.mTvTitle.setText(itemBean.getName());
        viewHolder.mIvImage.setImageResource(itemBean.getImageRes());

        //设置item点击事件,相等于列表点击事件
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击了列表项
                onItemClick(position, itemBean);
            }
        });
    }

    /**
     * 点击了列表项
     *
     * @param position 位置
     * @param bean     数据
     */
    private void onItemClick(int position, ItemBean bean) {
        showToast(bean.getName());
    }

    /**
     * 有多少个
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return (mList == null) ? 0 : mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIvImage;
        private TextView mTvTitle;

        //itemView:item布局
        public MyViewHolder(View itemView) {
            super(itemView);
            mIvImage = (ImageView) itemView.findViewById(R.id.iv_image);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    private Toast mToast;

    public void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, "", Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }
}
