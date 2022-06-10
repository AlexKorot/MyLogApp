package com.example.myquiz.ui

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myquiz.R
import com.example.myquiz.databinding.FragmentStartBinding


class Fragment_Start: Fragment(R.layout.fragment_start),Animation.AnimationListener
{
    private lateinit var binding: FragmentStartBinding
    private lateinit var scaleAnimation: Animation


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentStartBinding.bind(view)


         val activity=requireActivity() as MainActivity
          scaleAnimation=AnimationUtils.loadAnimation(activity,R.anim.scale_anim)
        scaleAnimation.setAnimationListener(this)
         binding.cardView.startAnimation(scaleAnimation)



    }



 override fun onAnimationStart(animation: Animation?) {

}

 override fun onAnimationEnd(animation: Animation?) {
   findNavController().navigate(R.id.action_fragment_Start_to_fragment_Show_Pages)
 }

 override fun onAnimationRepeat(animation: Animation?) {

 }


}


