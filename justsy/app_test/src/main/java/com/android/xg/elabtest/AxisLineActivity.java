package com.android.xg.elabtest;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.android.xg.hcnetsdk.HikVisionDeviceHelper;
import com.android.xg.hikvision.HikVisionPlayBackMode;
import com.android.xg.hikvision.HikVisionVideoView;
import com.android.xg.hikvision.HikVisionVideoViewSize;
import com.android.xg.timeaxis.RecordSegment;
import com.android.xg.timeaxis.TimeAxisContainer;
import com.android.xg.timeaxis.TimeAxisView;
import com.elab.libview.guide.GuideView;
import com.elab.libview.guide.model.GuidePage;
import com.elab.libview.scollview.LockableNestedScrollView;

import java.util.Date;
import java.util.List;

/**
 * ELabMcAndroid
 * <p>
 * Created by 李阳 on 2020/7/30 0030
 * Copyright © 2020年 新广科技. All rights reserved.
 * <p>
 * Describe:
 */
public class AxisLineActivity extends AppCompatActivity {

    private static final String TAG = "AxisLineActivity";

    HikVisionVideoView video;
    TimeAxisView timeAxisView;
    AppCompatTextView time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_axis);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        LockableNestedScrollView view = findViewById(R.id.scroll);
        view.setScrollingEnabled(false);
        HikVisionDeviceHelper.initHikVisionSDK();
        video = findViewById(R.id.video);
        GuideView.with(this)
                .setLabel("guide1")
                .alwaysShow(true)
                .addGuidePage(GuidePage.newInstance()
                        .addHighLight(video)
                        .setLayoutRes(R.layout.view_guide))
                .show();


        TimeAxisContainer container = findViewById(R.id.time_axis_container);
        container.setHikVisionVideoView(video);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        HikVisionDeviceHelper.unInitHikVisionSDK();

    }

    public void doPreView(View view) {
        video.doPreview("183j125r73.iask.in", 20001, "admin", "bjxg12345", 1);
    }

    public void stopPreView(View view) {
        video.stopPreview();
    }

    public void pausePreView(View view) {
        video.pausePreView();
    }

    public void resumePreView(View view) {
        video.resumePreView();

    }

    public void doPreViewPb(View view) {
        video.doPreviewPlayBack("183j125r73.iask.in", 8000, "admin", "bjxg12345", 37, new Date(System.currentTimeMillis() - 100000),false);
    }

    public void stopPreViewPb(View view) {
        video.stopPreviewPlayBack();
    }

    public void pausePreViewPb(View view) {
        video.pausePreviewPlayBack();
    }

    public void resumePreViewPb(View view) {
        video.resumePreviewPlayBack();

    }

    public void fastPreViewPb(View view) {
        video.setPlayBackControlMode(HikVisionPlayBackMode.PLAY_X2);
    }

    public void slowPreViewPb(View view) {
        video.setPlayBackControlMode(HikVisionPlayBackMode.PLAY_X1_2);

    }

    public void size(View view) {
        video.setWindowSize(HikVisionVideoViewSize.OTHER, 1);
    }

    public void file(View view) {
        List<RecordSegment> playBackVideoFile = video.findPlayBackVideoFile(new Date(),2);
        timeAxisView.addFileInfoList(playBackVideoFile);
    }

}
