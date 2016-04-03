package jp.satorufujiwara.kotlin.ui.main

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.MenuItem
import butterknife.bindView
import com.jakewharton.rxbinding.support.v4.widget.drawerOpen
import jp.satorufujiwara.kotlin.AbstractActivity
import jp.satorufujiwara.kotlin.R
import jp.satorufujiwara.kotlin.util.ext.setContentFragment
import rx.Observable

class MainActivity : AbstractActivity() {

    companion object {
        fun createIntent(activity: Activity) = Intent(activity, MainActivity::class.java)
    }

    val toolBar: Toolbar by bindView(R.id.toolBar)
    val drawerLayout: DrawerLayout by bindView(R.id.drawerLayout)
    val drawerToggle: ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(this, drawerLayout,
                R.string.main_activity_toolbar, R.string.main_activity_toolbar)
    }
    val drawerObservable: Observable<Boolean> by lazy { drawerLayout.drawerOpen(Gravity.LEFT) }
    val component: MainComponent by lazy { MainComponent.Initializer.init(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
        setContentView(R.layout.main_activity)
        setContentFragment(R.id.containerLayout, MainFragment.newInstance())
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawerToggle.isDrawerIndicatorEnabled = true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean =
            if (drawerToggle.onOptionsItemSelected(item)) true
            else super.onOptionsItemSelected(item)

}
