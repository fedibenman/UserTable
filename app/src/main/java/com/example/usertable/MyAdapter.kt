package com.example.usertable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class MyAdapter(private var myDataSet: List<User>, val listener: MainActivity):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var selectedPosition = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val vh = LayoutInflater.from(parent.context).inflate(R.layout.ligne,parent,false)
        return ViewHolder(vh)
    }

    override fun getItemCount(): Int {
        return myDataSet.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { //fontion pour afficher les donnee selon la position du curseur
        var current = myDataSet[position]
        holder.nameText.text = current.name.toString()
        holder.lastNameText.text = current.lastName.toString()
        holder.ageText.text = current.age.toString()



    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)


    }



    inner  class ViewHolder(val itemview: View):
        RecyclerView.ViewHolder(itemview), View.OnClickListener {
        val nameText = itemView.findViewById(R.id.name) as TextView
        val lastNameText = itemview.findViewById(R.id.lastName) as TextView
        val ageText = itemview.findViewById(R.id.age) as TextView
        init {
            itemView.setOnClickListener(this)

        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
                selectedPosition = position
                v?.setBackgroundColor(1) ;

            }
        }






    }

}
