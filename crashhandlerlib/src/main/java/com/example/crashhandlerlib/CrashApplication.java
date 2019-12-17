package com.example.crashhandlerlib;


import android.app.Application;
import android.content.Context;

public class CrashApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());
    }
    /**
     * 获取全局上下文
     */
    public static Context getContext() {
        return context;
    }
}
