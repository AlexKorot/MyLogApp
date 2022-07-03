package com.onix.internship.ui.splash

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.SplashFragmentBinding
import com.onix.internship.ui.translate.Slovnik
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.xmlpull.v1.XmlPullParser

class SplashFragment : BaseFragment<SplashFragmentBinding>(R.layout.splash_fragment) {


    override val viewModel: SplashViewModel by viewModel()

    override fun setObservers() {
        viewModel.initEvent.observe(this) {
            if (it) showLogInScreen()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getList()
    }

    private fun showLogInScreen() {
        navigate(R.id.translateFragment, clearStack = true)
    }

    fun getList() {
        val parser: XmlPullParser = resources.getXml(R.xml.slovnik)
        while (parser.eventType != XmlPullParser.END_DOCUMENT) {
            if (parser.eventType == XmlPullParser.START_TAG
                && parser.name.equals("ar")
            ) {

            }
            parser.next();
        }

          Log.d("myLog","$")
    }
}