package com.chenfengweiqing.chat.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_APP_MSG_TYPE
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_CLIENT_MSG_ID
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_CONTENT
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_CREATE_TIME
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_FROM_MEMBER_NICK_NAME
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_FROM_MEMBER_USER_NAME
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_FROM_NICK_NAME
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_FROM_USER_NAME
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_MSG_ID
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_MSG_TYPE
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_SUBMSG_TYPE
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_TO_NICK_NAME
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_TO_USER_NAME
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_URL
import com.chenfengweiqing.chat.dao.MessageContract.Companion.COLUMN_VOICE_LENGTH
import com.chenfengweiqing.chat.dao.MessageContract.Companion.TABLE_MESSAGE
import com.chenfengweiqing.chat.entity.Msg
import java.util.ArrayList

class MessageManager {
    @Volatile
    private var instance: MessageManager? = null
    private var mDbHelper: ChatDbHelper? = null

    private fun constructor() {
    }

    fun getInstance(): MessageManager? {
        if (null == instance) {
            synchronized(MessageManager::class.java) {
                if (null == instance) {
                    instance = MessageManager()
                }
            }
        }
        return instance
    }


    fun init(context: Context) {
        mDbHelper = ChatDbHelper(context)
    }

    fun insertMessage(msg: Msg): Boolean {
        val db = mDbHelper!!.getWritableDatabase()
        var newRowId: Long = -1
        try {
            val values = ContentValues()
            if (msg.createTime === 0L) {
                msg.createTime = System.currentTimeMillis()
            }
            values.put(MessageContract.COLUMN_CLIENT_MSG_ID, msg.clientMsgId)
            values.put(MessageContract.COLUMN_MSG_ID, msg.msgId)
            values.put(MessageContract.COLUMN_MSG_TYPE, msg.msgType)
            values.put(MessageContract.COLUMN_SUBMSG_TYPE, msg.subMsgType)
            values.put(MessageContract.COLUMN_APP_MSG_TYPE, msg.appMsgType)
            values.put(MessageContract.COLUMN_CONTENT, msg.content)
            values.put(MessageContract.COLUMN_URL, msg.url)
            values.put(MessageContract.COLUMN_FROM_USER_NAME, msg.fromUserName)
            values.put(MessageContract.COLUMN_TO_USER_NAME, msg.toUserName)
            values.put(MessageContract.COLUMN_FROM_NICK_NAME, msg.fromNickName)
            values.put(MessageContract.COLUMN_TO_NICK_NAME, msg.toNickName)
            values.put(MessageContract.COLUMN_FROM_MEMBER_USER_NAME, msg
                    .fromMemberUserName)
            values.put(MessageContract.COLUMN_FROM_MEMBER_NICK_NAME, msg
                    .fromMemberNickName)
            values.put(MessageContract.COLUMN_VOICE_LENGTH, msg.voiceLength)
            values.put(MessageContract.COLUMN_CREATE_TIME, msg.createTime)
            newRowId = db.insert(MessageContract.TABLE_MESSAGE, null, values)
        } finally {
        }
        return newRowId >= 0
    }

    fun getMsg(userName: String): List<Msg> {
        val db = mDbHelper!!.getReadableDatabase()
        var cursor: Cursor? = // don't group the rows
                null
        val msgList = ArrayList<Msg>()
        val selectionArgs = arrayOf(userName, userName)
        try {
            val sortOrder = COLUMN_CREATE_TIME + " ASC"
            cursor = db.query(TABLE_MESSAGE, null, // The columns to return
                    "from_username = ? or to_username = ?", // The columns for the WHERE clause
                    selectionArgs, null, null, // don't filter by row groups
                    sortOrder                                 // The sort order
            )// The table to query
            // The values for the WHERE clause
            while (cursor!!.moveToNext()) {
                val msg = Msg()
                msg.msgId = cursor!!.getString(cursor.getColumnIndexOrThrow(COLUMN_MSG_ID))
                msg.clientMsgId = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_CLIENT_MSG_ID))
                msg.msgType = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_MSG_TYPE))
                msg.subMsgType = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_SUBMSG_TYPE))
                msg.appMsgType = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_APP_MSG_TYPE))
                msg.content = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT))
                msg.url = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_URL))
                msg.fromUserName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FROM_USER_NAME))
                msg.toUserName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TO_USER_NAME))
                msg.fromNickName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FROM_NICK_NAME))
                msg.toNickName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TO_NICK_NAME))
                msg.fromMemberUserName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FROM_MEMBER_USER_NAME))
                msg.fromMemberNickName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FROM_MEMBER_NICK_NAME))
                msg.voiceLength = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_VOICE_LENGTH))
                msg.createTime = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_CREATE_TIME))
                msgList.add(msg)
            }
            return msgList
        } finally {
            if (null != cursor) {
                cursor.close()
            }
        }
    }

    fun clearMsg() {
        mDbHelper?.clearMsg()
    }

}