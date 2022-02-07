package com.example.retrofitmvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitmvvm.adapter.PersonajeAdapter
import com.example.retrofitmvvm.api.ApiPersonajeService
import com.example.retrofitmvvm.databinding.ActivityMainBinding
import com.example.retrofitmvvm.model.ResultPersonaje
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var api_service : ApiPersonajeService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val response = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.apply {
            setHasFixedSize(true)
        }

        api_service = response.create<ApiPersonajeService>(ApiPersonajeService::class.java)
        getAll()
    }

    private fun getAll() {
            api_service.getAllPersonajes().enqueue(
                object : Callback<ResultPersonaje>{
                override fun onResponse(
                    call: Call<ResultPersonaje>,
                    response: Response<ResultPersonaje>
                ) {
                    val listaPersonaje  = response.body()!!.results
                    binding.recyclerView.adapter = PersonajeAdapter(listaPersonaje)
            }
            override fun onFailure(call: Call<ResultPersonaje>, t: Throwable) {

            }
        })
    }
}