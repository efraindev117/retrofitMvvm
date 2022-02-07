package com.example.retrofitmvvm.api

import com.example.retrofitmvvm.model.Personaje
import com.example.retrofitmvvm.model.ResultPersonaje
import retrofit2.Call
import retrofit2.http.GET

interface ApiPersonajeService {
    @GET("character")
    fun getAllPersonajes() : Call<ResultPersonaje>
       // fun getAllPersonajes() : Call<List<Personaje>>
}
