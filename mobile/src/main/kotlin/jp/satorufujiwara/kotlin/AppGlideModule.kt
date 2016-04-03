package jp.satorufujiwara.kotlin

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.GlideModule
import com.squareup.okhttp.OkHttpClient
import java.io.InputStream

class AppGlideModule : GlideModule {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setMemoryCache(LruResourceCache(30 * 1024 * 1024)).setDecodeFormat(
                DecodeFormat.PREFER_ARGB_8888)
    }

    override fun registerComponents(context: Context, glide: Glide) {
        //no op
    }

    companion object {

        fun registerComponents(context: Context, okHttpClient: OkHttpClient) {
            Glide.get(context).register(GlideUrl::class.java, InputStream::class.java,
                    OkHttpUrlLoader.Factory(okHttpClient))
        }
    }
}
