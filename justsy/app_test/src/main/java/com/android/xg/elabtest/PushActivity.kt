package com.android.xg.elabtest

import com.android.xg.elabtest.databinding.ActivityMainBinding
import com.elab.domain.http.ElabRestClient
import com.elab.libarch.trtc.ELabGenerateTestUserSig
import com.elab.libview.base.BaseActivity
import com.tencent.imsdk.TIMConversation
import com.tencent.imsdk.TIMConversationType
import com.tencent.imsdk.TIMManager
import com.tencent.qcloud.tim.uikit.Constants
import com.tencent.qcloud.tim.uikit.modules.chat.GroupChatManagerKit
import com.tencent.qcloud.tim.uikit.modules.message.MessageInfoUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_push.*
import java.util.*

class PushActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayout(): Int {
        return R.layout.activity_push
    }

    override fun init() {
        send.setOnClickListener {
            val mDataMap = HashMap<String, Any>()
            mDataMap[Constants.login_userPhone] = "13524653025"
            mDataMap[Constants.pushUserPhoneArr] =
                arrayOf(phone1.content, phone2.content, phone3.content, phone4.content)

            //发推送
            push(mDataMap)
            //发会诊
            /*val phone = "19500195000";
            TIMManager.getInstance().login(phone,ELabGenerateTestUserSig.genTestUserSig(phone),null)
            GroupChatManagerKit.createGroupChat()
            val buildCustomMessage = MessageInfoUtil.buildCustomMessage("")
            GroupChatManagerKit.getInstance().sendMessage(buildCustomMessage,true,null);
            TIMManager.getInstance().logout(null)*/
        }
    }

    fun push(map: MutableMap<String, Any>?) {
        ElabRestClient.getApiUrl().push(map).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(io.reactivex.schedulers.Schedulers.io())
            .subscribe(object : io.reactivex.Observer<Any?> {
                override fun onSubscribe(d: io.reactivex.disposables.Disposable) {}
                override fun onNext(o: Any) {}
                override fun onError(e: Throwable) {}
                override fun onComplete() {}
            })

    }
}