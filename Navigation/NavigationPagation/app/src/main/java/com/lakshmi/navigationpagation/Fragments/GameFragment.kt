package com.lakshmi.navigationpagation.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.lakshmi.navigationpagation.R
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_start.*
import kotlinx.android.synthetic.main.fragment_start.btnstart

class GameFragment : Fragment() {
    var game=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initview(view)
    }
    fun initview(view:View){
        var navcontroller: NavController = Navigation.findNavController(view)
        btnfinish.setOnClickListener {
            var action:GameFragmentDirections.ActionGameFragmentToEndFragment=GameFragmentDirections.actionGameFragmentToEndFragment()
            action.setGameName(game)
            navcontroller.navigate(R.id.action_gameFragment_to_endFragment)
        }
        var args: Unit? = arguments?.let {
            GameFragmentArgs.fromBundle(it)
            game=it.toString()
            Toast.makeText(context,"Game is " +it, Toast.LENGTH_SHORT).show()
        }
    }
}