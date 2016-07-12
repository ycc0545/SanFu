package com.example.dllo.sanfu.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.dllo.sanfu.R;
import com.example.dllo.sanfu.fragment.BuycartFragment;
import com.example.dllo.sanfu.fragment.CategoryFragment;
import com.example.dllo.sanfu.fragment.DiscoverFragment;
import com.example.dllo.sanfu.fragment.HomeFragment;
import com.example.dllo.sanfu.fragment.ProfileFragment;

import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton home;
    private RadioButton buycart;
    private RadioButton category;
    private RadioButton discover;
    private RadioButton profile;
    private BuycartFragment buycartFragment;
    private CategoryFragment categoryFragment;
    private DiscoverFragment discoverFragment;
    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private ImageView barcode;
    private ImageView drawImg;
    private DrawerLayout drawerLayout;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = (RadioButton) findViewById(R.id.home_radiobutton);
        buycart = (RadioButton) findViewById(R.id.buycart_radiobutton);
        category = (RadioButton) findViewById(R.id.category_radiobutton);
        discover = (RadioButton) findViewById(R.id.discover_radiobutton);
        profile = (RadioButton) findViewById(R.id.profile_radiobutton);
        barcode = (ImageView) findViewById(R.id.barcode);
        drawImg = (ImageView) findViewById(R.id.drawer_img);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        textView = (TextView) findViewById(R.id.tv1);

        home.setOnClickListener(this);
        buycart.setOnClickListener(this);
        category.setOnClickListener(this);
        discover.setOnClickListener(this);
        profile.setOnClickListener(this);
        barcode.setOnClickListener(this);
        drawImg.setOnClickListener(this);
        drawerLayout.setOnClickListener(this);

        buycartFragment = new BuycartFragment();
        categoryFragment = new CategoryFragment();
        discoverFragment = new DiscoverFragment();
        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();

        addFragment();
        showFragment(homeFragment);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_radiobutton:
                showFragment(homeFragment);
                break;
            case R.id.buycart_radiobutton:
                showFragment(buycartFragment);

                break;
            case R.id.discover_radiobutton:
                showFragment(discoverFragment);

                break;
            case R.id.profile_radiobutton:
                showFragment(profileFragment);

                break;
            case R.id.category_radiobutton:
                showFragment(categoryFragment);

                break;

            //二维码
            case R.id.barcode:
                Intent intent = new Intent(this, QRCodeScanActivity.class);
                startActivity(intent);
                break;

            case R.id.drawer_img:
                //抽屉出来
                drawerLayout.openDrawer(textView);
                drawerLayout.setScrimColor(0x00000000);

                break;

        }

    }


    private void addFragment() {
        getSupportFragmentManager().beginTransaction().add(R.id.radio_fl, buycartFragment, "buycart")
                .add(R.id.radio_fl, categoryFragment, "category").add(R.id.radio_fl, discoverFragment, "discover")
                .add(R.id.radio_fl, homeFragment, "home").add(R.id.radio_fl, profileFragment, "profile").commit();
    }

    private void showFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(homeFragment).hide(discoverFragment).hide(categoryFragment).hide(profileFragment)
                .hide(buycartFragment)
                .show(fragment).commit();

    }


}
