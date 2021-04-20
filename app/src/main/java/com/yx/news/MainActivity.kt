package com.yx.news

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.common.base.BasePageAdapter
import com.common.base.CommonBaseActivity
import com.yx.news.databinding.ActivityMainBinding
import com.yx.news.model.Constants
import com.yx.news.ui.fragment.NewFragment
import com.yx.news.ui.activity.SucceedPrisonActivity
import com.yx.news.util.BaseUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : CommonBaseActivity<ActivityMainBinding>() {

    companion object {
        /**
         * @param context -跳转主界面
         */
        fun startMainActivity(context: Context) {
            if (BaseUtil.isFastDoubleClick()) return//双击过快处理
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

//    var titleList = arrayListOf<String>(
//        "新闻", "娱乐"
//    )
//    var titleType = arrayListOf<String>(
//        "T1348647853363",
//        "T1348648517839"
//    )

    override fun initView() {

        setTitle(Constants.succeedName)

/*        val mFragment = ArrayList<Fragment>()
        for (i in titleList.indices) {
            mFragment.add(NewFragment().newInstance(titleType[i]))
        }
        val adapter = BasePageAdapter(supportFragmentManager, mFragment, titleList)
        viewPager.adapter = adapter
        tabLyout.setupWithViewPager(viewPager)*/

        startActivity<SucceedPrisonActivity> {
            putExtra("", "")
        }

    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

}
