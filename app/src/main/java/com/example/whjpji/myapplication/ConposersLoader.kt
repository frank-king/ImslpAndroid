package com.example.whjpji.myapplication

import android.os.AsyncTask
import android.util.Log
import org.jsoup.Jsoup

/**
 * Created by whjpji on 18-4-20.
 */
class ComposersLoader : AsyncTask<Void, Void, Array<String>>() {
    private val IMSLP_DOMAIN = "http://cn.imslp.org"
    private val CATEGORY_COMPOSERS = IMSLP_DOMAIN + "/wiki/Category:Composers"
    private val IMSLP_URL = "http://cn.imslp.org/wiki/Category:Composers"
    private val USER_AGENT = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:59.0) Gecko/20100101 Firefox/59.0"
    private val COOKIES = mapOf(
            Pair("imslp_wikiLanguageSelectorLanguage", "en"),
            Pair("__qca", "P0-931847183-1494143683505"),
            Pair("_ga", "GA1.2.868176176.1523531885"),
            Pair("__stripe_mid", "d0740a12-316c-469b-9825-75777bb47ccf"))

    override fun doInBackground(vararg params: Void?): Array<String> {
        val document = Jsoup.connect(IMSLP_URL)
                .userAgent(USER_AGENT)
                .cookies(COOKIES)
                .get()
        val text = document.body().toString()
        text.split("\n").forEach { Log.d("imslp", it) }
        return emptyArray()
    }

    override fun onPostExecute(result: Array<String>?) {
        super.onPostExecute(result)
    }
}