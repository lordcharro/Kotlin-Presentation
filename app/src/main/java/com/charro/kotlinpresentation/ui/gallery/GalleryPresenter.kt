package com.charro.kotlinpresentation.ui.gallery

import com.charro.kotlinpresentation.interfaces.GalleryInterface

class GalleryPresenter(view: GalleryInterface)
{
    private var view: GalleryInterface = view

    init {
        changeTextValue("some new text")
    }

    fun changeTextValue(value: String)
    {
        view.changeText(value)
    }
}