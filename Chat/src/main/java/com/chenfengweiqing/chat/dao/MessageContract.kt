package com.chenfengweiqing.chat.dao

class MessageContract {

    companion object {
        /**
         * The unique ID for a row.
         * <P>Type: INTEGER (long)</P>
         */
        val _ID = "_id"

        /**
         * The count of rows in a directory.
         * <P>Type: INTEGER</P>
         */
        val _COUNT = "_count"
        val TABLE_MESSAGE = "message"
        val COLUMN_CLIENT_MSG_ID = "client_msg_id"
        val COLUMN_MSG_ID = "msg_id"
        val COLUMN_MSG_TYPE = "msg_type"
        val COLUMN_SUBMSG_TYPE = "sub_msg_type"
        val COLUMN_APP_MSG_TYPE = "app_msg_type"
        val COLUMN_CONTENT = "content"
        val COLUMN_URL = "url"
        val COLUMN_FROM_USER_NAME = "from_username"
        val COLUMN_TO_USER_NAME = "to_username"
        val COLUMN_FROM_NICK_NAME = "from_nickname"
        val COLUMN_TO_NICK_NAME = "to_nickname"
        val COLUMN_FROM_MEMBER_USER_NAME = "from_member_username"
        val COLUMN_FROM_MEMBER_NICK_NAME = "from_member_nickname"
        val COLUMN_VOICE_LENGTH = "voice_length"
        val COLUMN_CREATE_TIME = "create_time"
    }
}