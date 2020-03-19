package com.chen.nongansampling.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class StorageUtil {
    public static void StoragePasswordAndAccount(String account, String psw, Context context) {
        if (account != "" && psw != "") {
            SharedPreferences sharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            //步骤3：将获取过来的值放入文件
            editor.putString("account", account);
            editor.putString("password", psw);
            editor.commit();
            setLoginStatus(context,true);

        }
    }

    public static Boolean getLoginStatus(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        Boolean status = sharedPreferences.getBoolean("status", false);
        //步骤3：将获取过来的值放入文件
        return status;

    }

    public static void setLoginStatus(Context context, Boolean status) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //步骤3：将获取过来的值放入文件
        editor.putBoolean("status", status);
        editor.commit();
    }
}





