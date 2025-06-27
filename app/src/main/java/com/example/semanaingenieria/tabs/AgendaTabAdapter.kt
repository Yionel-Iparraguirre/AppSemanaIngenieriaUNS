package com.example.semanaingenieria.tabs

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.semanaingenieria.fragments.AgendaDayFragment

class AgendaTabsAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment = AgendaDayFragment.newInstance(position)
}