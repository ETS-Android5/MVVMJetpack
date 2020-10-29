package com.android.xg.elabtest;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.widget.ViewDragHelper;

/**
 * ELabMcAndroid
 * <p>
 * Created by 李阳 on 2020/9/2 0002
 * Copyright © 2020年 新广科技. All rights reserved.
 * <p>
 * Describe:
 */
public class ZoomLayout extends FrameLayout {

    // 螢幕寬高
    private int screenHeight;
    private int screenWidth;
    private ViewDragHelper mDragHelper;
    private long lastMultiTouchTime;// 記錄多點觸控縮放後的時間
    private int originalWidth;// view寬度
    private int originalHeight;// view高度
    private ScaleGestureDetector mScaleGestureDetector = null;
    // private View view;
    private int downX;// 手指按下的x座標值
    private int downY;// 手指按下的y座標值
    private int left;// view的左座標值
    private int top;// view的上座標值
    private int right;// view的右座標值
    private int bottom;// view的下座標值
    private int newHeight;
    private int newWidth;
    public boolean isScale = false;
    private float scale;
    private float preScale = 1;// 預設前一次縮放比例為1

    public ZoomLayout(@NonNull Context context) {
        super(context);
        init(context);

    }

    public ZoomLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ZoomLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    public ZoomLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);

    }


    private void init(Context context) {
        mDragHelper = ViewDragHelper.create(this, callback);
        mScaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureListener());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenWidth = getMeasuredWidth();
        screenHeight = getMeasuredHeight();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);
        return isScale;
    }


    private boolean needToHandle = true;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int pointerCount = event.getPointerCount(); // 獲得多少點
        if (pointerCount > 1) {// 多點觸控，
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_POINTER_2_UP://第二個手指擡起的時候
                    needToHandle = true;
                    break;
                case MotionEvent.ACTION_MOVE:

                    break;
                default:
                    break;
            }
            return mScaleGestureDetector.onTouchEvent(event);//讓mScaleGestureDetector處理觸控事件
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastMultiTouchTime > 200 && needToHandle) {
//多點觸控全部手指擡起後要等待200毫秒才能執行單指觸控的操作，避免多點觸控後出現顫抖的情況
                try {
                    mDragHelper.processTouchEvent(event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }

    private ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
        /**
         * 用於判斷是否捕獲當前child的觸控事件
         *
         * @param child
         *            當前觸控的子view
         * @param pointerId
         * @return true就捕獲並解析；false不捕獲
         */
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            if (preScale > 1) {
                return true;
            }
            return false;
        }

        /**
         * 控制水平方向上的位置
         */
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {

            if (left < (screenWidth - screenWidth * preScale) / 2)
                left = (int) (screenWidth - screenWidth * preScale) / 2;// 限制mainView可向左移動到的位置
            if (left > (screenWidth * preScale - screenWidth) / 2)
                left = (int) (screenWidth * preScale - screenWidth) / 2;// 限制mainView可向右移動到的位置
            return left;
        }

        public int clampViewPositionVertical(View child, int top, int dy) {

            if (top < (screenHeight - screenHeight * preScale) / 2) {
                top = (int) (screenHeight - screenHeight * preScale) / 2;// 限制mainView可向上移動到的位置
            }
            if (top > (screenHeight * preScale - screenHeight) / 2) {
                top = (int) (screenHeight * preScale - screenHeight) / 2;// 限制mainView可向上移動到的位置
            }
            return top;
        }

    };

    public class ScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            float previousSpan = detector.getPreviousSpan();// 前一次雙指間距
            float currentSpan = detector.getCurrentSpan();// 本次雙指間距
            if (currentSpan < previousSpan) {
                // 縮小
                scale = preScale - (previousSpan - currentSpan) / 1000;
            } else {
                // 放大
                scale = preScale + (currentSpan - previousSpan) / 1000;
            }
            // 縮放view
            if (scale > 0.5) {
                setScaleX(scale);// x方向上縮放
                setScaleY(scale);// y方向上縮放
            }
            return false;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            // 一定要返回true才會進入onScale()這個函式
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            preScale = scale;// 記錄本次縮放比例
            lastMultiTouchTime = System.currentTimeMillis();// 記錄雙指縮放後的時間
        }
    }


}
