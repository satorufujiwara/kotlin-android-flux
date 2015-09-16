package jp.satorufujiwara.kotlin.data.api

import jp.satorufujiwara.kotlin.data.api.dto.Repo
import retrofit.http.GET
import retrofit.http.Path
import rx.Observable

public interface GitHubService {

    @GET("/users/{user}/repos")
    fun listRepos(@Path("user") user: String): Observable<List<Repo>>

}
