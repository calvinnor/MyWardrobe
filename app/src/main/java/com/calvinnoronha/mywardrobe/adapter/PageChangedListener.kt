package com.calvinnoronha.mywardrobe.adapter

import android.support.v4.view.ViewPager

abstract class PageChangedListener : ViewPager.OnPageChangeListener {

    // NO-OP
    override fun onPageScrollStateChanged(state: Int) {}

    // NO-OP
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

}
