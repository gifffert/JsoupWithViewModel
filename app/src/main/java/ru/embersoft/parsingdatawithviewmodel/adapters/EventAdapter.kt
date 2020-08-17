package ru.embersoft.parsingdatawithviewmodel.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.embersoft.parsingdatawithviewmodel.BR
import ru.embersoft.parsingdatawithviewmodel.databinding.EventItemBinding
import ru.embersoft.parsingdatawithviewmodel.fragments.HomeFragmentDirections
import ru.embersoft.parsingdatawithviewmodel.models.EventItem

class EventAdapter(private val context: Context): RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    private var items = mutableListOf<EventItem>()
    fun setListData(data: MutableList<EventItem>) {
        items = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EventItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  items.size
    }

    override fun onBindViewHolder(holder: EventAdapter.ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(val binding: EventItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: EventItem) = with(itemView) {
            //use two way binding
            //BR - is auto-generating class
            binding.setVariable(BR.item, item)
            // apply changes
            binding.executePendingBindings()
            // set image
            Picasso.get().load(item.image).into(binding.imageView)

            itemView.setOnClickListener {
                // navigate to other fragment with Safe Args
                val action = HomeFragmentDirections.actionNavigationHomeToEventDetailFragment3(item)
                findNavController().navigate(action)
            }

        }

    }

}