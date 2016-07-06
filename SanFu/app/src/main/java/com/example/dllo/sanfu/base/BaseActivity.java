package com.example.dllo.sanfu.base;

import android.content.BroadcastReceiver;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;



import java.util.ArrayList;

/**
 * Created by dllo on 16/6/20.
 */
public abstract class BaseActivity extends AppCompatActivity {
    //所有广播的集合
    protected ArrayList<BroadcastReceiver> receivers = new ArrayList<>();
    //所有服务的集合
    protected ArrayList<ServiceConnection> serviceConnections = new ArrayList<>();


    //初始化
    public abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    //广播取消注册和服务的解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();

        for (BroadcastReceiver receiver : receivers) {
            unregisterReceiver(receiver);
        }
        for (ServiceConnection serviceConnection : serviceConnections) {
            unbindService(serviceConnection);
        }
    }
}
