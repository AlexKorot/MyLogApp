package com.onix.internship.homesecurity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.ParseFragBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class ParseFrag: BaseFragment<ParseFragBinding>(R.layout.parse_frag) {
    val adapter = SensorListAdapter(SensorItemListener { room ->
        Toast.makeText(context, "${room}", Toast.LENGTH_LONG).show()
    })
    override val viewModel: ParseViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        val manager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
        viewModel.sensorList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
                binding.rcViewSensor.layoutManager = manager
                binding.rcViewSensor.adapter = adapter
            }
        })


    }
}
