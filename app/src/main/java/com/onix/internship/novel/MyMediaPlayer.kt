package com.onix.internship.novel

import android.content.Context
import android.media.MediaPlayer

class MyMediaPlayer(val context: Context,resRawMusic:Int) {

    val resRawMusic= context.resources.openRawResource(resRawMusic)
     var mediaplayer= MediaPlayer.create(context,resRawMusic)
    fun playPlayer(){
        mediaplayer.start()
    }
    fun stopPlayer(){
        mediaplayer.pause()
    }
}