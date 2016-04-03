package jp.satorufujiwara.kotlin.ui

import android.app.Application
import com.squareup.sqlbrite.BriteDatabase
import com.squareup.sqlbrite.SqlBrite
import dagger.Module
import dagger.Provides
import jp.satorufujiwara.kotlin.AppScope
import jp.satorufujiwara.kotlin.ui.DispatcherDbOpenHelper
import rx.schedulers.Schedulers
import javax.inject.Named

@Module
class FluxModule {

    @Provides
    @AppScope
    @Named("Dispatcher")
    fun provideSqlBrite() = SqlBrite.create()

    @Provides
    @AppScope
    @Named("Dispatcher")
    fun provideDispatcherDbOpenHelper(app: Application) = DispatcherDbOpenHelper(app)

    @Provides
    @AppScope
    fun provideDatabase(@Named("Dispatcher") sqlBrite: SqlBrite,
                        @Named("Dispatcher") helper: DispatcherDbOpenHelper) =
            sqlBrite.wrapDatabaseHelper(helper, Schedulers.io())

    @Provides
    @AppScope
    fun provideFluxAction(db: BriteDatabase) = FluxAction(db)

}