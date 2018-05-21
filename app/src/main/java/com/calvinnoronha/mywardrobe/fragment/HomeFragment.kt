package com.calvinnoronha.mywardrobe.fragment

import android.os.Bundle
import android.view.View
import com.calvinnoronha.mywardrobe.R
import com.calvinnoronha.mywardrobe.adapter.ImagePagerAdapter
import com.calvinnoronha.mywardrobe.model.BottomElement
import com.calvinnoronha.mywardrobe.model.TopElement
import com.calvinnoronha.mywardrobe.model.WardrobeElement
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A fragment to display Home.
 */
class HomeFragment : BaseFragment() {

    companion object {
        const val TAG = "HomeFragment"
    }

    override val fragmentTag = TAG
    override val layout = R.layout.fragment_main
    override val menu = R.menu.menu_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Show dummy data
        val topElements = ArrayList<WardrobeElement>()
        for (i in 0..10) topElements.add(TopElement())
        wardrobe_top_viewpager.adapter = ImagePagerAdapter(topElements)

        val bottomElements = ArrayList<WardrobeElement>()
        for (i in 0..10) bottomElements.add(BottomElement())
        wardrobe_bottom_viewpager.adapter = ImagePagerAdapter(bottomElements)

    }
}
