package ru.embersoft.parsingdatawithviewmodel.repository

import android.content.Context
import org.jsoup.Jsoup
import ru.embersoft.parsingdatawithviewmodel.models.EventItem
import java.io.IOException

class Repo {

    companion object {
        var instance: Repo? = null
        lateinit var mContext: Context
    }

    fun getInstance(context: Context): Repo {
        mContext = context
        if (instance == null)
            instance = Repo()

        return instance!!
    }

    fun getEvents(): MutableList<EventItem> {
        val listData = mutableListOf<EventItem>()
        try {
            val url = "https://www.eventfinda.co.nz/whatson/events/new-zealand"
            val doc = Jsoup.connect(url).get()
            val events = doc.select("li.media.featured-listing.vevent")
            val eventsSize = events.size
            for (i in 0 until eventsSize) {
                val title = events.select("a.url.summary")
                    .eq(i)
                    .text()
                val place = events.select("a.location")
                    .eq(i)
                    .text()
                val date = events.select("span.value-title")
                    .eq(i)
                    .text()
                val desc = events.select("p.teaser.description")
                    .eq(i)
                    .text()
                val eventUrl = "https://www.eventfinda.co.nz" + events.select("p.teaser.description")
                    .select("a")
                    .eq(i)
                    .attr("href")
                val image = events.select("a.media-left.hidden-xs.hidden-sm")
                    .select("img")
                    .eq(i)
                    .attr("data-src")
                listData.add(EventItem(i,title,place,date,desc,image,eventUrl))
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return listData
    }


}