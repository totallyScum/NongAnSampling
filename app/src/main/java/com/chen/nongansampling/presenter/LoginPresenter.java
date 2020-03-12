package com.chen.nongansampling.presenter;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;

import com.chen.nongansampling.bean.LoginRequest;
import com.chen.nongansampling.manager.DataManager;
import com.chen.nongansampling.model.Account;
import com.chen.nongansampling.model.CallbackData;
import com.chen.nongansampling.presenterView.BaseView;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 */

//该类是具体业务presenter，如需增加另一个业务，比如Order
//则可以再创建一个OrderPresenter
public class LoginPresenter extends BasePresenter {
    private Context mContext;
    private BaseView baseView;
    private CallbackData<Account> mLoginResponseBody;
    private Dialog mDialog;

    public LoginPresenter(Context context){
        this.mContext = context;
    }



    @Override
    public void BindPresentView(Object presentView) {
        baseView = (BaseView) presentView;
    }

    //在presenter中实现业务逻辑，此处会调用前面封装好的retrofit的东西
    //将处理结果绑定到对应的PresentView实例，这样Activity和PresentView实例绑定好之后，
    //Activity->PresentView->Presenter->retrofit的关系就打通了
    public void getLoginResponseInfo(LoginRequest loginRequest) {
        DataManager.getInstance(mContext).getLoginResponseInfo(loginRequest)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<CallbackData<Account>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CallbackData<Account> accountCallbackData) {

                        mLoginResponseBody = accountCallbackData;
                    }



                    @Override
                    public void onError(Throwable e) {
                        baseView.onError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        if (mLoginResponseBody != null) {
                            baseView.onSuccess(mLoginResponseBody);
                        }
                        LoginPresenter.super.compositeDisposable.dispose();
                    }
                });
    }


}

