package com.chen.nongansampling.presenter;

import android.content.Context;
import android.util.Log;

import com.chen.nongansampling.bean.Callback;
import com.chen.nongansampling.bean.OperatingBean;
import com.chen.nongansampling.bean.RiskMonitoringResponseBean;
import com.chen.nongansampling.bean.SimpleRequest;
import com.chen.nongansampling.bean.sample.TypeList;
import com.chen.nongansampling.bean.sample.insert.SamplingRequset;
import com.chen.nongansampling.manager.DataManager;
import com.chen.nongansampling.model.CallbackData;
import com.chen.nongansampling.model.Market;
import com.chen.nongansampling.presenterView.RiskMonitorView;
import com.chen.nongansampling.presenterView.SampleView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SamplePresenter   extends BasePresenter {
    private Context mContext;

    private SampleView sampleView;
    private CallbackData<List<RiskMonitoringResponseBean>> resultData2;
    private CallbackData<List<Market>> callbackData;
    private CallbackData<List<OperatingBean>> operatorBeanList;
    private CallbackData<List<TypeList>> typelist;
    private CallbackData<List<TypeList>> typelistDeTypeAndName;
    private Callback inSertcallbackData;


    public SamplePresenter(Context context){
        this.mContext = context;
    }


    @Override
    public void BindPresentView(Object presentView) {
        sampleView = (SampleView) presentView;

    }




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
                        sampleView.onError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        if (callbackData != null) {
                            sampleView.getMarketList(callbackData);
                        }
                        SamplePresenter.super.compositeDisposable.dispose();
                    }
                });
    }
    public void getOperatingResponseInfo(SimpleRequest simpleRequest) {    //获取人员名称
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
                        sampleView.onError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        if (operatorBeanList != null) {
                            sampleView.getOperatorList(operatorBeanList);
                            Log.d("qqqqqq",operatorBeanList.toString());
                        }
                        SamplePresenter.super.compositeDisposable.dispose();
                    }
                });
    }



    public void getSamplingNameResponseInfo(SimpleRequest simpleRequest) {    //获取人员名称
        DataManager.getInstance(mContext).getSamplingNameResponseInfo(simpleRequest)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CallbackData<List<TypeList>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CallbackData<List<TypeList>> listCallbackData) {
                        typelist = listCallbackData;

                    }

//                    @Override
//                    public void onNext(CallbackData<List<OperatingBean>> accountCallbackData) {
//
//                        operatorBeanList = accountCallbackData;
//                    }



                    @Override
                    public void onError(Throwable e) {
                        sampleView.onError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        if (typelist != null) {
                            sampleView.getSamplingName(typelist);

                            Log.d("typelist",typelist.getData().size()+"");


                            Log.d("typelist",typelist.getData().get(0).getList().get(0).getName()+"");



                            Log.d("typelist",typelist.toString());
                        }
                        SamplePresenter.super.compositeDisposable.dispose();
                    }
                });
    }






    public void getDeTypeAndNameResponseInfo(SimpleRequest simpleRequest) {    //获取人员名称
        DataManager.getInstance(mContext).getDeTypeAndNameResponseInfo(simpleRequest)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CallbackData<List<TypeList>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CallbackData<List<TypeList>> listCallbackData) {
                        typelistDeTypeAndName = listCallbackData;

                    }

//                    @Override
//                    public void onNext(CallbackData<List<OperatingBean>> accountCallbackData) {
//
//                        operatorBeanList = accountCallbackData;
//                    }



                    @Override
                    public void onError(Throwable e) {
                        sampleView.onError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        if (typelistDeTypeAndName != null&&typelistDeTypeAndName.getData().size()!=0) {
                            sampleView.getDeTypeAndName(typelistDeTypeAndName);

                            Log.d("typelist",typelistDeTypeAndName.getData().size()+"");


                            Log.d("typelist",typelistDeTypeAndName.getData().get(0).getList().get(0).getName()+"");

                            Log.d("typelist",typelistDeTypeAndName.toString());
                        }
                        SamplePresenter.super.compositeDisposable.dispose();
                    }
                });
    }







    public void getInsertSamplingResponseInfo(SamplingRequset samplingRequset) {    //获取人员名称
        DataManager.getInstance(mContext).getInsertSamplingResponseInfo(samplingRequset)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Callback>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Callback listCallbackData) {
                        inSertcallbackData = listCallbackData;

                    }

//                    @Override
//                    public void onNext(CallbackData<List<OperatingBean>> accountCallbackData) {
//
//                        operatorBeanList = accountCallbackData;
//                    }



                    @Override
                    public void onError(Throwable e) {
                        sampleView.onError(e.toString());
                    }

                    @Override
                    public void onComplete() {

                            sampleView.getInsertSamplingResponseInfo(inSertcallbackData);
                            SamplePresenter.super.compositeDisposable.dispose();
                    }
                });
    }






}
