package com.chen.nongansampling.fragment.ui.sample;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.chen.nongansampling.R;

import com.chen.nongansampling.adapter.ListviewRichTextAdapter;
import com.chen.nongansampling.adapter.ListviewTextAdapter;
import com.chen.nongansampling.bean.ui.ListviewBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SampleFragment extends Fragment {

    private SampleViewModel mViewModel;
    public static SampleFragment newInstance() {
        return new SampleFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      View  view=inflater.inflate(R.layout.sample_fragment, container, false);
        ButterKnife.bind(this, view);
  //      return inflater.inflate(R.layout.sample_fragment, container, false);
        return view;
    }
    @BindView(R.id.sample_text_listview) ListView textlistView;
    @BindView(R.id.sample_iamge_listview) ListView imagelistView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SampleViewModel.class);
        initListView();
        // TODO: Use the ViewModel
    }
    public void initListView(){
    //    listView=getView().findViewById(R.id.sample_text_listview);
        ListviewBean<String> list1=new ListviewBean();
        list1.setData("请选择");
        list1.setImageSrc(R.mipmap.market_name);
        list1.setName("市场名称");


        ListviewBean<String> list2=new ListviewBean();
        list2.setData("请选择");
        list2.setImageSrc(R.mipmap.sample_category);
        list2.setName("样品类别");



        ListviewBean<String> list3=new ListviewBean();
        list3.setData("请选择");
        list3.setImageSrc(R.mipmap.listview_text_operator);
        list3.setName("经营户");

        ListviewBean<String> list4=new ListviewBean();
        list4.setData("请选择");
        list4.setImageSrc(R.mipmap.listview_sample_name);
        list4.setName("样品名称");



        ListviewBean<String> list5=new ListviewBean();
        list5.setData("请选择");
        list5.setImageSrc(R.mipmap.listview_text_test_method);
        list5.setName("检测方法");




        ListviewBean<String> list6=new ListviewBean();
        list5.setData("请选择");
        list5.setImageSrc(R.mipmap.listview_text_test_method);
        list5.setName("采样照片");



        List<ListviewBean> list=new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);


        textlistView.setAdapter(new ListviewTextAdapter(list,getContext()));




//        imagelistView.setAdapter(new ListviewRichTextAdapter(list,getContext()));







    }

}
