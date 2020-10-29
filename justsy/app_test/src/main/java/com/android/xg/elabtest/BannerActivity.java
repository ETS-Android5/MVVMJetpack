package com.android.xg.elabtest;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.elab.libview.hbanner.BannerGravity;
import com.elab.libview.hbanner.BannerStyle;
import com.elab.libview.hbanner.HBanner;
import com.elab.libview.hbanner.HTextureBanner;
import com.elab.libview.hbanner.Transformer;
import com.elab.libview.hbanner.loader.ViewItemBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.elab.libview.hbanner.BannerConfig.IMAGE;
import static com.elab.libview.hbanner.BannerConfig.VIDEO;

public class BannerActivity extends AppCompatActivity {
    HBanner banner;
    HTextureBanner hTextureBanner;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        banner = findViewById(R.id.banner);
        hTextureBanner = findViewById(R.id.banner_t);

        List<ViewItemBean> list = new ArrayList<>();
        Uri path1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.default2);
        Uri path2 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.default1);

        list.add(new ViewItemBean(IMAGE, "标题5", R.mipmap.ic_launcher, 2 * 1000));

        list.add(new ViewItemBean(VIDEO, "标题1", "/storage/emulated/0/1111111.mp4", 5 * 1000));
        list.add(new ViewItemBean(IMAGE, "标题4", R.mipmap.ic_launcher, 2 * 1000));
        list.add(new ViewItemBean(VIDEO, "标题3", "/storage/emulated/0/1111111.mp4", 5 * 1000));
        list.add(new ViewItemBean(IMAGE, "标题5", R.mipmap.ic_launcher, 2 * 1000));

        list.add(new ViewItemBean(VIDEO, "标题1", path1, 15 * 1000));
        list.add(new ViewItemBean(IMAGE, "标题4", R.mipmap.ic_launcher, 2 * 1000));
        list.add(new ViewItemBean(VIDEO, "标题3", path2, 15 * 1000));
        list.add(new ViewItemBean(IMAGE, "标题5", R.mipmap.ic_launcher, 2 * 1000));

        list.add(new ViewItemBean(VIDEO, "标题1", path1, 15 * 1000));
        list.add(new ViewItemBean(IMAGE, "标题4", R.mipmap.ic_launcher, 2 * 1000));
        list.add(new ViewItemBean(VIDEO, "标题3", path2, 15 * 1000));
        list.add(new ViewItemBean(IMAGE, "标题5", R.mipmap.ic_launcher, 2 * 1000));

        list.add(new ViewItemBean(VIDEO, "标题1", path1, 15 * 1000));
        list.add(new ViewItemBean(IMAGE, "标题4", R.mipmap.ic_launcher, 2 * 1000));
        list.add(new ViewItemBean(VIDEO, "标题3", path2, 15 * 1000));
        list.add(new ViewItemBean(IMAGE, "标题5", R.mipmap.ic_launcher, 2 * 1000));

        list.add(new ViewItemBean(VIDEO, "标题1", path1, 15 * 1000));
        list.add(new ViewItemBean(IMAGE, "标题4", R.mipmap.ic_launcher, 2 * 1000));
        list.add(new ViewItemBean(VIDEO, "标题3", path2, 15 * 1000));
        list.add(new ViewItemBean(IMAGE, "标题5", R.mipmap.ic_launcher, 2 * 1000));
        banner.setViews(list)
                .setBannerAnimation(Transformer.Default)//换场方式
                .setBannerStyle(BannerStyle.CIRCLE_INDICATOR_TITLE)//指示器模式
                .setCache(true)//可以不用设置，默认为true
                .setCachePath(getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath() + File.separator + "hbanner")
                .setViewGravity(BannerGravity.CENTER)
                .setShowTitle(true)//是否显示标题
                .setViewPagerIsScroll(true)//是否支持手滑
                .start();


        hTextureBanner.setViews(list)
                .setBannerAnimation(Transformer.Default)//换场方式
                .setBannerStyle(BannerStyle.CIRCLE_INDICATOR_TITLE)//指示器模式
                .setCache(true)//可以不用设置，默认为true
                .setCachePath(getExternalFilesDir(Environment.DIRECTORY_MOVIES).getAbsolutePath() + File.separator + "hbanner")
                .setViewGravity(BannerGravity.CENTER)
                .setShowTitle(true)//是否显示标题
                .setViewPagerIsScroll(true)//是否支持手滑
                .start();

    }

    @Override
    protected void onResume() {
        super.onResume();
        banner.onResume();
    }

    @Override
    protected void onPause() {
        banner.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        banner.onStop();
        super.onStop();
    }

}
