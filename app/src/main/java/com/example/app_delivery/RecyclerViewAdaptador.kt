package com.example.app_delivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerViewAdaptador(private val platillos: List<Platillo>) :

    RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.NombrePlatillo)
        val descripcion: TextView = itemView.findViewById(R.id.DescriptionPlatillo)
        val imgPlatillo: ImageView = itemView.findViewById(R.id.imagePlatillo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_platiyos, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val platillo = platillos[position]
        holder.nombre.text = platillo.nombre
        holder.descripcion.text = platillo.descripcion
        Picasso.get().load(platillo.imgPlatillo).into(holder.imgPlatillo)
    }

    override fun getItemCount(): Int {
        return platillos.size
    }
}
