package jp.satorufujiwara.kotlin.ui.main


class MainStore(val dispatcher: MainDispatcher) {

    fun errorEvents() = dispatcher.errorEventObservable

    fun repos(screenId: String) = dispatcher.repos(screenId)
}