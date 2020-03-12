package com.chen.nongansampling.presenterView;

import java.util.List;



public interface BaseView {
    //定义一个最基础的接口，里面就包含一个出错信息的回调
    //因为大多数时候报错的时候都是采用一条信息提示
    //如果需要负责的报错接口，请重载onError，是重载不是重写
    void onError(String result);
    void onSuccess(Object resultData);


}
