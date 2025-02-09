package ru.otus.compose.di

import okhttp3.Interceptor
import okhttp3.Response
import ru.otus.compose.BuildConfig
import java.io.IOException

private const val AUTHORIZATION_HEADER = "apikey"
private const val HASH = "hash"

open class AuthorizationInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        return proceedRequestWithAuthorization(chain)
    }

    private fun proceedRequestWithAuthorization(chain: Interceptor.Chain): Response {
        val publicKey = BuildConfig.MARVEL_PUBLIC_KEY
        val privateKey = BuildConfig.MARVEL_PRIVATE_KEY

        var request = chain.request()
        val url = request.url.newBuilder()
                .addQueryParameter(AUTHORIZATION_HEADER, publicKey)
                .addQueryParameter(HASH, privateKey)
                .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}
