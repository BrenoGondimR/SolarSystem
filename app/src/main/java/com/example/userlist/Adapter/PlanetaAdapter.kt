package com.example.userlist.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userlist.Model.Planeta
import com.example.userlist.R
import com.example.userlist.interfaces.PlanetaItemListener


class PlanetaAdapter(val list: List<Planeta>) : RecyclerView.Adapter<PlanetaAdapter.UserViewHolder>() {

    private var listener: PlanetaItemListener? = null

    fun setOnUserItemListener(listener: PlanetaItemListener){
        this.listener = listener
    }

    class UserViewHolder(view: View, private val listener:PlanetaItemListener?) : RecyclerView.ViewHolder(view) {
        val userName: TextView
        val userEmail: TextView
        val imagePlaneta: ImageView

        init {

            view.setOnClickListener{
                listener?.onListItemClick(view, adapterPosition)
            }

            userName = view.findViewById(R.id.userlist_text_view_name)
            userEmail = view.findViewById(R.id.userlist_text_view_email)
            imagePlaneta = view.findViewById(R.id.main_imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list, parent, false)
        return UserViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.userName.text = list[position].name
        holder.userEmail.text = list[position].email
        holder.imagePlaneta.setImageResource(list[position].imagem)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}