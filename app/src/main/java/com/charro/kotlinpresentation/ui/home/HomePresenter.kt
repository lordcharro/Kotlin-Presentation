package com.charro.kotlinpresentation.ui.home

import android.content.Context
import android.content.Intent
import com.charro.kotlinpresentation.activities.ComposeActivity
import com.charro.kotlinpresentation.extension.toast
import com.charro.kotlinpresentation.interfaces.HomeInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomePresenter(view: HomeInterface2) : HomeInterface {

    private var view: HomeInterface2 = view

    init {
        view.onButtonClickMe()
    }

    override fun onClickMe(context: Context) {

        //Toast.makeText(context, "the button was clicked", Toast.LENGTH_SHORT).show()

        // EXAMPLE: Coroutines
        GlobalScope.launch(context = Dispatchers.Main) {
            delay(5000)
            //showToast(context)
            goToComposeActivity(context)
        }

    }

    private fun showToast(context: Context) {
        // EXAMPLE: Extension Function and Default parameter (duration)
        context.toast("the button was clicked")
    }

    private fun goToComposeActivity(context: Context)
    {
        val intent = Intent(context, ComposeActivity::class.java)
        context.startActivity(intent)
    }
}