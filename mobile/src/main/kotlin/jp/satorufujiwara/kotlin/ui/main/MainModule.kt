package jp.satorufujiwara.kotlin.ui.main

import com.squareup.sqlbrite.BriteDatabase
import dagger.Module
import dagger.Provides
import jp.satorufujiwara.kotlin.data.repository.GitHubRepository

@Module
class MainModule {

    @Provides
    @MainScope
    fun provideMainDispatcher(db: BriteDatabase) = MainDispatcher(db)

    @Provides
    @MainScope
    fun provideMainAction(dispatcher: MainDispatcher, repository: GitHubRepository) =
            MainAction(dispatcher, repository)

    @Provides
    @MainScope
    fun provideMainStore(dispatcher: MainDispatcher) = MainStore(dispatcher)
}
