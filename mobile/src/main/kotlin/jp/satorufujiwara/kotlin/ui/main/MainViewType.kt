package jp.satorufujiwara.kotlin.ui.main

import jp.satorufujiwara.binder.ViewType

public enum class MainViewType : ViewType {

    REPO;

    override fun viewType(): Int {
        return ordinal()
    }
}
