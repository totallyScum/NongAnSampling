package com.chen.nongansampling.fragment.ui.businessarchives;

import androidx.lifecycle.ViewModelProviders;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.chen.nongansampling.bean.OperatingBean;
import com.chen.nongansampling.fragment.ArchivesListFragment;
import com.chen.nongansampling.R;
import com.chen.nongansampling.adapter.BusinessArchivesFragmentAdapter;
import com.chen.nongansampling.bean.SimpleRequest;
import com.chen.nongansampling.model.CallbackData;
import com.chen.nongansampling.model.Market;
import com.chen.nongansampling.presenter.MarketPresenter;
import com.chen.nongansampling.presenterView.BaseView;
import com.chen.nongansampling.presenterView.MarketView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class BusinessArchivesFragment extends Fragment implements MarketView {

    private BusinessArchivesViewModel mViewModel;

    private OnFragmentInteractionListener mListener;
    private String mTitles[] = {
            "用户注册", "管理员注册"};
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MarketPresenter marketPresenter=new MarketPresenter(getContext());


    private ArrayList<String> tab_title_list = new ArrayList<>();//存放标签页标题
    private ArrayList<Fragment> fragment_list = new ArrayList<>();//存放ViewPager下的Fragment
    private   Fragment fragment1, fragment2, fragment3, fragment4;
    private BusinessArchivesFragmentAdapter adapter;//适配器

    //private RegisterFragmentAdapter adapter;//适配器
    private Toolbar toolbar;

    public static BusinessArchivesFragment newInstance() {
        return new BusinessArchivesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.business_archives_fragment, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        marketPresenter.onCreate();
        marketPresenter.BindPresentView(this);
        SimpleRequest simpleRequest=new SimpleRequest();
        simpleRequest.setAccountPkId("1");
        marketPresenter.getMarketResponseInfo(simpleRequest);


        SimpleRequest simpleRequest1=new SimpleRequest();
        simpleRequest1.setAccountPkId("1");
        marketPresenter.getOperatingResponseInfo(simpleRequest);




        mViewModel = ViewModelProviders.of(this).get(BusinessArchivesViewModel.class);
        tabLayout = (TabLayout) getActivity().findViewById(R.id.my_tablayout);
        viewPager = (ViewPager) getActivity().findViewById(R.id.my_viewpager);
        tabLayout.setupWithViewPager(viewPager);//将TabLayout与Viewpager联动起来


        // TODO: Use the ViewModel
    }

    @Override
    public void onError(String result) {
        Log.d("qqqqqq",result.toString());

    }

    @Override
    public void onSuccess(Object resultData) {
        Log.d("qqqqqq",resultData.toString());

        if (resultData!=null)
        {
            Log.d("qqqqqq","onSuccess");

            CallbackData<List<Market>> callbackData=(CallbackData<List<Market>>)resultData;
            List<Market>list=callbackData.getData();
            for (Market market:list)
            {
              Fragment  fragment = new ArchivesListFragment();
                fragment_list.add(fragment);
                tab_title_list.add(market.getName());
                tabLayout.addTab(tabLayout.newTab().setText(market.getName()));
                adapter = new BusinessArchivesFragmentAdapter(getChildFragmentManager(), tab_title_list, fragment_list);
                viewPager.setOffscreenPageLimit(2);
                viewPager.setAdapter(adapter);//给ViewPager设置适配器
            }
        }
//        fragment1 = new ArchivesListFragment();
//        fragment2 = new ArchivesListFragment();
//        fragment_list.clear();
//        fragment_list.add(fragment1);
//        fragment_list.add(fragment2);
//        tab_title_list.add("用户注册");
//        tab_title_list.add("管理员注册");
//        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(0)));
//        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(1)));
//
//        adapter = new BusinessArchivesFragmentAdapter(getChildFragmentManager(), tab_title_list, fragment_list);
//        viewPager.setOffscreenPageLimit(2);
//        viewPager.setAdapter(adapter);//给ViewPager设置适配器
    }

    @Override
    public void getOperatorList(Object resultData) {


        if (resultData!=null)
        {
            Log.d("qqqqqq","onSuccess");

            CallbackData<List<OperatingBean>> callbackData=(CallbackData<List<OperatingBean>>)resultData;
//            List<OperatingBean>list=callbackData.getData();
//            for (OperatingBean operatingBean:list)
//            {
////                Fragment  fragment = new ArchivesListFragment();
////                fragment_list.add(fragment);
////                tab_title_list.add(market.getName());
////                tabLayout.addTab(tabLayout.newTab().setText(market.getName()));
////                adapter = new BusinessArchivesFragmentAdapter(getChildFragmentManager(), tab_title_list, fragment_list);
////                viewPager.setOffscreenPageLimit(2);
////                viewPager.setAdapter(adapter);//给ViewPager设置适配器
//            }
        }

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }    @Override
    public void onResume() {
        super.onResume();



    }
}
