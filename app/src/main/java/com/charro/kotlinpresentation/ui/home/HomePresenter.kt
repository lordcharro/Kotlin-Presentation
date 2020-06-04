package com.charro.kotlinpresentation.ui.home

import android.content.Context
import android.util.Log
import com.charro.kotlinpresentation.extension.MyObject
import com.charro.kotlinpresentation.extension.toast
import com.charro.kotlinpresentation.interfaces.HomeInterface
import kotlinx.coroutines.*

class HomePresenter(view: HomeInterfaceFromFragment) : HomeInterface {

    private var view: HomeInterfaceFromFragment = view

    override fun onClickMe(context: Context) {

        //Toast.makeText(context, "the button was clicked", Toast.LENGTH_SHORT).show()

        // EXAMPLE: Coroutines
        GlobalScope.launch(context = Dispatchers.Main) {
            delay(5000)
            showToast(context)
        }

        CoroutineScope(context = Dispatchers.IO).launch {
            showImportantMessage(context);
        }

    }




    private fun showToast(context: Context)
    {
        // EXAMPLE: Extension Function and Default parameter (duration)
        context.toast("the button was clicked")
    }

    private suspend fun showImportantMessage(context: Context)
    {
        withContext(Dispatchers.Main) {
            view.onButtonClickMe("important message")
        }
    }





    // EXAMPLE Syntax
    fun sumInKotlin(a: Int, b: Int): Int
    {
        return a + b
    }

    fun sumInKotlin2(a: Int, b: Int) = a + b




    // EXAMPLE LateInit
    private fun lateToTheParty()
    {
        var withoutInit: MyObject
        //withoutInit.title

        lateinit var notNullVar: MyObject
        notNullVar.title
    }

    // EXAMPLE Lazy
    private fun lazy()
    {
        val lazyValue: String by lazy{
            "Hello"
        }

        view.onButtonClickMe(lazyValue)
    }


    // EXAMPLE Elvis
    private fun sing()
    {
        var b: String? = null

        val elvis: Int = if (b != null) b.length else -1

        // elvis and safe call operator
        val elvis2 = b?.length ?: -1

        //safe call operator with let
        val something = b?.let {
            Log.d("sometag", "blabla")
        }
    }

    fun companion()
    {
        MyObject.makeNews("title", "subject", 1)
    }
}