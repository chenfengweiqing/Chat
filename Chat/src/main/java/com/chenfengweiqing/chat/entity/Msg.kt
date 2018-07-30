package com.chenfengweiqing.chat.entity

import android.os.Bundle
import com.alibaba.fastjson.annotation.JSONField
import java.lang.Cloneable

class Msg : Cloneable {
    private val TYPE = "type"
    private val CONTENT = "content"
    private val URL = "url"
    private val FROM_USER_NAME = "fromUserName"
    private val TO_USER_NAME = "toUserName"
    private val MSG_ID = "msgId"
    private val MSG_TYPE = "msgType"
    private val SUB_MSG_TYPE = "subMsgType"
    private val APP_MSG_TYPE = "appMsgType"
    private val FROM_NICK_NAME = "fromNickName"
    private val TO_NICK_NAME = "toNickName"
    private val FROM_MEMBER_USER_NAME = "fromMemberUserName"
    private val FROM_MEMBER_NICK_NAME = "fromMemberNickName"
    private val STATUS_NOTIFY_CODE = "statusNotifyCode"
    private val STATUS_NOTIFY_USER_NAME = "statusNotifyUserName"
    private val VOICE_LENGTH = "voiceLength"
    private val CREATE_TIME = "createTime"

    @JSONField(name = "Type")
    var type: Int = 0 //发送消息使用
    @JSONField(name = "Content")
    var content: String? = null
    @JSONField(name = "Url")
    var url: String? = null
    @JSONField(name = "FromUserName")
    var fromUserName: String? = null
    @JSONField(name = "ToUserName")
    var toUserName: String? = null
    @JSONField(name = "LocalID")
    var localID: Long = 0
    @JSONField(name = "ClientMsgId")
    var clientMsgId: Long = 0
    @JSONField(name = "MsgId")
    var msgId: String? = null //接收消息使用
    @JSONField(name = "MsgType")
    var msgType: Int = 0
    @JSONField(name = "SubMsgType")
    var subMsgType: Int = 0
    @JSONField(name = "AppMsgType")
    var appMsgType: Int = 0
    @JSONField(name = "VoiceLength")
    var voiceLength: Long = 0
    @JSONField(name = "CreateTime")
    var createTime: Long = 0
    @JSONField(name = "StatusNotifyCode")
    var statusNotifyCode: Int = 0
    @JSONField(name = "StatusNotifyUserName")
    var statusNotifyUserName: String? = null

    var fromNickName: String? = null//custom atrribute
    var toNickName: String? = null
    var fromMemberUserName: String? = ""
    var fromMemberNickName: String? = ""
    var appInfo: AppInfo? = null

    fun fromBundle(bundle: Bundle) {
        this.type = bundle.getInt(TYPE)
        this.content = bundle.getString(CONTENT)
        this.url = bundle.getString(URL)
        this.fromUserName = bundle.getString(FROM_USER_NAME)
        this.toUserName = bundle.getString(TO_USER_NAME)
        this.msgId = bundle.getString(MSG_ID)
        this.msgType = bundle.getInt(MSG_TYPE)
        this.subMsgType = bundle.getInt(SUB_MSG_TYPE)
        this.appMsgType = bundle.getInt(APP_MSG_TYPE)
        this.fromNickName = bundle.getString(FROM_NICK_NAME)
        this.toNickName = bundle.getString(TO_NICK_NAME)
        this.fromMemberUserName = bundle.getString(FROM_MEMBER_USER_NAME)
        this.fromMemberNickName = bundle.getString(FROM_MEMBER_NICK_NAME)
        this.statusNotifyCode = bundle.getInt(STATUS_NOTIFY_CODE)
        this.statusNotifyUserName = bundle.getString(STATUS_NOTIFY_USER_NAME)
        this.voiceLength = bundle.getLong(VOICE_LENGTH)
        this.createTime = bundle.getLong(CREATE_TIME)
    }

    fun toBundle(): Bundle {
        val bundle = Bundle()
        bundle.putInt(TYPE, this.type)
        bundle.putString(CONTENT, this.content)
        bundle.putString(URL, this.url)
        bundle.putString(FROM_USER_NAME, this.fromUserName)
        bundle.putString(TO_USER_NAME, this.toUserName)
        bundle.putString(MSG_ID, this.msgId)
        bundle.putInt(MSG_TYPE, this.msgType)
        bundle.putInt(SUB_MSG_TYPE, this.subMsgType)
        bundle.putInt(APP_MSG_TYPE, this.appMsgType)
        bundle.putString(FROM_NICK_NAME, this.fromNickName)
        bundle.putString(TO_NICK_NAME, this.toNickName)
        bundle.putString(FROM_MEMBER_USER_NAME, this.fromMemberUserName)
        bundle.putString(FROM_MEMBER_NICK_NAME, this.fromMemberNickName)
        bundle.putInt(STATUS_NOTIFY_CODE, this.statusNotifyCode)
        bundle.putString(STATUS_NOTIFY_USER_NAME, statusNotifyUserName)
        bundle.putLong(VOICE_LENGTH, this.voiceLength)
        bundle.putLong(CREATE_TIME, this.createTime)
        return bundle
    }


}