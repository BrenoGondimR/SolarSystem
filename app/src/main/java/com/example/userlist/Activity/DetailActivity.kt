package com.example.userlist.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.userlist.R
import com.example.userlist.Repository.PlanetaRepository

class DetailActivity : AppCompatActivity() {

    private lateinit var mDatailName: TextView
    private lateinit var mDatailInfos: TextView
    private lateinit var mDetailImage: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mDatailName = findViewById(R.id.detail_textview_name)
        mDatailInfos = findViewById(R.id.detail_textview_infos)
        mDetailImage = findViewById(R.id.main_imageView_detail)

        val data: Bundle? = intent.extras
        val position = data?.getInt("position", -1)
        val planet = PlanetaRepository.findAll()[position!!]

        mDatailName.text = planet.name
        mDatailInfos.text = planet.descricao
        mDetailImage.setImageResource(planet.imagem)

    }

}