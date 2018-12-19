package com.ble.bledemo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * 作者：lch
 * 时间：2018/12/18 0018:下午 22:26
 * 邮箱：245850413@qq.com
 * 说明：
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

    }
}
