package jp.satorufujiwara.kotlin.util;

import com.crashlytics.android.Crashlytics;

import android.util.Log;

import timber.log.Timber;

public class CrashlyticsTree extends Timber.Tree {

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (priority != Log.ERROR) {
            return;
        }
        Crashlytics.getInstance().core.log(priority, tag, message);
        if (t != null) {
            Crashlytics.getInstance().core.logException(t);
        }
    }

}
