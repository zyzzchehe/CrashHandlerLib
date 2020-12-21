package com.example.crashhandlerdemo;

import android.Manifest;
import android.app.Application;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;

import com.example.crashhandlerlib.CrashHandler;
import com.example.zyzzc_permission_lib.PermissionListener;
import com.example.zyzzc_permission_lib.PermissionsUtil;
import com.example.zyzzc_permission_lib.ZyzzcPermissionUtils;

import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {
    static List<String> permissionList = new ArrayList<>();

    static {
        permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        permissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(Build.VERSION.SDK_INT > 23) {
            PermissionsUtil.requestPermission(getApplicationContext(), new PermissionListener() {
                @Override
                public void permissionGranted(@NonNull String[] permissions) {
                    Log.d("yazhou", "permission allow");
                    CrashHandler.getInstance().init(getApplicationContext());
                }

                @Override
                public void permissionDenied(@NonNull String[] permissions) {
                    Log.d("yazhou", "permission deny");
                }
            }, permissionList.toArray(new String[]{}));
        }
    }
}
