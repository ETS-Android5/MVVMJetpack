package com.android.xg.elabtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.xg.hkview.HkView;
import com.android.xg.hkview.HkViewType;


public class HkViewTestActivity extends AppCompatActivity {

    HkView hkView, hkView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hkview_test);

        hkView = findViewById(R.id.hk);
        hkView2 = findViewById(R.id.hk2);


    }


    public void getType(View view) {
        Toast.makeText(this, "当前屏幕属性为; " + hkView.getType(), Toast.LENGTH_SHORT).show();
    }


    public void doPre(View view) {
        hkView.doPreview("183j125r73.iask.in", 20001, "admin", "bjxg12345");
    }

    public void stopPre(View view) {
        hkView.stopPreView();
    }

    public void doPreView(View view) {
        hkView2.doPreview("2x315o0650.iok.la", 10002, "admin", "bjxg12345");
    }

    public void stopPreView(View view) {
        hkView2.stopPreView();
    }

    public void gone(View view) {
        try {
            hkView.hide(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Visiable(View view) {
        try {
            hkView.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gone1(View view) {
        try {
            hkView2.hide(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Visiable1(View view) {
        try {
            hkView2.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
