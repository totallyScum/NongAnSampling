package com.chen.nongansampling.fragment.ui.riskmonitor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.chen.nongansampling.R;
import com.chen.nongansampling.adapter.RiskMonitorRecycleViewAdapter;
import com.chen.nongansampling.bean.RiskMonitoringResponseBean;
import com.chen.nongansampling.model.CallbackData;
import com.chen.nongansampling.presenter.GetRiskMonitoringPresenter;
import com.chen.nongansampling.presenterView.BaseView;
import com.chen.nongansampling.presenterView.RiskMonitorView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RiskMonitorFragment extends Fragment  implements RiskMonitorView {

    private RiskMonitorViewModel mViewModel;
    private GetRiskMonitoringPresenter marketPresenter=new GetRiskMonitoringPresenter(getContext());

    public static RiskMonitorFragment newInstance() {
        return new RiskMonitorFragment();
    }
    @BindView(R.id.recycler_view)
    androidx.recyclerview.widget.RecyclerView rv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.risk_monitor_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RiskMonitorViewModel.class);

        marketPresenter.onCreate();
        marketPresenter.BindPresentView(this);
        marketPresenter.GetSamplingResponsePv();

        // TODO: Use the ViewModel


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        //默认就是垂直方向的
        ((LinearLayoutManager) layoutManager).setOrientation(OrientationHelper.VERTICAL);

    }


    @Override
    public void onError(String result) {

        Log.d("233333",result.toString());
    }

    @Override
    public void onSuccess(Object resultData) {
        Log.d("233333",resultData.toString());

        if (resultData!=null)
        {
            Log.d("qqqqqq","onSuccess");

            CallbackData<List<RiskMonitoringResponseBean>> callbackData=(CallbackData<List<RiskMonitoringResponseBean>>)resultData;
            List<RiskMonitoringResponseBean>list=callbackData.getData();


            Log.d("qqqqqq",list.toString());
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //     ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(),R.layout.item_select, spinnerItems);
                    rv.setAdapter(new RiskMonitorRecycleViewAdapter(getContext(),list));
                }
            });


        }





    }
}
