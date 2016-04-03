package jp.satorufujiwara.kotlin.ui.main

import android.content.ContentValues
import com.squareup.sqlbrite.BriteDatabase
import jp.satorufujiwara.kotlin.data.api.dto.Repo
import jp.satorufujiwara.kotlin.util.ext.getStringByName
import rx.subjects.PublishSubject
import rx.subjects.SerializedSubject

class MainDispatcher(val db: BriteDatabase) {

    companion object {
        const val TABLE_NAME = "repo"
        private const val DB_ID = "_id"
        private const val SCREEN_ID = "screen_id"
        private const val REPO_ID = "repo_id"
        private const val REPO_NAME = "repo_name"
        fun createTable() = "CREATE TABLE $TABLE_NAME ($DB_ID INTEGER NOT NULL PRIMARY KEY,$SCREEN_ID TEXT,$REPO_ID TEXT,$REPO_NAME TEXT)"
    }

    private val emptyObservable = SerializedSubject(PublishSubject.create<String>())
    val errorEventObservable = SerializedSubject(PublishSubject.create<String>())

    fun deleteAll() = db.delete(TABLE_NAME, "")

    fun repos(screenId: String) =
            db.createQuery(TABLE_NAME, "SELECT * FROM $TABLE_NAME WHERE $SCREEN_ID=?", screenId)
                    .mapToList { Repo(it.getStringByName(REPO_ID), it.getStringByName(REPO_NAME)) }
                    .mergeWith(emptyObservable.filter { it == screenId }.map { emptyList<Repo>() })

    fun dispatch(screenId: String, list: List<Repo>) = db.newTransaction().run {
        var rows = 0
        try {
            db.delete(TABLE_NAME, "$SCREEN_ID=?", screenId)
            list.filterNotNull().map { repo ->
                ContentValues().apply {
                    put(SCREEN_ID, screenId)
                    put(REPO_ID, repo.id)
                    put(REPO_NAME, repo.name)
                }
            }.forEach {
                db.insert(TABLE_NAME, it)
                rows++
            }
            markSuccessful()
        } finally {
            end()
        }
        if (list.size == 0 && rows == 0) emptyObservable.onNext(screenId)
        rows
    }

    fun dispatchError(message: String) = errorEventObservable.onNext(message)

}