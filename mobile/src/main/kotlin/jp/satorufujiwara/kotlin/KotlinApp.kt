package jp.satorufujiwara.kotlin

import android.content.Context
import com.squareup.leakcanary.RefWatcher
import jp.satorufujiwara.kotlin.DaggerApp

public class KotlinApp : DaggerApp() {

    companion object {
        fun refWatcher(context: Context): RefWatcher {
            return (context.getApplicationContext() as KotlinApp).refWatcher()
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}