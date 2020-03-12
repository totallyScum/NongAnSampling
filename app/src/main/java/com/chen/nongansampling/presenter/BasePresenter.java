package com.chen.nongansampling.presenter;


import com.chen.nongansampling.presenterView.BaseView;
import com.chen.nongansampling.presenterView.BusinessArchivesView;


import io.reactivex.disposables.CompositeDisposable;

/**
 */
//定义一个Presenter的基础类，后续具体功能类继承于它
public abstract class BasePresenter implements Presenter {
    //声明一个CompositeSubscription对象，注意是protected修饰符，便于子类进行调用
    public CompositeDisposable compositeDisposable;
    @Override
    public void onCreate() {
        //在基础类中对CompositeSubscription进行初始化，子类中就不用再写一次
        //子类如果需要对onCreate进行重写，记得先调用super.onCreate();
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onDestroy() {
        //释放compositeDisposable，否则会造成内存泄漏
        if (compositeDisposable.isDisposed()){
            compositeDisposable.clear();
        }
    }


}
