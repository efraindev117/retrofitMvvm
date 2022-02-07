package com.example.retrofitmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitmvvm.databinding.ItemPersonaBinding
import com.example.retrofitmvvm.model.Personaje

class PersonajeAdapter(private val listPersonaje : List<Personaje>)
    : RecyclerView.Adapter<PersonajeAdapter.myViewHolder>(){

    inner class myViewHolder(val binding: ItemPersonaBinding)
    : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val binding: ItemPersonaBinding = ItemPersonaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return myViewHolder(binding)
    }
    //encargado de setear la informacion
    //optener la informacion de un objecto del arreglo en una posicion indicada.
    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        with(holder){
            with(listPersonaje[position]){
                binding.tvNombre.text = name
                binding.tvGenero.text = gender
                Glide.with(itemView.context)
                    .load(image)
                    .into(binding.ivPersonaje)
            }
        }
    }

    override fun getItemCount() = listPersonaje.size

}


