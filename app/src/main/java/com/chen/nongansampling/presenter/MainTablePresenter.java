package com.chen.nongansampling.presenter;

import android.app.Dialog;
import android.content.Context;

import com.chen.nongansampling.bean.OperatingBean;
import com.chen.nongansampling.bean.SimpleRequest;
import com.chen.nongansampling.bean.TodayResponseBean;
import com.chen.nongansampling.manager.DataManager;
import com.chen.nongansampling.model.CallbackData;
import com.chen.nongansampling.model.Market;
import com.chen.nongansampling.presenterView.BaseView;
import com.chen.nongansampling.presenterView.MainTableView;
import com.chen.nongansampling.presenterView.MarketView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainTablePresenter extends BasePresenter{
    private Context mContext;
    private MainTableView marketView;
    private TodayResponseBean callbackData;

//
//    @Override
//    public void BindPresentView(MainTableView presentView) {
//        marketView=(MarketView) presentView;
//    }


    @Override
    public void BindPresentView(Object presentView) {
        marketView=(MainTableView) presentView;

    }




    public void getTodayResponseInfo(SimpleRequest simpleRequest) {
        DataManager.getInstance(mContext).getTodayResponseInfo(simpleRequest)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<TodayResponseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(TodayResponseBean accountCallbackData) {

                        callbackData = accountCallbackData;
                    }



                    @Override
                    public void onError(Throwable e) {
                        marketView.onError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        if (callbackData != null) {
                            marketView.onSuccess(callbackData);
                        }
                        MainTablePresenter.super.compositeDisposable.dispose();
                    }
                });
    }


}
