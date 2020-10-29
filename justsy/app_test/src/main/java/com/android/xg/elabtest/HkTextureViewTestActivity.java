package com.android.xg.elabtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.xg.hkview.HkTextureView;
import com.android.xg.hkview.HkViewType;


public class HkTextureViewTestActivity extends AppCompatActivity {

    HkTextureView hkView, hkView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_texture);

        hkView = findViewById(R.id.hk);
        hkView2 = findViewById(R.id.hk2);


    }

    public void doPreView(View view) {
        hkView.doPreview("183j125r73.iask.in", 20001, "admin", "bjxg12345",1);
    }

    public void doPre(View view) {
        hkView2.doPreview("2x315o0650.iok.la", 10002, "admin", "bjxg12345",1);
    }

    public void stopPreView(View view) {
        hkView.stopPreView();

    }

    public void stopPre(View view) {
        hkView2.stopPreView();
    }

    int count2 = 0;

    public void changeType(View view) {
        count2++;
        if (count2 % 3 == 0) {
            hkView2.setType(HkViewType.IS_REAL);

        } else if (count2 % 3 == 1) {
            hkView2.setType(HkViewType.IS_COMPARE);

        } else if (count2 % 3 == 2) {
            hkView2.setType(HkViewType.IS_PLAYBACK);
        }

        Toast.makeText(this, "当前屏幕属性为 : " + hkView2.getType(), Toast.LENGTH_SHORT).show();
    }

    int count = 0;

    public void changeType2(View view) {
        count++;
        if (count % 3 == 0) {
            hkView.setType(HkViewType.IS_REAL);

        } else if (count % 3 == 1) {
            hkView.setType(HkViewType.IS_COMPARE);

        } else if (count % 3 == 2) {
            hkView.setType(HkViewType.IS_PLAYBACK);
        }

        Toast.makeText(this, "当前屏幕属性为 : " + hkView.getType(), Toast.LENGTH_SHORT).show();
    }
}
