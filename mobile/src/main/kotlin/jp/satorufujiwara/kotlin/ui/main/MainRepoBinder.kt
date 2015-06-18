package jp.satorufujiwara.kotlin.ui.main.drawer

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import butterknife.bindView
import jp.satorufujiwara.binder.recycler.RecyclerBinder
import jp.satorufujiwara.kotlin.R
import jp.satorufujiwara.kotlin.data.api.dto.Repo
import jp.satorufujiwara.kotlin.ui.main.MainViewType

public class MainRepoBinder(
        activity: Activity, val repo: Repo) : RecyclerBinder<MainViewType>(activity, MainViewType.REPO) {

    override fun layoutResId(): Int {
        return R.layout.main_repo_binder
    }

    override fun onCreateViewHolder(view: View?): RecyclerView.ViewHolder? {
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        holder as ViewHolder
        holder.textView.setText(repo.name)
        holder.rootLayout.setOnClickListener {}
    }

    class ViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
        val rootLayout: RelativeLayout by bindView(R.id.rootLayout)
        val textView: TextView by bindView(R.id.textView)
    }
}


