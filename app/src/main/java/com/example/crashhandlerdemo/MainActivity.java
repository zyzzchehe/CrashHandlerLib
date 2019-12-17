package com.example.crashhandlerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.zyzzc_permission_lib.ZyzzcPermissionUtils;

public class MainActivity extends AppCompatActivity {

    ZyzzcPermissionUtils zyzzcPermissionUtils = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zyzzcPermissionUtils = new ZyzzcPermissionUtils(this);
        int result = 10 / 0;
        Log.d("yazhou","result = "+result);
    }
}
