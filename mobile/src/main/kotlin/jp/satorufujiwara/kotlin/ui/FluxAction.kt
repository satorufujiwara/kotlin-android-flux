package jp.satorufujiwara.kotlin.ui

import com.squareup.sqlbrite.BriteDatabase
import jp.satorufujiwara.kotlin.ui.main.MainDispatcher
import rx.Observable
import rx.schedulers.Schedulers


class FluxAction(val db: BriteDatabase) {

    fun deleteDispatcherDb() = Observable.fromCallable {
        db.newTransaction().run {
            try {
                db.delete(MainDispatcher.TABLE_NAME, "")
                markSuccessful()
            } finally {
                end()
            }
        }
    }.subscribeOn(Schedulers.io())
}