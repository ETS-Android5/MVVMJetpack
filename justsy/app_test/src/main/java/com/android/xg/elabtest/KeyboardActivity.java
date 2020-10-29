package com.android.xg.elabtest;

import android.content.pm.ActivityInfo;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.elab.libview.floatingKeyboard.FloatingKeyboardView;
import com.example.kamkeyboard.custom.KamEditText;
import com.example.kamkeyboard.custom.MyKeyBoardView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class KeyboardActivity extends AppCompatActivity {
    MyKeyBoardView keyboardView;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEditText(final KamEditText myEditText) {
        keyboardView.setEditText(myEditText);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        /**
         * 设置为横屏
         */
/*        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }*/

        MyKeyBoardView keyboardView = (MyKeyBoardView) findViewById(R.id.keyboardView);
        EventBus.getDefault().register(this);
        keyboardView.setOnKeyClickListener(new MyKeyBoardView.onKeyClickListener() {
            @Override
            public void onKeyClick(String str) {
                Log.e("===key", str + "");
            }
        });

        FloatingKeyboardView mCustomKeyboard = (FloatingKeyboardView) findViewById(R.id.floatingKeyboardView);
        mCustomKeyboard.setKeyboard(new Keyboard(this, R.xml.numkbd));
        mCustomKeyboard.setPreviewEnabled(false); // NOTE Do not show the preview balloons
        mCustomKeyboard.registerEditText(R.id.edittext1);
        mCustomKeyboard.setAllignBottomCenter(true);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
