package com.calvinnoronha.mywardrobe.activity

import android.graphics.Typeface
import android.os.Bundle
import com.calvinnoronha.mywardrobe.R
import com.calvinnoronha.mywardrobe.app.APP_TOOLBAR_FONT
import com.calvinnoronha.mywardrobe.fragment.BaseFragment
import com.calvinnoronha.mywardrobe.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Main Activity for housing all Home content - HomeFragment
 */
class HomeActivity : BaseActivity() {

    override val contentLayout = R.layout.activity_home
    override val fragmentContainer = R.id.main_fragment_container
    override val fragment: BaseFragment? = null
        get() {
            if (field != null) return field
            val fromFragmentManager = supportFragmentManager.findFragmentByTag(HomeFragment.TAG)
            return if (fromFragmentManager == null) HomeFragment() else fromFragmentManager as HomeFragment
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupToolbar()
    }

    private fun setupToolbar() {
        val billabongFont = Typeface.createFromAsset(assets, APP_TOOLBAR_FONT)
        toolbar_title.typeface = billabongFont
        title = ""
    }
}
