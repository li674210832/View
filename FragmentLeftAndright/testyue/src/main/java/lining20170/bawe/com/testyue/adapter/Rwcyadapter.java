package lining20170.bawe.com.testyue.adapter;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import lining20170.bawe.com.testyue.R;
import lining20170.bawe.com.testyue.bb.bean;

/**
 * Created by Lenovo on 2017/3/30.
 * author ：李宁
 * 类注释：
 */

public class Rwcyadapter  extends RecyclerView.Adapter<Rwcyadapter.ViewHoldwerr>{
    private Context context;
    private List<bean.ResultBean.RowsBean> list;

    public Rwcyadapter(Context context, List<bean.ResultBean.RowsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHoldwerr onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);


        return new ViewHoldwerr(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHoldwerr holder, int position) {
        for (int i = 0; i < list.size(); i++) {
            holder.tv.setText(list.get(position).getInfo().getLoupan_name()+i);
            Glide.with(context).load(list.get(position).getInfo().getDefault_image()).into(holder.img);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  ViewHoldwerr extends RecyclerView.ViewHolder{

        private final TextView tv;
        private final ImageView img;

        public ViewHoldwerr(View itemView) {

            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            tv = (TextView) itemView.findViewById(R.id.tv);

        }
    }
}
