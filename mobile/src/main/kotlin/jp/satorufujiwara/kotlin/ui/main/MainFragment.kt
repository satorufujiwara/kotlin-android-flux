package jp.satorufujiwara.kotlin.ui.main

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import com.trello.rxlifecycle.kotlin.bindToLifecycle
import jp.satorufujiwara.binder.Section
import jp.satorufujiwara.binder.recycler.RecyclerBinderAdapter
import jp.satorufujiwara.kotlin.AbstractFragment
import jp.satorufujiwara.kotlin.R
import jp.satorufujiwara.kotlin.util.ext.inflate
import jp.satorufujiwara.kotlin.util.ext.showToast
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import kotlin.properties.Delegates

class MainFragment : AbstractFragment() {

    companion object {
        private const val KEY_SCREEN_ID = "screenId"
        @JvmStatic fun newInstance() = MainFragment()
    }

    private var screenId: String by Delegates.notNull()
    val recyclerView: RecyclerView by bindView(R.id.recyclerView)
    val adapter: RecyclerBinderAdapter<MainSection, MainViewType> = RecyclerBinderAdapter()
    @Inject lateinit var mainAction: MainAction
    @Inject lateinit var mainStore: MainStore

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        (activity as MainActivity).component.inject(this)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(KEY_SCREEN_ID, screenId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screenId = savedInstanceState?.getString(KEY_SCREEN_ID) ?: hashCode().toString()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflate(R.layout.main_fragment, inflater, container)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        mainStore.repos(screenId)
                .observeOn(AndroidSchedulers.mainThread())
                .bindToLifecycle(this)
                .subscribe {
                    adapter.replaceAll(MainSection.CONTENTS, it.map { MainRepoBinder(activity, it) })
                    adapter.notifyDataSetChanged()
                }
        savedInstanceState ?: mainAction.refreshList(screenId)
    }

    override fun onResume() {
        super.onResume()
        mainStore.errorEvents()
                .observeOn(AndroidSchedulers.mainThread())
                .bindToLifecycle(this)
                .subscribe { activity.showToast(it) }
    }

    override fun onDestroyView() {
        adapter.clear()
        super.onDestroyView()
    }

    enum class MainSection : Section {
        CONTENTS;

        override fun position(): Int = ordinal
    }
}
