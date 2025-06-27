package com.example.semanaingenieria.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.semanaingenieria.adapter.EventAdapter
import com.example.semanaingenieria.data.FakeData
import com.example.semanaingenieria.databinding.FragmentAgendaDayBinding

class AgendaDayFragment : Fragment() {
    private lateinit var binding: FragmentAgendaDayBinding
    private var dayIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dayIndex = arguments?.getInt("day") ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgendaDayBinding.inflate(inflater, container, false)
        binding.recyclerAgenda.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerAgenda.adapter = EventAdapter(FakeData.getEventsForDay(dayIndex))
        return binding.root
    }

    companion object {
        fun newInstance(day: Int) = AgendaDayFragment().apply {
            arguments = Bundle().apply { putInt("day", day) }
        }
    }
}
