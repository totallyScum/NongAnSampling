package com.chen.nongansampling.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.nongansampling.R;
import com.chen.nongansampling.bean.ui.ListviewBean;

import java.util.List;

public class ListviewTextAdapter extends BaseAdapter
{
   private List<ListviewBean> list;
   private Context activity;

    public ListviewTextAdapter(List<ListviewBean> list, Context activity) {
        this.list=list;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return list.size();
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

        View view = LayoutInflater.from(activity).inflate(R.layout.listview_text_item,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.listview_text_image);
        TextView data = (TextView) view.findViewById(R.id.listview_text_data);
        TextView name = (TextView) view.findViewById(R.id.listview_text_name);


        imageView.setImageResource(list.get(position).getImageSrc());
        data.setText((String)list.get(position).getData());
        name.setText(list.get(position).getName());

     //   return null;
        return view;
    }
}
