package com.calvinnoronha.mywardrobe.adapter

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.calvinnoronha.mywardrobe.R
import com.calvinnoronha.mywardrobe.model.WardrobeElement


/**
 * PagerAdapter which holds a list of Wardrobe elements.
 * This is responsible for showing a list of images.
 */
class ImagePagerAdapter<T : WardrobeElement> : PagerAdapter() {

    private var imageList: MutableList<T> = ArrayList()
    private var glideRequestOptions = RequestOptions()

    /**
     * Set the items for this Image Adapter.
     */
    fun setItems(itemsList: MutableList<T>) {
        this.imageList.apply {
            clear()
            addAll(itemsList)
        }

        if (imageList.isNotEmpty()) {
            glideRequestOptions = RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(imageList[0].getPlaceholder())
        }

        notifyDataSetChanged()
    }

    fun addItem(topAdded: T) {
        this.imageList.add(topAdded)
        notifyDataSetChanged()
    }

    fun getItems() = imageList

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun getCount() = imageList.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val context = container.context
        val inflater = LayoutInflater.from(context)
        val imageView = inflater.inflate(R.layout.layout_wardrobe_element,
                container, false) as ImageView

        val wardrobeElement = imageList[position]

        Glide.with(context)
                .applyDefaultRequestOptions(glideRequestOptions)
                .load(wardrobeElement.getContent())
                .into(imageView)

        container.addView(imageView)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
