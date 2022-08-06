package com.onix.internship.homesecurity

import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.homesecurity.data.DataWebPage
import com.onix.internship.homesecurity.data.House
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.io.IOException
import org.json.JSONObject
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class ParseViewModel:BaseViewModel() {



    private var secThread: Thread? = null
    private var runnable: Runnable? = null
    val handler = Handler(Looper.getMainLooper())

    private val _name = MutableLiveData("name")
    val name : LiveData<String>
        get() = _name

    private val _version = MutableLiveData("version")
    val version : LiveData<String>
        get() = _version

    private val _sensorList = MutableLiveData<List<House>>()
    val sensorList : LiveData<List<House>>
        get() = _sensorList


    init {   runnable = Runnable { getWeb() }
         secThread = Thread(runnable)
         secThread!!.start()  }




    fun getWeb( ) {
        try {
            val doc: Document =
                Jsoup.connect("https://onix-systems.github.io/OnixAndroidInternship2022/").get()
            val contentByPtag: Elements = doc.getElementsByTag("p")
            val dataSource = contentByPtag[4].text()
            val jsonData=dataSource.replace('“','"')
            val jsonData2=jsonData.replace('”','"')
            val data = Json.decodeFromString<DataWebPage>("""$jsonData2""")
           val sensorListHouse =data.house

            handler.post { _name.postValue( data.name.toString())
                          _version.postValue(data.version.toString())
                      _sensorList.value=sensorListHouse}

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

        }
