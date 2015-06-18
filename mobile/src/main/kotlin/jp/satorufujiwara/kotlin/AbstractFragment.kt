package jp.satorufujiwara.kotlin

import android.support.v4.app.Fragment
import jp.satorufujiwara.kotlin.data

public abstract class AbstractFragment : Fragment(){

    override fun onDestroy() {
        super.onDestroy()
        KotlinApp.refWatcher(getActivity()).watch(this)
    }
}
