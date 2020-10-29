package com.android.xg.elabtest;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.elab.libview.utils.ConstraintUtil;

public class ConstraintActivity extends AppCompatActivity {
    ConstraintUtil constraintUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);
        ConstraintLayout constraintLayout=findViewById(R.id.parent);
        constraintUtil = new ConstraintUtil(constraintLayout);

    }

    public void apply(View view) {
        ConstraintUtil.ConstraintBegin begin = constraintUtil.beginWithAnim();

        begin.clear(R.id.btn1,R.id.btn2,R.id.btn3);

        begin.Left_toLeftOf(R.id.btn2,R.id.parent);
        begin.Left_toRightOf(R.id.btn1,R.id.parent);


        begin.setWidth(R.id.btn1, ConstraintSet.WRAP_CONTENT);
        begin.setWidth(R.id.btn2, ConstraintSet.WRAP_CONTENT);
        begin.setHeight(R.id.btn1, ConstraintSet.WRAP_CONTENT);
        begin.setHeight(R.id.btn2, ConstraintSet.WRAP_CONTENT);

        begin.commit();

    }
}
