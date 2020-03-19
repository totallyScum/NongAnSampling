package com.chen.nongansampling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.chen.nongansampling.activity.SettingActivity;
import com.chen.nongansampling.bean.SimpleRequest;
import com.chen.nongansampling.bean.TodayResponseBean;
import com.chen.nongansampling.fragment.BusinessArchivesActivity;
import com.chen.nongansampling.fragment.RiskMonitorActivity;
import com.chen.nongansampling.fragment.SampleActivity;
import com.chen.nongansampling.presenter.MainTablePresenter;
import com.chen.nongansampling.presenter.MarketPresenter;
import com.chen.nongansampling.presenterView.MainTableView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener , MainTableView {
    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    @BindView(R.id.user_icon)
    ImageView userSetting;
    // 图片封装为一个数组
    private int[] icon = { R.mipmap.main_sample_mission,R.mipmap.main_sample_doc,R.mipmap.main_sample_setting,R.mipmap.main_sample_anno,R.mipmap.main_sample_risk};
    private String[] iconName = { "采样任务","经营户档案","设置","通知公告","风险监测" };
    private MainTablePresenter  marketPresenter=new MainTablePresenter();

    @BindView(R.id.samplingCount)
    TextView samplingCount;


    @BindView(R.id.detectionCount)
    TextView detectionCount;


    @BindView(R.id.trueDetectionCount)
    TextView trueDetectionCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        gview = (GridView) findViewById(R.id.main_gridview);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.gridview_imge,R.id.gridview_text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.main_gridview_item, from, to);
        //配置适配器
        gview.setAdapter(sim_adapter);
        gview.setOnItemClickListener(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        marketPresenter.onCreate();
        marketPresenter.BindPresentView(this);
        SimpleRequest simpleRequest=new SimpleRequest();
        simpleRequest.setAccountPkId("1");
        marketPresenter.getTodayResponseInfo(simpleRequest);
    }

    @OnClick(R2.id.user_icon )   //给 button1 设置一个点击事件
    public void showToast(){

    }

    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("click",position+"");
        switch (position)
        {
            case 0:{
                Intent intent=new Intent(this, SampleActivity.class);
                startActivity(intent);
            }break;
            case 1:{
                Intent intent=new Intent(this, BusinessArchivesActivity.class);
                startActivity(intent);
                }break;
            case 2:{
                Intent intent=new Intent(this, SettingActivity.class);
                startActivity(intent);
            }break;
            case 4:{
                Intent intent=new Intent(this, RiskMonitorActivity.class);
                startActivity(intent);
            }break;
//            case 2:{
//                }break;
//            case 3:{
//                }break;
        }
        if (position==1)
        {

        }
    }

    @Override
    public void onError(String result) {

    }

    @Override
    public void onSuccess(Object resultData) {
        TodayResponseBean todayResponseBean=(TodayResponseBean)resultData;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                samplingCount.setText(todayResponseBean.getSamplingCount()+"批次");
                detectionCount.setText(todayResponseBean.getDetectionCount()+"批次");
                trueDetectionCount.setText(todayResponseBean.getTrueDetectionCount()+"批次" );
            }
        });



    }
}
