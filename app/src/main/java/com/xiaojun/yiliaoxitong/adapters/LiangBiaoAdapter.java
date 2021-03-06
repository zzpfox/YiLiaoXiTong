package com.xiaojun.yiliaoxitong.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaojun.yiliaoxitong.R;
import com.xiaojun.yiliaoxitong.beans.LiangBiaoBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/3.
 */


public class LiangBiaoAdapter extends RecyclerView.Adapter<LiangBiaoAdapter.ViewHolder> {
    private List<LiangBiaoBean.DataBean.GuagesBean.RowsBean> datas;
    private Context context=null;

    public LiangBiaoAdapter(List<LiangBiaoBean.DataBean.GuagesBean.RowsBean> datas, Context context) {
        this.datas = datas;
        this.context=context;

    }


    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.yuangong_item,viewGroup,false);
        return new ViewHolder(view);

    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        //判断是否显示字母标题

        viewHolder.mingcheng.setText(datas.get(position).getInventory_name());
        viewHolder.bianhao.setText(datas.get(position).getId()+"");
        if (datas.get(position).getStatus()==1){
            viewHolder.caozuo.setText("已完成答题");
           // Log.d("DengJiActivity", "DengJiActivity");
        }else {
            viewHolder.caozuo.setText("开始答题");
        }

        viewHolder.shijian.setText(datas.get(position).getCreate_time());
        if (position%2==1){
            viewHolder.top_bg.setBackgroundResource(R.color.huise3);
        }else {
            viewHolder.top_bg.setBackgroundResource(R.color.write);
        }



    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
      class ViewHolder extends RecyclerView.ViewHolder {
      private   TextView bianhao,mingcheng,shijian,caozuo;
      private LinearLayout top_bg;


        private ViewHolder(View view){
            super(view);
           bianhao= (TextView) view.findViewById(R.id.xuhao);
            mingcheng= (TextView) view.findViewById(R.id.mingcheng);
            shijian= (TextView) view.findViewById(R.id.shijian);
            caozuo= (TextView) view.findViewById(R.id.caozuo);
            top_bg= (LinearLayout) view.findViewById(R.id.top_bg);


        }
    }



}
