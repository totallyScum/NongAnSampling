package com.chen.nongansampling.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.chen.nongansampling.R;
import com.chen.nongansampling.bean.RiskMonitoringResponseBean;

import java.util.List;

public class RiskMonitorRecycleViewAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder>{
        private List<RiskMonitoringResponseBean> list;
private Context view;
//        public NewsAdapter(List<News> list) {
//            this.list = list;
//        }
       public RiskMonitorRecycleViewAdapter(Context context, List<RiskMonitoringResponseBean> list) {
            this.view = context;
            this.list=list;
       }
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = null;
            v = LayoutInflater.from(view).inflate(R.layout.risk_monitor_recycleview_item, parent, false);
            RecyclerView.ViewHolder holder = null;
            holder = new MyViewHolder(v);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((MyViewHolder) holder).sampleName.setText(list.get(position).getSampleName());
            ((MyViewHolder) holder).sampleNumber.setText(list.get(position).getSampleNumber());
            ((MyViewHolder) holder).samplingTime.setText(list.get(position).getSamplingTime().split("T")[0]);
            ((MyViewHolder) holder).boothNumber.setText(list.get(position).getBoothNumber());
            ((MyViewHolder) holder).operatingHouseholds.setText(list.get(position).getOperatingHouseholds());
            ((MyViewHolder) holder).result.setText(list.get(position).getResult());
            ((MyViewHolder) holder).type.setText(list.get(position).getType());
//            ((MyViewHolder) holder).time.setText(list.get(position).time);
//            ((MyViewHolder) holder).source.setText(list.get(position).source);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

    }

class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView sampleName, samplingTime, boothNumber,sampleNumber,operatingHouseholds,result,type;

    public MyViewHolder(View itemView) {
        super(itemView);
        sampleName = itemView.findViewById(R.id.sampleName);
        boothNumber=itemView.findViewById(R.id.boothNumber);
        operatingHouseholds=itemView.findViewById(R.id.operatingHouseholds);
        samplingTime=itemView.findViewById(R.id.samplingTime);
        sampleNumber=itemView.findViewById(R.id.sampleNumber);
        result=itemView.findViewById(R.id.result);
        type=itemView.findViewById(R.id.type);

    }
}


