package com.example.danmon.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.adapters.AdapterViewBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.danmon.R
import com.example.danmon.model.UserObject
import org.w3c.dom.Text

class UserAdapter(private val context: Context, val list: ArrayList<UserObject>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.e("OnCreateViewHolder", "OnCreateViewHolderCalled")

        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.custom_user_model,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        Log.e("getItemCountCalled", "getItemCountCalled")

        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Log.e("OnBindViewHolderCalled", position.toString() + "  " + "OnBindViewHolderCalled")
        holder.bindView(position)

    }

    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {



        fun bindView(position: Int) {
            view.findViewById<TextView>(R.id.listUserName).setText(list[position].name)
            view.findViewById<TextView>(R.id.listEmail).setText(list[position].email)
            view.findViewById<TextView>(R.id.listPassword).setText(list[position].password)


        }

    }

}
