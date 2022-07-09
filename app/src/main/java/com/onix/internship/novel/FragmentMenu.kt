package com.onix.internship.novel

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.MenuFragmentBinding
import com.onix.internship.ui.main.MainScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentMenu:BaseFragment<MenuFragmentBinding>(R.layout.menu_fragment) {
    val mediaPlayer:MyMediaPlayer by lazy {MyMediaPlayer(activity, R.raw.beliver)}
    lateinit var  activity:MainScreen
    override val viewModel: NovelViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         activity = requireActivity() as MainScreen
           binding.tvExit.setOnClickListener {
               mediaPlayer.stopPlayer()
               activity.finish()
           }
           binding.tvStart.setOnClickListener {
               navigate(R.id.fragmentLectureHall,clearStack = true)
           }

        binding.switch1.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) mediaPlayer.playPlayer()
            else { mediaPlayer.stopPlayer()
                 }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer.stopPlayer()
    }
}