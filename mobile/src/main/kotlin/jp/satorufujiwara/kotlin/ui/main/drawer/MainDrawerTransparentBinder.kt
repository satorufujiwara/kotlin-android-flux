package jp.satorufujiwara.kotlin.ui.main.drawer

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import jp.satorufujiwara.binder.recycler.RecyclerBinder
import jp.satorufujiwara.kotlin.R

public class MainDrawerTransparentBinder(activity: Activity) : RecyclerBinder<MainDrawerViewType>(
        activity, MainDrawerViewType.TRANSPARENT) {

    override fun layoutResId(): Int {
        return R.layout.main_drawer_transparent_binder
    }

    override fun onCreateViewHolder(view: View?): RecyclerView.ViewHolder? {
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
    }

    class ViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
    }
}


