package ru.embersoft.parsingdatawithviewmodel.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import ru.embersoft.parsingdatawithviewmodel.models.EventDetail
import ru.embersoft.parsingdatawithviewmodel.models.EventItem
import ru.embersoft.parsingdatawithviewmodel.repository.Repo

class EventViewModel: ViewModel() {

    var items: MutableLiveData<MutableList<EventItem>> = MutableLiveData()

    fun init (context: Context) {
        if (items.value != null)
            return
    }

    private val repo = Repo()
    fun fetchData(): MutableLiveData<MutableList<EventItem>> {
        // load data async
        viewModelScope.launch(IO) {
            // for async load need use "postValue", else "setValue"
            items.postValue(repo.getEventsList())
        }
        return items

    }

    fun fetchEvent(url: String): MutableLiveData<EventDetail> {
        val item = MutableLiveData<EventDetail>()
        viewModelScope.launch(IO) {
            item.postValue(repo.getEvent(url))
        }
        return item
    }

}