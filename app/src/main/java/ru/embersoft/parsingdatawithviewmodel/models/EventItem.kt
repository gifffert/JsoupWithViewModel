package ru.embersoft.parsingdatawithviewmodel.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventItem(
    var id: Int = 0,
    var title: String = "",
    var place: String = "",
    var date: String = "",
    var desc: String = "",
    var image: String = "",
    var url: String = ""
) : Parcelable