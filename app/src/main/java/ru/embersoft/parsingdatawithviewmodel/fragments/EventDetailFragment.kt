package ru.embersoft.parsingdatawithviewmodel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import ru.embersoft.parsingdatawithviewmodel.R
import ru.embersoft.parsingdatawithviewmodel.databinding.FragmentEventDetailBinding
import ru.embersoft.parsingdatawithviewmodel.viewmodels.EventViewModel

class EventDetailFragment : Fragment() {

    private lateinit var binding: FragmentEventDetailBinding
    private val viewModel by lazy { ViewModelProvider(this).get(EventViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventDetailBinding.inflate(inflater,container,false)

        binding.progressLayout.visibility = View.VISIBLE

        val args = EventDetailFragmentArgs.fromBundle(requireArguments())
        val item = args.eventItem

        binding.titleTextView.text = item!!.title
        binding.placeTextView.text = item.place
        binding.dateTextView.text = item.date
        Picasso.get().load(item.image).into(binding.imageView)

        viewModel.fetchEvent(item.url).observe(viewLifecycleOwner, Observer {
            binding.ticketTextView.text = it.ticketInfo
            binding.detailTextView.text = it.detail
            binding.progressLayout.visibility = View.GONE
        })

        return binding.root
    }

}