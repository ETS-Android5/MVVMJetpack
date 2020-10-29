package com.android.xg.elabtest;

import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.tencent.qcloud.tim.uikit.component.photoview.PhotoView;

import java.io.File;


public class ZoomActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener {
    private RelativeLayout content;

    private TextureView textureView;
    private MediaPlayer mMediaPlayer;
    private Surface surface;
    private String mFilePath="/sdcard/11111.mp4";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        textureView =findViewById(R.id.tv);
        textureView.setSurfaceTextureListener(this);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        this.surface = new Surface(surface);
        if (new File(mFilePath).exists()) {
            play(mFilePath);    //播放视频
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        surface = null;
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }


    public void play(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {//文件不存在
                Toast.makeText(this, "文件路径错误", Toast.LENGTH_SHORT).show();
            }
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDataSource(file.getAbsolutePath());
            mMediaPlayer.setSurface(surface);
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setOnPreparedListener(mp -> mMediaPlayer.start());
            mMediaPlayer.prepare();
            mMediaPlayer.setOnCompletionListener(mp -> {
               /* delayHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        removeSelf();
                    }
                }, 1000);*/
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
