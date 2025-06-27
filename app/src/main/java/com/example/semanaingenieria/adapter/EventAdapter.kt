package com.example.semanaingenieria.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.semanaingenieria.data.Event
import com.example.semanaingenieria.databinding.ItemEventCardBinding

class EventAdapter(private val events: List<Event>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(private val binding: ItemEventCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(event: Event) {
            binding.tvTitle.text = event.title
            binding.tvTime.text = event.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemEventCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount(): Int = events.size
}