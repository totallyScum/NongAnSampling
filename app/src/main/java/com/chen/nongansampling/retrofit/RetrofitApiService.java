package com.chen.nongansampling.retrofit;

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

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitApiService {
    @Headers({"Content-Type: application/json","Accept: application/json"})//登陆
     @POST("API/Login")
    Observable<CallbackData<Account>> getLoginResponseInfo(@Body LoginRequest loginRequest);


    @Headers({"Content-Type: application/json","Accept: application/json"})//获取全部市场
    @POST("API/getMarket")
    Observable<CallbackData<List<Market>>> getMarketResponseInfo(@Body SimpleRequest simpleRequest);





    @Headers({"Content-Type: application/json","Accept: application/json"})//风险检测
    @POST("API/getRiskMonitoring")
    Observable<CallbackData<List<RiskMonitoringResponseBean>>> getRiskMonitoringResponseInfo();


    @Headers({"Content-Type: application/json","Accept: application/json"})//风险检测
    @POST("API/getOperating")
    Observable<CallbackData<List<OperatingBean>>> getOperatingResponseInfo(@Body SimpleRequest simpleRequest);



    @Headers({"Content-Type: application/json","Accept: application/json"})//风险检测
    @POST("API/getToday")
    Observable<TodayResponseBean> getTodayResponseInfo(@Body SimpleRequest simpleRequest);



    @Headers({"Content-Type: application/json","Accept: application/json"})//获取所有检测类型
    @POST("API/getDetectionType")
    Observable<TodayResponseBean> getDetectionType(@Body SimpleRequest simpleRequest);


//    @Headers({"Content-Type: application/json","Accept: application/json"})// 获取检测方法BY检测类型ID
//    @POST("API/getDetectionType")
//    Observable<TodayResponseBean> getDetectionType(@Body SimpleRequest simpleRequest);




        @Headers({"Content-Type: application/json","Accept: application/json"})// 获取检测方法BY检测类型ID
    @POST("API/getSamplingName")
    Observable<CallbackData<List<TypeList>>> getSamplingNameResponseInfo(@Body SimpleRequest simpleRequest);




    @Headers({"Content-Type: application/json","Accept: application/json"})// 获取检测方法BY检测类型ID
    @POST("API/getDeTypeAndName")
    Observable<CallbackData<List<TypeList>>> getDeTypeAndNameResponseInfo(@Body SimpleRequest simpleRequest);


    @Headers({"Content-Type: application/json","Accept: application/json"})// 获取检测方法BY检测类型ID
    @POST("API/insertSampling")
    Observable<Callback> getInsertSamplingResponseInfo(@Body SamplingRequset samplingRequset);
}
