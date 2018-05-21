package com.calvinnoronha.mywardrobe.fragment

import com.calvinnoronha.mywardrobe.R

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
}
