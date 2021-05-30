package com.malih.dictapp


import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_activity.*


class DetailActivity: AppCompatActivity()  {
    var mediaPlayer:MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        val word = intent.getParcelableExtra<Word>(MainActivity.PARCELABLE_DETAIL_WORD)!!
        details_word_name.text  = word.name
        details_word_description.text = word.description
        word.picture?.let {
            detail_word_image.setImageResource(it)
        }
        word.audioLink?.let {
            mediaPlayer = MediaPlayer.create(this,it)
        }
        detail_audio_start_btn.setOnClickListener {
            if(mediaPlayer!=null){
                if(mediaPlayer!!.isPlaying){
                    mediaPlayer!!.pause()
                }else{
                    mediaPlayer!!.start()
                }
            }

        }

        word.videoLink?.let {
            val path = "android.resource://$packageName/raw/${word.videoLink}"
            detail_video.setVideoURI(Uri.parse(path))
        }

        detail_video_start_btn.setOnClickListener {
            if(detail_video.isPlaying){
                detail_video.pause()
            }else{
                detail_video.start()
            }
        }
    }
}