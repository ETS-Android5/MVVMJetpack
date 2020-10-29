package com.android.xg.elabtest;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.elab.libview.base.BaseScreenRecordActivity;

@Deprecated
@SuppressLint("Registered")
public class RecordActivity extends BaseScreenRecordActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

    }

    @Override
    public void onRecordScreen(boolean success) {

    }

    @Override
    public int getLayout() {
        return 0;
    }

    @Override
    public void init() {

    }


}
