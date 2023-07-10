package com.example.openinapp.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoretrofit.data.Links
import com.example.openinappbyriya.R

class TopLinkAdapter() : RecyclerView.Adapter<TopLinkAdapter.ViewHolder>()
{
    private var linklist : List<Links> = emptyList()

    fun setTopLinks(linklist : List<Links>)
    {
        this.linklist = linklist
        notifyDataSetChanged()
    }

     class ViewHolder (view: View): RecyclerView.ViewHolder(view) {

       val imgProfile: ImageView = view.findViewById(R.id.imgProfile)
       val txtLinkName:TextView = view.findViewById(R.id.txtLinkName)
       val txtdayago:TextView = view.findViewById(R.id.txtdayago)
       val txtclicks :TextView = view.findViewById(R.id.txtclicks)
         val txtLink :TextView = view.findViewById(R.id.txtLink)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return linklist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val link = linklist[position]

        holder.txtLinkName.text = link.title
        holder.txtdayago.text = link.times_ago
        holder.txtclicks.text = link.total_clicks.toString()
        holder.txtLink.text = link.web_link

        if (link.original_image != null) {

            Glide.with(holder.imgProfile.context).load(link.original_image).into(holder.imgProfile)
        }else {

            Glide.with(holder.imgProfile.context)
                .load(R.drawable.photo)
                .into(holder.imgProfile);
        }


    }


}