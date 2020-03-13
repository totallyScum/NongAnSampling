package com.chen.nongansampling.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.chen.nongansampling.R;
import com.chen.nongansampling.adapter.ListviewTextAdapter;
import com.chen.nongansampling.bean.ui.ListviewBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends AppCompatActivity {
@BindView(R.id.setting_listview)
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        ListviewBean<String> list1=new ListviewBean();
        list1.setData("12010331011");
        list1.setImageSrc(R.mipmap.market_name);
        list1.setName("账号");


        ListviewBean<String> list2=new ListviewBean();
        list2.setData("检测师姓名");
        list2.setImageSrc(R.mipmap.setting_user_name);
        list2.setName("天塔检测师");



        ListviewBean<String> list3=new ListviewBean();
        list3.setData("天塔检测中心");
        list3.setImageSrc(R.mipmap.setting_department);
        list3.setName("所属单位");

        ListviewBean<String> list4=new ListviewBean();
        list4.setData("修改密码");
        list4.setImageSrc(R.mipmap.setting_password);
        list4.setName("》");






        List<ListviewBean> list=new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);



        listView.setAdapter(new ListviewTextAdapter(list,getApplicationContext()));


    }
}
