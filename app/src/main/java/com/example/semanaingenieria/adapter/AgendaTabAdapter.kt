package com.example.semanaingenieria.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.semanaingenieria.fragments.AgendaDayFragment

class AgendaTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3 // Lunes, Martes, Miércoles

    override fun createFragment(position: Int): Fragment {
        return AgendaDayFragment.newInstance(position)
    }
}
