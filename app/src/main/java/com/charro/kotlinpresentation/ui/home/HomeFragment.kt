package com.charro.kotlinpresentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.charro.kotlinpresentation.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeInterfaceFromFragment {

    private lateinit var homeViewModel: HomeViewModel
    private var presenter: HomePresenter? = null
    private var root: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)

        root = inflater.inflate(R.layout.fragment_home, container, false)
        //val textView: TextView = root.findViewById(R.id.text_home)


        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            text_home.text = it
        })

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = HomePresenter(this)

        button_click_me.setOnClickListener { context?.let { it -> presenter?.onClickMe(it) } }
    }

    override fun onButtonClickMe(message: String) {

        text_home.setText(message)
    }
}







interface HomeInterfaceFromFragment {
    fun onButtonClickMe(message: String)
}
