package com.example.evc3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.evc3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtHello.text = "Bienvenido a AnotaFacil"

        binding.bnvMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.note_list -> {
                    binding.txtHello.text = "Lista"
                    true
                }
                R.id.note_favorite -> {
                    binding.txtHello.text = "Favorito"
                    true
                }
                R.id.note_info -> {
                    binding.txtHello.text = "Info"
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

}