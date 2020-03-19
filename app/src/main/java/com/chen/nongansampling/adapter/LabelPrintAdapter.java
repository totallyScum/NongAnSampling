package com.chen.nongansampling.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.chen.nongansampling.R;

import java.util.List;

public class LabelPrintAdapter extends BaseAdapter {
    private List<String> leftList;   //创建一个StudentData 类的对象 集合
    private List<String> rightList;   //创建一个StudentData 类的对象 集合
private Context context;
    private LayoutInflater inflater;




    public  LabelPrintAdapter (List<String> left, List<String> right, Context context) {
        this.leftList = left;
        this.rightList = right;
        this.context = context;
        this.inflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return leftList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.label_printed_listview_item,null);

        TextView left = (TextView) view.findViewById(R.id.label_left_text);
        TextView right = (TextView) view.findViewById(R.id.label_right_text);

        left.setText(leftList.get(position));
        right.setText(rightList.get(position));

        return view;
    }
//    class MyViewHolder extends RecyclerView.ViewHolder {
//        public TextView leftText, rightText;
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            leftText = itemView.findViewById(R.id.label_left_text);
//            rightText=itemView.findViewById(R.id.label_right_text);
//
//
//        }
//    }
}
