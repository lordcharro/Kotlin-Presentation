package com.charro.kotlinpresentation.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.charro.kotlinpresentation.R
import com.charro.kotlinpresentation.interfaces.GalleryInterface
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment(), GalleryInterface {

    private lateinit var presenter: GalleryPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = GalleryPresenter(this)

        // EXAMPLE higher-order functions and lambdas
        radio_group.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
//                R.id.radio_1 -> {
//                    image.isVisible = true
//                    text_gallery.text = "radio1"
//                }
//
//                R.id.radio_2 -> {
//                    image.isVisible = false
//                    text_gallery.text = "radio2"
//                }

                R.id.radio_1 -> {exampleHigherOrderFunctions({showImageRadio1()}, "radio1")}
                R.id.radio_2 -> {exampleHigherOrderFunctions({hideImageRadio2()}, "radio2")}
            }
        }



        var sum = func(10)
        var totalsum = sum(20) //output 30
    }

    override fun changeText(text: String) {
        text_gallery.text = text
    }


    // EXAMPLE higher-order functions returning a function
    fun func(num: Int): (Int) -> Int = {num2 -> num2 + num}

    fun exampleHigherOrderFunctions(function: () -> Unit, title: String)
    {
        function()
        text_gallery.text = title
    }

    fun showImageRadio1() {
        image.isVisible = true
    }

    fun hideImageRadio2() {
        image.isVisible = false
    }
}
