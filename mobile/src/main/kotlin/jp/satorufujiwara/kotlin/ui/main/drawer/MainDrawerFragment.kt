package jp.satorufujiwara.kotlin.ui.main.drawer

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.bindView
import com.bumptech.glide.Glide
import com.trello.rxlifecycle.kotlin.bindToLifecycle
import jp.satorufujiwara.binder.Section
import jp.satorufujiwara.binder.recycler.RecyclerBinderAdapter
import jp.satorufujiwara.kotlin.AbstractFragment
import jp.satorufujiwara.kotlin.R
import jp.satorufujiwara.kotlin.ui.main.MainActivity
import jp.satorufujiwara.kotlin.util.ext.inflate
import rx.android.schedulers.AndroidSchedulers
import rx.subjects.PublishSubject

class MainDrawerFragment : AbstractFragment() {

    companion object {
        private const val IMAGE_URL = "https://raw.githubusercontent.com/satorufujiwara/kotlin-android-example/master/art/header_image.jpg"
    }

    val recyclerView: RecyclerView by bindView(R.id.recyclerView)
    val headerImage: ImageView by bindView(R.id.headerImage)
    val headerLayout: View by bindView(R.id.headerLayout)
    val adapter: RecyclerBinderAdapter<MainDrawerSection, MainDrawerViewType> = RecyclerBinderAdapter()
    val scrollListener: OnScrollListener by lazy { OnScrollListener(headerLayout) }
    val itemClickObservable = PublishSubject.create<Intent>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflate(R.layout.main_drawer_fragment, inflater, container)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addOnScrollListener(scrollListener)

        adapter.add(MainDrawerSection.HEADER, MainDrawerTransparentBinder(activity))
        adapter.add(MainDrawerSection.NAVIGATION, MainDrawerNavigationBinder(activity,
                getString(R.string.main_drawer_navigation_home)))
        adapter.addAll(MainDrawerSection.NAVIGATION,
                (0..10).map {
                    MainDrawerNavigationBinder(activity, "Menu : $it") {
                        itemClickObservable.onNext(MainActivity.createIntent(activity))
                    }
                })
        Glide.with(this).load(IMAGE_URL).into(headerImage)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activity = (activity as MainActivity)
        itemClickObservable.observeOn(AndroidSchedulers.mainThread())
                .doOnNext { activity.drawerLayout.closeDrawers() }
                .zipWith(activity.drawerObservable.skip(1).filter { !it }) { intent, drawer -> intent }
                .bindToLifecycle(this)
                .subscribe { startActivity(it) }
    }

    override fun onDestroyView() {
        recyclerView.removeOnScrollListener(scrollListener)
        super.onDestroyView()
    }

    enum class MainDrawerSection : Section {
        HEADER,
        NAVIGATION;

        override fun position(): Int = ordinal
    }

    class OnScrollListener(val headerLayout: View) : RecyclerView.OnScrollListener() {
        var y: Int = 0
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            y += dy
            if (y > headerLayout.height) {
                return
            }
            headerLayout.translationY = (-y / 2).toFloat()
        }
    }
}
