package com.android.xg.elabtest

import android.content.res.Configuration
import com.android.xg.elab6Manager.dialog.ELabErrorFragmentDialog
import com.android.xg.elab6Manager.OnSelectListener
import com.android.xg.elabManager.CapturePicMode
import com.android.xg.elabtest.databinding.ActivityMainBinding
import com.android.xg.hikvision.HikVisionViewType
import com.android.xg.hkview.DraggingStatus
import com.elab.libview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>(), OnSelectListener {

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun init() {
        elab.attachMainMenu(elab_menu)
        elab.setOnSelectListener(this)
        elab_menu.setOnMenuItemClick { menuBean, isLongPress ->
            when (menuBean.resId) {
                R.drawable.zzz_close -> {
                    //关闭信号
                    elab.close(isLongPress)
                }
                R.drawable.zzz_tab -> {
                    //切换布局
                    elab.changeELabLayoutType()
                }
                R.drawable.zzz_expand -> {
                    //电子放大
                    elab.electronicZoom()
                }
                R.drawable.zzz_clarity -> {
                    //切换清晰度
                    elab.changeClarity()
                }
                R.drawable.zzz_send_compare -> {
                    //图片对比
                    return@setOnMenuItemClick elab.getPictureFromHkView(
                        CapturePicMode.compare,
                        true
                    );
                }
                R.drawable.zzz_video_save -> {
                    //视频对比
                    elab.getVideoFromHkView(this)
                }
                R.drawable.zzz_voicetalk -> {
                    return@setOnMenuItemClick mdatabinding.elab.attachVoiceTalk(this)
                }
                R.drawable.zzz_capture -> {
                    //截图
                    elab.getPictureFromHkView(CapturePicMode.capture, true);
                }
                R.drawable.zzz_ptz -> {
                    //云台
                    elab.attachPTZPopWindow()
                }
                R.drawable.zzz_time_axis -> {
                    //时间轴
                    elab.attachTimeAxisPopWindow()
                }
                R.drawable.zzz_pre ->
                    mdatabinding.elab.toPreview()

                R.drawable.zzz_next ->
                    mdatabinding.elab.toNext()
                R.drawable.zzz_delete ->
                    mdatabinding.elab.removePicOrVideoFromCompare(isLongPress)
                R.drawable.zzz_choose_time ->
                    mdatabinding.elab.attachSelectTime()
                R.drawable.zzz_play_pause -> {
                    mdatabinding.elab.playOrPause()
                }
                R.drawable.zzz_beilv -> {
                    mdatabinding.elab.playFast()
                }
                R.drawable.zzz_mansu -> {
                    mdatabinding.elab.playSlow()
                }

            }

            return@setOnMenuItemClick false
        }


    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        elab.autoMode(newConfig)
        elab_menu.autoMode(newConfig)
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        ) {
            //横屏标题栏TAB不显示
            setFullScreen()
        } else if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
        ) {
            //竖屏标题栏TAB显示
            exitFullScreen()
        }
    }

    override fun onAddDeviceListener(type: HikVisionViewType?, position: Int) {

    }

    override fun onItemDraggingListener(draggingStatus: DraggingStatus?) {

    }


}
