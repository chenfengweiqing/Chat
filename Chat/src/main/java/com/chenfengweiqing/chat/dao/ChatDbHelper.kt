package com.chenfengweiqing.chat.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper

class ChatDbHelper(context: Context) : ManagedSQLiteOpenHelper(context, DB_NAME) {
    companion object {
        val DB_NAME = "chat.db"
        val DB_VERSION = 1
    }

    private val INTEGER = " INTEGER"
    private val TEXT = " TEXT"
    private val COMMA = ","
    private val SQL_CREATE_ENTRIES = "CREATE TABLE " + MessageContract.TABLE_MESSAGE + " (" +
            MessageContract._ID + " INTEGER PRIMARY KEY," +
            MessageContract.COLUMN_CLIENT_MSG_ID + TEXT + COMMA +
            MessageContract.COLUMN_MSG_ID + TEXT + COMMA +
            MessageContract.COLUMN_MSG_TYPE + INTEGER + COMMA +
            MessageContract.COLUMN_SUBMSG_TYPE + INTEGER + COMMA +
            MessageContract.COLUMN_APP_MSG_TYPE + INTEGER + COMMA +
            MessageContract.COLUMN_CONTENT + TEXT + COMMA +
            MessageContract.COLUMN_URL + TEXT + COMMA +
            MessageContract.COLUMN_FROM_USER_NAME + TEXT + COMMA +
            MessageContract.COLUMN_TO_USER_NAME + TEXT + COMMA +
            MessageContract.COLUMN_FROM_NICK_NAME + TEXT + COMMA +
            MessageContract.COLUMN_TO_NICK_NAME + TEXT + COMMA +
            MessageContract.COLUMN_FROM_MEMBER_USER_NAME + TEXT + COMMA +
            MessageContract.COLUMN_FROM_MEMBER_NICK_NAME + TEXT + COMMA +
            MessageContract.COLUMN_VOICE_LENGTH + INTEGER + COMMA +
            MessageContract.COLUMN_CREATE_TIME + INTEGER +
            " ) "

    val SQL_DROP_ENTRIES = "DROP TABLE IF EXISTS " + MessageContract.TABLE_MESSAGE

    val SQL_DELETE_ENTRIES = ("DELETE FROM " + MessageContract.TABLE_MESSAGE)

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(SQL_DROP_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }


    fun clearMsg() {
        getWritableDatabase().execSQL(SQL_DELETE_ENTRIES)
    }

}