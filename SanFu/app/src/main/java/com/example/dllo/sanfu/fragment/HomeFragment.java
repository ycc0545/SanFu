package com.example.dllo.sanfu.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.dllo.sanfu.R;
import com.example.dllo.sanfu.adapter.CarouselViewPagerAdapter;
import com.example.dllo.sanfu.base.BaseFragment;
import com.example.dllo.sanfu.bean.CarouselBean;
import com.example.dllo.sanfu.net.NetListener;
import com.example.dllo.sanfu.net.NetTool;
import com.example.dllo.sanfu.net.URLValues;
import com.example.dllo.sanfu.tool.ScollerViewPager;
import com.google.gson.Gson;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.utils.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

import c.b.BP;
import c.b.PListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by dllo on 16/7/6.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private ViewPager carousel1;
    private CarouselViewPagerAdapter adapter;
    private NetTool netTool;
    private LinearLayout carouselLayout;
    private Handler handler;
    private boolean userTouch = false;
    private int sleepTick;
    private CarouselBean carouselBean;
    private Button shareQQ;
    private Button buyWeiXin;
    // 此为测试Appid,请将Appid改成你自己的Bmob AppId
    private String APPID = "4b75f19eee04513a9408da3d887ebec8";
    int PLUGINVERSION = 7;
    EditText name, price, body, order;
    Button exit;
    private ProgressDialog dialog;
    private TextView tv;


    @Override
    public int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        carousel1 = (ViewPager) view.findViewById(R.id.carousel_home_viewpager);
        carouselLayout = (LinearLayout) view.findViewById(R.id.carousel_home_viewpager_llayout);
        shareQQ = (Button) view.findViewById(R.id.btn1);
        buyWeiXin = (Button) view.findViewById(R.id.btn2);
        // 初始化BmobPay对象,可以在支付时再初始化
        name = (EditText) view.findViewById(R.id.name);
        price = (EditText) view.findViewById(R.id.price);
        body = (EditText) view.findViewById(R.id.body);
        order = (EditText) view.findViewById(R.id.order);
        exit = (Button) view.findViewById(R.id.exit);
        tv = (TextView) view.findViewById(R.id.tv);


    }

    @Override
    public void initData() {
        carouselModule();
        adapter = new CarouselViewPagerAdapter(context);
        carousel1.setAdapter(adapter);

        shareQQ.setOnClickListener(this);
        buyWeiXin.setOnClickListener(this);

        //改变viewPager滑动速度
        try {
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);
            ScollerViewPager scroller = new ScollerViewPager(carousel1.getContext(),
                    new AccelerateInterpolator());
            field.set(carousel1, scroller);
            scroller.setmDuration(2000);
        } catch (Exception e) {

        }

        //支付
        BP.init(context, APPID);

        //解除插件

        exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BP.ForceFree();
            }
        });
        exit.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                BP.ForceExit();
                return true;
            }
        });

        int pluginVersion = BP.getPluginVersion();
        if (pluginVersion < PLUGINVERSION) {// 为0说明未安装支付插件, 否则就是支付插件的版本低于官方最新版
            Toast.makeText(context,
                    pluginVersion == 0 ? "监测到本机尚未安装支付插件,无法进行支付,请先安装插件(无流量消耗)"
                            : "监测到本机的支付插件不是最新版,最好进行更新,请先更新插件(无流量消耗)", Toast.LENGTH_SHORT).show();
            installBmobPayPlugin("BmobPayPlugin");
        }


    }


    void showDialog(String message) {
        try {
            if (dialog == null) {
                dialog = new ProgressDialog(context);
                dialog.setCancelable(true);
            }
            dialog.setMessage(message);
            dialog.show();
        } catch (Exception e) {
            // 在其他线程调用dialog会报错
        }
    }

    void hideDialog() {
        if (dialog != null && dialog.isShowing())
            try {
                dialog.dismiss();
            } catch (Exception e) {
            }
    }

    void installBmobPayPlugin(String fileName) {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("assets/" + fileName + ".apk");

            File file = new File(Environment.getExternalStorageDirectory() + File.separator + fileName);
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            byte[] temp = new byte[1024];
            int i = 0;
            while ((i = is.read(temp)) > 0) {
                fos.write(temp, 0, i);
            }
            fos.close();
            is.close();

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.parse("file://" + file),
                    "application/vnd.android.package-archive");
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carouselModule() {
        netTool = new NetTool();
        netTool.getAnalysis(URLValues.CAROUSEL, new NetListener() {
            @Override
            public void onSuccessed(String response) {
                Gson gson = new Gson();
                carouselBean = gson.fromJson(response, CarouselBean.class);
                adapter.setCarouselBean(carouselBean);

                /**
                 * 小圆点
                 */
                carouselLayout.removeAllViews();
                for (int i = 0; i < carouselBean.getData().getBanners().size(); i++) {
                    CheckBox checkBox = new CheckBox(context);
                    Drawable drawable = getResources().getDrawable(R.drawable.selector_carouse_point);
                    checkBox.setBackground(drawable);

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(18, 18);
                    params.setMargins(8, 0, 8, 0);
                    params.weight = 1;
                    carouselLayout.addView(checkBox, params);
                }
                ((CheckBox) carouselLayout.getChildAt(0)).setChecked(true);

                carousel1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        int selectNum = position % carouselBean.getData().getBanners().size();
                        for (int i = 0; i < carouselBean.getData().getBanners().size(); i++) {
                            if (selectNum == i) {
                                ((CheckBox) carouselLayout.getChildAt(i)).setChecked(true);
                            } else {
                                ((CheckBox) carouselLayout.getChildAt(i)).setChecked(false);

                            }
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

//                        Log.d("HomeFragment", "state:" + state);
                    }
                });

            }

            @Override
            public void onFailed(VolleyError error) {

            }
        });


        //设置适配器
        carousel1.setAdapter(adapter);

        //设置轮播图
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                //先获取当前的位置,再讲ViewPager刷新到下一页

                int current = carousel1.getCurrentItem();


                if (current != carouselBean.getData().getBanners().size()) {

                    carousel1.setCurrentItem(current + 1);
                }
                if (current == carouselBean.getData().getBanners().size() - 1) {
                    carousel1.setCurrentItem(0);
//                    Log.d("HomeFragment", "aaa");
                }
                return false;
            }
        });


        //开启线程去执行轮播
        new Thread(mRunnable).start();


        //当用户点击的时候就不会再触发发轮播图了
        //轮播图就会暂停轮播
        carousel1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //当用户触摸了轮播图的时候
                        userTouch = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        //当用户手指离开轮播图的时候
                        userTouch = false;
                        sleepTick = 0;//每次当用户抬起手指,都会重新开始计时
                        break;
                }
                return false;
            }
        });
    }


    private boolean threadAlive = true;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {

            while (threadAlive) {
                //每隔3s刷新一次ViewPager的数据
                for (sleepTick = 0; sleepTick < 5; sleepTick++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!userTouch) {
                    handler.sendEmptyMessage(0);
                }
            }

        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        threadAlive = false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(context).onActivityResult(requestCode, resultCode, data);

    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);
            if (platform.name().equals("WEIXIN_FAVORITE")) {
                Toast.makeText(context, platform + " 收藏成功啦", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };
    String url = "http://www.umeng.com";

    @Override
    public void onClick(View v) {
        UMImage image = new UMImage(context, "http://www.umeng.com/images/pic/social/integrated_3.png");
        switch (v.getId()) {
            case R.id.btn1:
//                Toast.makeText(context, "aaa", Toast.LENGTH_SHORT).show();
//                new ShareAction(getActivity()).setPlatform(SHARE_MEDIA.QQ).setCallback(umShareListener)
//                        .withText("hello 李爽")
//                        .withMedia(image)
//                        //.withMedia(new UMEmoji(ShareActivity.this,"http://img.newyx.net/news_img/201306/20/1371714170_1812223777.gif"))
////                        .withText("hello umeng")
//                        .withTargetUrl(url)
//                        .share();

                ShareSDK.initSDK(context);
                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
                //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
                // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
                oks.setTitle(getString(R.string.share));
                // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
                oks.setTitleUrl("http://sharesdk.cn");
                // text是分享文本，所有平台都需要这个字段
                oks.setText("我是分享文本");
                // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                // url仅在微信（包括好友和朋友圈）中使用
                oks.setUrl("http://sharesdk.cn");
                // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                oks.setComment("我是测试评论文本");
                // site是分享此内容的网站名称，仅在QQ空间使用
                oks.setSite(getString(R.string.app_name));
                // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                oks.setSiteUrl("http://sharesdk.cn");

                // 启动分享GUI
                oks.show(context);


                break;

            case R.id.btn2:

                pay(false);
                break;
        }
    }

    // 默认为0.02
    double getPrice() {
        double price = 0.02;
        try {
            price = Double.parseDouble(this.price.getText().toString());
        } catch (NumberFormatException e) {
        }
        return price;
    }

    // 商品详情(可不填)
    String getName() {
        return this.name.getText().toString();
    }

    // 商品详情(可不填)
    String getBody() {
        return this.body.getText().toString();
    }

    // 支付订单号(查询时必填)
    String getOrder() {
        return this.order.getText().toString();
    }

    /**
     * 调用支付
     *
     * @param alipayOrWechatPay 支付类型，true为支付宝支付,false为微信支付
     */
    void pay(final boolean alipayOrWechatPay) {
        showDialog("正在获取订单...");
        final String name = getName();

        BP.pay(name, getBody(), getPrice(), alipayOrWechatPay, new PListener() {

            // 因为网络等原因,支付结果未知(小概率事件),出于保险起见稍后手动查询
            @Override
            public void unknow() {
                Toast.makeText(context, "支付结果未知,请稍后手动查询", Toast.LENGTH_SHORT).show();
                tv.append(name + "'s pay status is unknow\n\n");
                hideDialog();
            }

            // 支付成功,如果金额较大请手动查询确认
            @Override
            public void succeed() {
                Toast.makeText(context, "支付成功!", Toast.LENGTH_SHORT).show();
                tv.append(name + "'s pay status is success\n\n");
                hideDialog();
            }

            // 无论成功与否,返回订单号
            @Override
            public void orderId(String orderId) {
                // 此处应该保存订单号,比如保存进数据库等,以便以后查询
                order.setText(orderId);
                tv.append(name + "'s orderid is " + orderId + "\n\n");
                showDialog("获取订单成功!请等待跳转到支付页面~");
            }

            // 支付失败,原因可能是用户中断支付操作,也可能是网络原因
            @Override
            public void fail(int code, String reason) {
                // 当code为-2,意味着用户中断了操作
                // code为-3意味着没有安装BmobPlugin插件
                if (code == -3) {
                    Toast.makeText(context,
                            "监测到你尚未安装支付插件,无法进行支付,请先安装插件(已打包在本地,无流量消耗),安装结束后重新支付",
                            Toast.LENGTH_SHORT).show();
                    installBmobPayPlugin("BmobPayPlugin");
                } else {
                    Toast.makeText(context, "支付中断!", Toast.LENGTH_SHORT)
                            .show();
                }
                tv.append(name + "'s pay status is fail, error code is \n"
                        + code + " ,reason is " + reason + "\n\n");
                hideDialog();
            }
        });
    }

}
