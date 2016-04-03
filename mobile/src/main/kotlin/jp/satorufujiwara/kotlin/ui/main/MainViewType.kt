package jp.satorufujiwara.kotlin.ui.main

import jp.satorufujiwara.binder.ViewType

enum class MainViewType : ViewType {

    REPO;

    override fun viewType(): Int = ordinal
}
