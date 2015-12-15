kotlin-android-example
====

This project is example of Android Application with Kotlin and Dagger2 and famous Libraries.

Kotlin
----
Kotlin version is [1.0.0-beta-3595](http://blog.jetbrains.com/kotlin/2015/12/kotlin-1-0-beta-3-is-out/).

Libraries
---------

 * Kotlin - http://kotlinlang.org
 * KotterKnife - https://github.com/JakeWharton/kotterknife
 * Dagger2 - http://google.github.io/dagger
 * OkHttp - http://square.github.io/okhttp
 * Retrofit - http://square.github.io/retrofit
 * Gson - https://github.com/google/gson
 * Glide - https://github.com/bumptech/glide
 * RxJava - https://github.com/ReactiveX/RxJava
 * RxAndroid - https://github.com/ReactiveX/RxAndroid
 * RxLifecycle - https://github.com/trello/RxLifecycle
 * Timber - http://github.com/JakeWharton/timber
 * LeakCanary - http://github.com/square/leakcanary
 * Stetho - http://facebook.github.io/stetho
 * Fabric - https://get.fabric.io
 * RecyclerviewBinder - https://github.com/satorufujiwara/recyclerview-binder

Tips
----

### Dagger2 injection

```kotlin
@Inject lateinit var gitHubRepository: GitHubRepository
```

### kapt

http://blog.jetbrains.com/kotlin/2015/05/kapt-annotation-processing-for-kotlin/
http://blog.jetbrains.com/kotlin/2015/06/better-annotation-processing-supporting-stubs-in-kapt/

If use with Dagger2, must enable 'generateStub' option.

```Groovy
kapt {
    generateStubs = true
}
```

Note
----
Fabirc [Api Key](./mobile/src/main/AndroidManifest.xml#L22) and [Api Secret](./mobile/fabric.properties#L3) are empty.
If you would build, should use your valid Api Key and Api Secret.


ToDo
----
At [issues](https://github.com/satorufujiwara/kotlin-android-example/issues).

If you want to suggest better implementation or you have found some mistakes in this projects,

Please tell me at [issue](https://github.com/satorufujiwara/kotlin-android-example/issues).

Thanks
------
* u2020 - https://github.com/JakeWharton/u2020
* u2020-mvp - https://github.com/LiveTyping/u2020-mvp
* kotlin-dagger-example - https://github.com/damianpetla/kotlin-dagger-example

License
-------
    Copyright 2015 Satoru Fujiwara

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
