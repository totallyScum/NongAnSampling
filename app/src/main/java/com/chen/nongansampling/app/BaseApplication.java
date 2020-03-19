package com.chen.nongansampling.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import com.chen.nongansampling.constant.AppConstant;
import com.chen.nongansampling.utils.SystemInfoUtils;
import com.tencent.bugly.crashreport.CrashReport;


import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * Created by 眼神 on 2018/3/27.
 */

public class BaseApplication extends Application {

    public static Context appContext;
    public static ArrayList<Activity> allActivities = new ArrayList<Activity>();
    public static BaseApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        app = this;
        CrashReport.initCrashReport(getApplicationContext(), "bf75c62acb", true);
        Log.d("注册时申请的APPID","注册时申请的APPID");
    //    initNet();

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();

    }
//    public void initNet(){
//        app = this;
//        EasyHttp.init(this);
//
//        //这里涉及到安全我把url去掉了，demo都是调试通的
//        String Url = "http://123.206.51.39:17444";
//
//        //设置请求头
//        HttpHeaders headers = new HttpHeaders();
//        headers.put("User-Agent", SystemInfoUtils.getUserAgent(this, AppConstant.APPID));
//        //设置请求参数
//        HttpParams params = new HttpParams();
//   //     params.put("appId", AppConstant.APPID);
//        EasyHttp.getInstance()
//                .debug("RxEasyHttp", BuildConfig.DEBUG)
//                .setReadTimeOut(60 * 1000)
//                .setWriteTimeOut(60 * 1000)
//                .setConnectTimeout(60 * 1000)
//                .setRetryCount(3)//默认网络不好自动重试3次
//                .setRetryDelay(500)//每次延时500ms重试
//                .setRetryIncreaseDelay(500)//每次延时叠加500ms
//                .setBaseUrl(Url)
//                .setCacheDiskConverter(new SerializableDiskConverter())//默认缓存使用序列化转化
//                .setCacheMaxSize(50 * 1024 * 1024)//设置缓存大小为50M
//                .setCacheVersion(1)//缓存版本为1
//                .setHostnameVerifier(new UnSafeHostnameVerifier(Url))//全局访问规则
//                .setCertificates()//信任所有证书
//                //.addConverterFactory(GsonConverterFactory.create(gson))//本框架没有采用Retrofit的Gson转化，所以不用配置
//                .addCommonHeaders(headers)//设置全局公共头
//                .addCommonParams(params)//设置全局公共参数
//                .addInterceptor(new CustomSignInterceptor());//添加参数签名拦截器
//        //.addInterceptor(new HeTInterceptor());//处理自己业务的拦截器
//
//    }
//
//    public static Context getConText(){
//        return appContext;
//    }
//
//    public static BaseApplication getApp(){
//        return app;
//    }
//
//    public static void addActivity(Activity activity) {
//        allActivities.add(activity);
//    }
//
//    public static void delActivity(Activity activity) {
//        allActivities.remove(activity);
//    }
//    public class UnSafeHostnameVerifier implements HostnameVerifier {
//        private String host;
//
//        public UnSafeHostnameVerifier(String host) {
//            this.host = host;
//            HttpLog.i("###############　UnSafeHostnameVerifier " + host);
//        }
//
//        @Override
//        public boolean verify(String hostname, SSLSession session) {
//            HttpLog.i("############### verify " + hostname + " " + this.host);
//            if (this.host == null || "".equals(this.host) || !this.host.contains(hostname))
//                return false;
//            return true;
//        }
//    }

    public static Context getAppContext() {
        if (app == null)
            return null;
        return app.getApplicationContext();
    }
}
