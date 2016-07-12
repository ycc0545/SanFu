package com.example.dllo.sanfu.base;

import android.app.Application;
import android.content.Context;

import com.umeng.socialize.PlatformConfig;

import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;


/**
 * Created by dllo on 16/5/23.
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //第一：默认初始化
//        Bmob.initialize(this, "446319e1502683eed7445177974034b4");
//        BmobInstallation.getCurrentInstallation(this).save();
//        BmobPush.startWork(this);

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        //BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        //.setApplicationId("Your Application ID")
        ////请求超时时间（单位为秒）：默认15s
        //.setConnectTimeout(30)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        //.setUploadBlockSize(1024*1024)
        ////文件的过期时间(单位为秒)：默认1800s
        //.setFileExpiration(2500)
        //.build();
        //Bmob.initialize(config);
//         初始化BmobSDK
        Bmob.initialize(this, "0d56ee9f586ca731e30f042873b33292");
        // 使用推送服务时的初始化操作
        BmobInstallation.getCurrentInstallation().save();
        // 启动推送服务
        BmobPush.startWork(this);
    }

    {
        PlatformConfig.setQQZone("1105525590", "33kMGeg2xJ8Cx7mU");
    }
}
