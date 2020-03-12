package com.chen.nongansampling.presenter;


import com.chen.nongansampling.presenterView.BaseView;

/**
 */

public interface Presenter <T> {
    //Presenter初始化
    void onCreate();
    //销毁
    void onDestroy();
    //绑定视图
    void BindPresentView(T presentView);
}
