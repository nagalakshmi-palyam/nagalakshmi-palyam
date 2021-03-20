package com.lakshmi.navigationpagation.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.lakshmi.navigationpagation.R
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initview(view)
    }
    fun initview(view:View){
        var navcontroller:NavController=Navigation.findNavController(view)
        btnstart.setOnClickListener {
           // val action=GameFragmentDirections.actionGameFragmentToEndFragment(etgame.text.toString())
            val action:StartFragmentDirections.ActionStartFragmentToGameFragment=StartFragmentDirections.actionStartFragmentToGameFragment();
            action.setNagalakshmiPalyam(etgame.text.toString())
            navcontroller.navigate(action)
        }

    }

}