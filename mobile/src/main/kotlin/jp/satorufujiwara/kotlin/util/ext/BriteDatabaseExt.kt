package jp.satorufujiwara.kotlin.util.ext

import android.database.Cursor

fun Cursor.getStringByName(columnName: String) = getString(getColumnIndexOrThrow(columnName))