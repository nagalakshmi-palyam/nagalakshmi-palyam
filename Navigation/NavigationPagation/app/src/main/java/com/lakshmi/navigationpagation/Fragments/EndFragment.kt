package com.lakshmi.navigationpagation.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.lakshmi.navigationpagation.R
import kotlinx.android.synthetic.main.fragment_end.*
import kotlinx.android.synthetic.main.fragment_start.*

class EndFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_end, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initview(view)
    }
    fun initview(view:View){
        var navcontroller: NavController = Navigation.findNavController(view)
        btnover.setOnClickListener {
           var  navoptions:NavOptions=NavOptions.Builder().setPopUpTo(R.id.startFragment,true).build()
            navcontroller.navigate(R.id.action_endFragment_to_startFragment,null,navoptions)
        }
        var args: Unit? = arguments?.let {
            EndFragmentArgs.fromBundle(it)
            Toast.makeText(context,"GameLakshmi is " +it, Toast.LENGTH_SHORT).show()
        }
    }


}