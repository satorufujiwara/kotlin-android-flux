package jp.satorufujiwara.kotlin.ui

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import jp.satorufujiwara.kotlin.BuildConfig
import jp.satorufujiwara.kotlin.ui.main.MainDispatcher


class DispatcherDbOpenHelper(context: Context) : SQLiteOpenHelper(context, BuildConfig.APPLICATION_ID + ".dispatcher.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(MainDispatcher.createTable())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

}