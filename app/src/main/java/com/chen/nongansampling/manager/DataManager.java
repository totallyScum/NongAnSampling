package com.chen.nongansampling.manager;

import android.content.Context;

import com.chen.nongansampling.bean.Callback;
import com.chen.nongansampling.bean.LoginRequest;
import com.chen.nongansampling.bean.OperatingBean;
import com.chen.nongansampling.bean.RiskMonitoringResponseBean;
import com.chen.nongansampling.bean.SimpleRequest;
import com.chen.nongansampling.bean.TodayResponseBean;
import com.chen.nongansampling.bean.sample.TypeList;
import com.chen.nongansampling.bean.sample.insert.SamplingRequset;
import com.chen.nongansampling.model.Account;
import com.chen.nongansampling.model.CallbackData;
import com.chen.nongansampling.model.Market;
import com.chen.nongansampling.retrofit.RetrofitApiService;
import com.chen.nongansampling.retrofit.RetrofitUtil;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 */

//该类用来管理RetrofitApiService中对应的各种API接口，
// 当做Retrofit和presenter中的桥梁，Activity就不用直接和retrofit打交道了
public class DataManager {
    private RetrofitApiService mRetrofitService;
    private volatile static DataManager instance;

    private DataManager(Context context){
        this.mRetrofitService = RetrofitUtil.getInstance(context).getRetrofitApiService();
    }
    //由于该对象会被频繁调用，采用单例模式，下面是一种线程安全模式的单例写法
    public static DataManager getInstance(Context context) {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null) {
                    instance = new DataManager(context);
                }
            }
        }
        return instance;
    }

    public Observable<CallbackData<Account>> getLoginResponseInfo(LoginRequest loginRequest){
        return mRetrofitService.getLoginResponseInfo(loginRequest);
    }
    public Observable<CallbackData<List<Market>>> getMarketResponseInfo(SimpleRequest simpleRequest){
        return mRetrofitService.getMarketResponseInfo(simpleRequest);
    }



    public Observable<CallbackData<List<RiskMonitoringResponseBean>>> getRiskMonitoringResponseInfo(){   //获取转机统计数
        return mRetrofitService.getRiskMonitoringResponseInfo();
    }


    public Observable<CallbackData<List<OperatingBean>>> getOperatingResponseInfo(SimpleRequest simpleRequest) {   //获取转机统计数
        return mRetrofitService.getOperatingResponseInfo(simpleRequest);

    }


        public Observable<TodayResponseBean> getTodayResponseInfo(SimpleRequest simpleRequest){   //获取转机统计数
            return mRetrofitService.getTodayResponseInfo(simpleRequest);
        }



    public Observable<CallbackData<List<TypeList>>> getSamplingNameResponseInfo(SimpleRequest simpleRequest) {   //获取转机统计数
        return mRetrofitService.getSamplingNameResponseInfo(simpleRequest);
    }

        public Observable<CallbackData<List<TypeList>>> getDeTypeAndNameResponseInfo(SimpleRequest simpleRequest) {
            return mRetrofitService.getDeTypeAndNameResponseInfo(simpleRequest);

        }
            public Observable<Callback> getInsertSamplingResponseInfo(SamplingRequset simpleRequest){
                return mRetrofitService.getInsertSamplingResponseInfo(simpleRequest);








    }




}
