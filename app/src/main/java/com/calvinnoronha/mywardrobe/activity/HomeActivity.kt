package com.calvinnoronha.mywardrobe.activity

import android.os.Bundle
import com.calvinnoronha.mywardrobe.R
import com.calvinnoronha.mywardrobe.fragment.BaseFragment
import com.calvinnoronha.mywardrobe.fragment.HomeFragment

class HomeActivity : BaseActivity() {

    override val contentLayout = R.layout.activity_main
    override val fragmentContainer = R.id.main_fragment_container
    override val fragment: BaseFragment? = null
        get() {
            if (field != null) return field
            val fromFragmentManager = supportFragmentManager.findFragmentByTag(HomeFragment.TAG)
            return if (fromFragmentManager == null) HomeFragment() else fromFragmentManager as HomeFragment
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
