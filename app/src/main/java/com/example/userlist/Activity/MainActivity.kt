package com.example.userlist.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userlist.Adapter.PlanetaAdapter
import com.example.userlist.R
import com.example.userlist.Repository.PlanetaRepository
import com.example.userlist.interfaces.PlanetaItemListener

class MainActivity : AppCompatActivity(), PlanetaItemListener {

    private lateinit var mUserList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val adapter = PlanetaAdapter(PlanetaRepository.findAll())

        mUserList = findViewById(R.id.main_recycle_view)
        mUserList.layoutManager = LinearLayoutManager(this)
        mUserList.adapter = adapter
        adapter.setOnUserItemListener(this)
    }

    override fun onListItemClick(view: View, position: Int) {
        val it = Intent(applicationContext, DetailActivity::class.java)
        it.putExtra("position", position)
        startActivity(it)
    }
}