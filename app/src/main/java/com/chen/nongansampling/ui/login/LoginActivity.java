package com.chen.nongansampling.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.chen.nongansampling.BaseActivity;
import com.chen.nongansampling.MainActivity;
import com.chen.nongansampling.R;
import com.chen.nongansampling.bean.LoginRequest;
import com.chen.nongansampling.constant.AppConstant;
import com.chen.nongansampling.constant.ComParamContact;
import com.chen.nongansampling.model.Account;
import com.chen.nongansampling.model.AuthModel;
import com.chen.nongansampling.model.CallbackData;
import com.chen.nongansampling.model.LoginCache;
import com.chen.nongansampling.presenter.BasePresenter;
import com.chen.nongansampling.presenter.LoginPresenter;
import com.chen.nongansampling.presenterView.BaseView;
import com.chen.nongansampling.token.TokenManager;
import com.chen.nongansampling.ui.login.LoginViewModel;
import com.chen.nongansampling.ui.login.LoginViewModelFactory;
import com.chen.nongansampling.utils.MD5;
import com.tencent.bugly.crashreport.CrashReport;


public class LoginActivity extends BaseActivity implements BaseView {

    private LoginViewModel loginViewModel;
    private LoginPresenter loginPresenter=new LoginPresenter(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginPresenter.onCreate();
        loginPresenter.BindPresentView(this);
    //    CrashReport.testJavaCrash();
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
        loginButton.setEnabled(true);

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
               // loginButton.setEnabled(loginFormState.isDataValid());
                loginButton.setEnabled(true);
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


    //            loadingProgressBar.setVisibility(View.VISIBLE);
//                loginViewModel.login(usernameEditText.getText().toString(),
//                        passwordEditText.getText().toString());
                onLogin("1","1");
//                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
            }
        });
        initView();
    }



    public void onLogin(final String name, final String pass) {

        LoginRequest loginRequest=new LoginRequest();
        loginRequest.setLoginName("1");
        loginRequest.setLoginPassword("1");
        loginPresenter.getLoginResponseInfo(loginRequest);

//        IProgressDialog mProgressDialog = new IProgressDialog() {
//            @Override
//            public Dialog getDialog() {
//                ProgressDialog dialog = new ProgressDialog(LoginActivity.this);
//                dialog.setMessage("登录中...");
//                return dialog;
//            }
//        };
//        EasyHttp.post(ComParamContact.Login.PATH)
//                .params(ComParamContact.Login.ACCOUNT, name)
//       //         .params(ComParamContact.Login.PASSWORD, MD5.encrypt4login(pass, AppConstant.APP_SECRET))
//                .params(ComParamContact.Login.PASSWORD, pass)
//                .sign(true)
//                .timeStamp(true)
//                .execute(new ProgressDialogCallBack<AuthModel>(mProgressDialog, true, true) {
//                    @Override
//                    public void onError(ApiException e) {
//                        super.onError(e);
//                        showToast("登录失败！" + e.getMessage());
//                    }
//
//                    @Override
//                    public void onSuccess(AuthModel authModel) {
//                        showToast("登录成功！");
//                        //授权类信息存入缓存
//                        TokenManager.getInstance().setAuthModel(authModel);
//                        //将用户和密码存入缓存
//                        LoginCache.getInstance().save(name, pass);
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        startActivity(intent);
//                        finish();
//                    }
//                });
        /**
         * post请求
         */

//            EasyHttp.post("/API/Login")
//                    .params("LoginName", "1")
//                    .params("LoginPassword", "1")
//                    .accessToken(true)
//                    .timeStamp(true)
//                    .execute(new SimpleCallBack<String>() {
//                        @Override
//                        public void onError(ApiException e) {
//                            showToast(e.getMessage());
//                        }
//
//                        @Override
//                        public void onSuccess(String response) {
//                            showToast(response);
//                                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        startActivity(intent);
//                        }
//                    });


    }


    private void showToast(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }


    public void initView(){
        Drawable rightDrawable = getResources().getDrawable(R.mipmap.login_edit_user);

//调用setCompoundDrawables时，必须调用Drawable.setBounds()方法,否则图片不显示

        rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());  // left, top, right, bottom
      //  usernameEditText.setCompoundDrawables(null, null, rightDrawable, null);
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String result) {
        Log.d("qqqq",result);

    }

    @Override
    public void onSuccess(Object resultData) {
                        Log.d("qqqq","2333555");
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
    }
}
