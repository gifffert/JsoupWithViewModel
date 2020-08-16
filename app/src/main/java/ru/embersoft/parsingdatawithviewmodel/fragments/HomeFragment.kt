package ru.embersoft.parsingdatawithviewmodel.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import ru.embersoft.parsingdatawithviewmodel.R
import ru.embersoft.parsingdatawithviewmodel.adapters.EventAdapter
import ru.embersoft.parsingdatawithviewmodel.databinding.FragmentHomeBinding
import ru.embersoft.parsingdatawithviewmodel.viewmodels.EventViewModel
import ru.embersoft.parsingdatawithviewmodel.viewmodels.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by lazy { ViewModelProvider(this).get(EventViewModel::class.java) }
    private lateinit var adapter: EventAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        adapter = EventAdapter(requireActivity())
        binding.recyclerView.adapter = adapter

        //important: in fragment need set owner viewLifecycleOwner
        viewModel.fetchData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            binding.progressBar.visibility = View.GONE
        })

        return binding.root
    }
}