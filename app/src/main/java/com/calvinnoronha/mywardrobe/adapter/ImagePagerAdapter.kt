package com.calvinnoronha.mywardrobe.adapter

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.calvinnoronha.mywardrobe.R
import com.calvinnoronha.mywardrobe.model.WardrobeElement
import kotlinx.android.synthetic.main.layout_wardrobe_element.view.*

/**
 * PagerAdapter which holds a list of Wardrobe elements.
 * This is responsible for showing a list of images.
 */
class ImagePagerAdapter(private val imageList: MutableList<WardrobeElement>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun getCount() = imageList.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val imageView = inflater.inflate(R.layout.layout_wardrobe_element,
                container, false) as ImageView

        val wardrobeElement = imageList[position]

        imageView.wardrobe_element_content.setImageResource(wardrobeElement.getPlaceholder())
        container.addView(imageView)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
