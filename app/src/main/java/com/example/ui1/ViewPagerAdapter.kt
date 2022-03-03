package com.example.ui1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {

    val titulos:MutableList<String> = ArrayList()
    val fragments:MutableList<Fragment> = ArrayList()

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titulos[position]
    }

    fun addFragment(fragment: Fragment, string: String){
        fragments.add(fragment)
        titulos.add(string)
    }
}