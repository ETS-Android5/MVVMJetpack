package com.android.xg.elabtest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.elab.libview.videoimagebanner.IVBannerBean;
import com.elab.libview.videoimagebanner.ImageVideoBanner;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("Registered")
public class ImageVideoBannerActivity extends AppCompatActivity {
    private List<IVBannerBean> list = new ArrayList<>();
    private static final int VIDEO_PERMISSIONS_CODE = 1;

    private String[] permsLocation = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ivbanner);

        requestPermission();
        //HkView hkView = findViewById(R.id.hk);
        //hkView.setType(HkViewType.IS_COMPARE);

        for (int i = 0; i < 4; i++) {
            IVBannerBean listBean = new IVBannerBean();
            if (i == 0 ) {
                //listBean.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588643630831&di=04bfaa68e3f6788ef83c4d68e28c3ec8&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2017-10-30%2F59f68513a33ca.jpg");
                listBean.setUrl("/sdcard/1.mp4");
//                listBean.setUrl("https://media.w3.org/2010/05/sintel/trailer.mp4");
                listBean.setType(1);//图片类型 视频
            } else if(i==1){
                listBean.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588643630830&di=8001b0f2d982a762fb9acdf3356367dc&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201608%2F27%2F20160827172726_GJfX2.jpeg");
                listBean.setType(0);//图片类型 视频
            }else if(i == 2){
                listBean.setUrl("/sdcard/1.mp4");
                listBean.setType(1);//图片类型 视频
            }else {
                listBean.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1588643630830&di=25db1ee214c4e8f0c4129fd5eb73ef3a&imgtype=0&src=http%3A%2F%2Fwww.boruisz.com%2Fimages%2Fnfwwomldfz4go3znnfwwoltdn5ws4y3o%2Fpics%2F1612%2F1611218.jpg");
                listBean.setType(0);//图片类型 图片
            }
            list.add(listBean);
        }

        ImageVideoBanner banner = findViewById(R.id.ivbanner);

        banner.setViewPagerIsScroll(true);


        banner.replaceData(list);
        banner.startBanner();


        //banner.setMute(true);
        //banner.setLoop(true);
    }
    //申请权限
    private void requestPermission() {
        // 当API大于 23 时，才动态申请权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(ImageVideoBannerActivity.this,permsLocation,VIDEO_PERMISSIONS_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case VIDEO_PERMISSIONS_CODE:
                //权限请求失败
                if (grantResults.length == permsLocation.length) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            //弹出对话框引导用户去设置
                            Toast.makeText(ImageVideoBannerActivity.this, "请求权限被拒绝", Toast.LENGTH_LONG).show();
                            break;
                        }
                    }
                }else{
                    Toast.makeText(ImageVideoBannerActivity.this, "已授权", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
