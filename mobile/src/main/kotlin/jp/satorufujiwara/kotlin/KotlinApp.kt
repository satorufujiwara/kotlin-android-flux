package jp.satorufujiwara.kotlin

import android.content.Context
import com.squareup.leakcanary.RefWatcher

public class KotlinApp : DaggerApp() {

    companion object {
        @JvmStatic fun refWatcher(context: Context): RefWatcher {
            return (context.applicationContext as KotlinApp).refWatcher()
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}