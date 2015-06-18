package jp.satorufujiwara.kotlin.ui.main.drawer

import jp.satorufujiwara.binder.ViewType

public enum class MainDrawerViewType : ViewType {

    TRANSPARENT,
    NAVIGATION,
    TITLE,
    CHANNEL;

    override fun viewType(): Int {
        return ordinal()
    }
}