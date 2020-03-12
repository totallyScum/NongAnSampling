package com.chen.nongansampling.presenter;

import android.content.Context;

import com.chen.nongansampling.bean.RiskMonitoringResponseBean;
import com.chen.nongansampling.manager.DataManager;
import com.chen.nongansampling.model.Account;
import com.chen.nongansampling.model.CallbackData;
import com.chen.nongansampling.presenterView.BaseView;
import com.chen.nongansampling.presenterView.BusinessArchivesView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GetRiskMonitoringPresenter extends BasePresenter{
    private Context mContext;
    private BusinessArchivesView baseView;

    private CallbackData<Account> mLoginResponseBody;


    private CallbackData<List<RiskMonitoringResponseBean>> resultData2;

    public GetRiskMonitoringPresenter(Context context){
        this.mContext = context;
    }

//    @Override
//    public void BindPresentView(BaseView presentView) {
//        baseView = (BusinessArchivesView)presentView;
//    }

    @Override
    public void BindPresentView(Object presentView) {
        baseView = (BusinessArchivesView)presentView;

    }


    public void GetSamplingResponsePv() {
        DataManager.getInstance(mContext).getRiskMonitoringResponseInfo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CallbackData<List<RiskMonitoringResponseBean>>>(){
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CallbackData<List<RiskMonitoringResponseBean>> listCallbackData) {
                        resultData2 = listCallbackData;

                    }


                    @Override
                    public void onError(Throwable e) {
                        baseView.onError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        if (resultData2 != null) {
                            baseView.onSuccess(resultData2);

                        }
                        GetRiskMonitoringPresenter.super.compositeDisposable.dispose();
                    }
                });

    }



}
