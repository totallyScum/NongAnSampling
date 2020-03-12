package com.chen.nongansampling.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chen.nongansampling.R;
import com.chen.nongansampling.bean.ui.ListviewTextBean;

import java.util.List;

public class ListviewRichTextAdapter extends BaseAdapter {
    private List<ListviewTextBean> list;
    private Context activity;

    public ListviewRichTextAdapter(List<ListviewTextBean> list, Context activity) {
        this.list=list;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return 6;
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

        View view = LayoutInflater.from(activity).inflate(R.layout.listview_rich_text_item,null);
//        ImageView imageView = (ImageView) view.findViewById(R.id.listview_text_image);
//        TextView data = (TextView) view.findViewById(R.id.listview_text_data);
//        TextView name = (TextView) view.findViewById(R.id.listview_text_name);
//
//
//        imageView.setImageResource(list.get(position).getImageSrc());
//        data.setText(list.get(position).getData());
//        name.setText(list.get(position).getName());

        //   return null;
        return view;
    }
}
