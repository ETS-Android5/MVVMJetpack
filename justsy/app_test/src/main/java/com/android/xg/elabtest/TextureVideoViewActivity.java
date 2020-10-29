package com.android.xg.elabtest;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.elab.libview.supperView.TextureVideoView;

public class TextureVideoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texturevideo);

        TextureVideoView videoView = findViewById(R.id.texture);


        videoView.setVideoPath("/storage/emulated/0/elab/compare/video/compare_1591403231883.mp4");
        videoView.start();
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(TextureVideoViewActivity.this, "what: "+what+" extra: "+extra, Toast.LENGTH_SHORT).show();

                //异常回调
                return false;//如果方法处理了错误，则为true；否则为false。返回false或根本没有OnErrorListener，将导致调用OnCompletionListener。
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(TextureVideoViewActivity.this, "jjjj", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
