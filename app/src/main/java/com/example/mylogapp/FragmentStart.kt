package com.example.mylogapp

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mylogapp.databinding.FragmentStartBinding

class FragmentStart: Fragment(R.layout.fragment_start), Animation.AnimationListener {
    private lateinit var binding: FragmentStartBinding
    // private lateinit var inAnimation : Animation
    // private lateinit var outAnimation: Animation
    private lateinit var scaleAnimation: Animation


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentStartBinding.bind(view)
        val activity=requireActivity() as MainActivity
        scaleAnimation= AnimationUtils.loadAnimation(activity,R.anim.scale_anim)
        binding.cardView.startAnimation(scaleAnimation)
        scaleAnimation.setAnimationListener(this)
        //outAnimation=AnimationUtils.loadAnimation(activity,R.anim.alpha_out)
        //  inAnimation=AnimationUtils.loadAnimation(activity,R.anim.alpha_in)
        // inAnimation.setAnimationListener(this)
        // binding.textView.startAnimation(outAnimation)
        //  binding.textView.startAnimation(inAnimation)

    }

    override fun onAnimationStart(animation: Animation?) {

    }

    override fun onAnimationEnd(animation: Animation?) {
        findNavController().navigate(R.id.action_fragmentStart_to_fragmentLogin)
    }

    override fun onAnimationRepeat(animation: Animation?) {

    }


}