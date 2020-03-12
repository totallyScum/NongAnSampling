package com.chen.nongansampling.presenter;

import android.app.Dialog;
import android.content.Context;

import com.chen.nongansampling.bean.LoginRequest;
import com.chen.nongansampling.bean.OperatingBean;
import com.chen.nongansampling.bean.SimpleRequest;
import com.chen.nongansampling.manager.DataManager;
import com.chen.nongansampling.model.Account;
import com.chen.nongansampling.model.CallbackData;
import com.chen.nongansampling.model.Market;
import com.chen.nongansampling.presenterView.BaseView;
import com.chen.nongansampling.presenterView.BusinessArchivesView;
import com.chen.nongansampling.presenterView.MarketView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MarketPresenter extends BasePresenter {
    private Context mContext;
    private MarketView marketView;
    private CallbackData<List<Market>> callbackData;
    private CallbackData<List<OperatingBean>> operatorBeanList;
    private Dialog mDialog;

    public MarketPresenter(Context context){
        this.mContext = context;
    }

//    @Override
//    public void BindPresentView(BaseView presentView) {
//        baseView = presentView;
//    }

    //在presenter中实现业务逻辑，此处会调用前面封装好的retrofit的东西
    //将处理结果绑定到对应的PresentView实例，这样Activity和PresentView实例绑定好之后，
    //Activity->PresentView->Presenter->retrofit的关系就打通了
    public void getMarketResponseInfo(SimpleRequest simpleRequest) {
        DataManager.getInstance(mContext).getMarketResponseInfo(simpleRequest)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CallbackData<List<Market>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CallbackData<List<Market>> accountCallbackData) {

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
                        MarketPresenter.super.compositeDisposable.dispose();
                    }
                });
    }




    public void getOperatingResponseInfo(SimpleRequest simpleRequest) {
        DataManager.getInstance(mContext).getOperatingResponseInfo(simpleRequest)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CallbackData<List<OperatingBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CallbackData<List<OperatingBean>> accountCallbackData) {

                        operatorBeanList = accountCallbackData;
                    }



                    @Override
                    public void onError(Throwable e) {
                        marketView.onError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        if (callbackData != null) {
                            marketView.getOperatorList(callbackData);
                        }
                        MarketPresenter.super.compositeDisposable.dispose();
                    }
                });
    }


    @Override
    public void BindPresentView(Object presentView) {
        marketView = (MarketView) presentView;

    }
}
